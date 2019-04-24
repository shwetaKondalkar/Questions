package marsProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarsExploration {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
 int count = 0;
for(int i =0;i<s.length();){
            if(s.charAt(i)!='S')
             count++;
            if(s.charAt(i+1)!='O')
             count++;
            if(s.charAt(i+2)!='S')
                count++;
            
            i+=3;
        }

    

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
