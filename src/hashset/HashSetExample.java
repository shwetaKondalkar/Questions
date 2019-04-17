package hashset;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetExample {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
HashSet<String> set = new HashSet();
         int count = 0;
         for(int i=0;i<t;i++){
             String str = pair_left[i]+" "+pair_right[i];
             if(!set.contains(str)){
                  set.add(str);
                  count++;
             }
             System.out.println(count);
         }
//Write your code here

   }
}
