package SalesTaxProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ItemFactory {
	 public static List<Item> from(String[] inputs) {
	        return Arrays.stream(inputs)
	                .map(ItemFactory::from)
	                .collect(Collectors.toList());
	    }

	    private static Item from(String input) {
	        Item item = ItemInputFormatter.createItemFromString(input);
	        ItemTaxCalculator.applyTaxes(item);
	        return item;
	    }
}
