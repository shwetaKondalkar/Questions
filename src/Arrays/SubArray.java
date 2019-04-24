package Arrays;

import java.util.Scanner;

public class SubArray {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
		  a[i]=scan.nextInt();
		}
		int count=0;
		     for(int j=0;j<n;j++)
		     {
		         for(int sum=0,k=j;k<n;k++)
		         {
		             sum=sum+a[k];
		             if(sum<0)
		             {
		                count++;
		             }
		         }
		     }
		     System.out.println(count);
		 }
}
