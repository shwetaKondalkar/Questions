package stringQuestions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CheckIfPangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {

return s.chars().filter(Character::isLetter) //
        .map(Character::toLowerCase) //
        .distinct().count() == 26 ? "pangram" : "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
