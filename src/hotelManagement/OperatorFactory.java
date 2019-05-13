package hotelManagement;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

	static Map<String, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put("regularWeekend", new RegularWeekend() );
        operationMap.put("regularWeekday", new RegularWeekday() );
        operationMap.put("rewardeeWeekend", new RewardeeWeekend() );
        operationMap.put("rewardeeWeekday", new RewardeeWeekday() );


//        operationMap.put("div", );
        // more operators
    }
 
    public static Operation getOperation(String operator) {
        return operationMap.get(operator);
    }
}
