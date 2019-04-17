package lambdaExp;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Expressions {
	
	private static boolean isPrime(int number) {
	    IntPredicate isDivisible = index -> number % index == 0;
	    return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
	  }

	  public boolean isPalindromeUsingIntStream(String text) {
	    String temp  = text.replaceAll("\\s+", "").toLowerCase();
	    return IntStream.range(0, temp.length() / 2)
	      .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
	}
	  
	  public static PerformOperation is_odd(){
	        return (int a) -> a % 2 != 0;
	    }
	    
	    public static PerformOperation is_prime(){
	        return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
	    }
	    
	    public static PerformOperation is_palindrome(){
	        return (int a) ->  Integer.toString(a).equals( new StringBuilder(Integer.toString(a)).reverse().toString() );
	    }

}
