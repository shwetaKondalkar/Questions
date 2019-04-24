package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DeleteByIndex{

    public static void main (String... strings){

        Scanner sc = new Scanner (System.in);
        int listSize = sc.nextInt();
        List <Integer> list = new ArrayList<>();
        
        for (int i = 0;i<listSize;i++){
            list.add(i, sc.nextInt());
        }
        
        int numQueries = sc.nextInt();
        while (numQueries-->0){
            sc.nextLine();
            String operation = sc.nextLine();
            if (operation.equals("Insert"))list.add(sc.nextInt(),sc.nextInt());
            if (operation.equals("Delete"))list.remove(sc.nextInt());
        } 
        sc.close();
        list.forEach((element)->{System.out.print(element.intValue()+" ");});
    }
}