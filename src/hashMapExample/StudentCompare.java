package hashMapExample;

import java.util.HashMap;
import java.util.Scanner;

public class StudentCompare {

	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
	for(int i=0;i<n;i++)
	{
		String name=in.nextLine();
		int phone=in.nextInt();
        hm.put(name, phone);   
		in.nextLine();
	}
	}
}
