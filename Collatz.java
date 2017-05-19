import java.io.*;
import java.util.Scanner;

public class Collatz {

	public static int length = 1;
	public static int[] table;
	public static int a;
	public static int b;
	public static double mult = 0.55;

	private static int collatzLength(long x)
	{
		//returns collatz length for x
		if (x > 1 && (x < ((int)((b*mult)-1))) && table[(int)x] != 0)
		{
			return table[(int)x] + length;
		}
		if (x == 1) {
			return length;
		}
		else if (x % 2 == 0) {
			x = x / 2;
		}
		else {
			x = (3 * x) + 1;
		}
		length++;
		//System.out.println(x);
		return collatzLength(x); 
	}


	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range: ");
		a = sc.nextInt();
		b = sc.nextInt();
		table = new int[(int)(b*mult)];
		int maxCollatz = 0;
		int maxNum = 0;
		int temp;
		for (int i = a; i <= b; i++) {
			length = 0;
			temp = collatzLength(i);
			if (i < (int)(b*mult)) {
				table[i] = temp;
			}
			if (temp > maxCollatz) {
				maxCollatz = temp + 1;
				maxNum = i;
			}
		}
		System.out.println("The number with the maximum Collatz length in the range: " + maxNum);
		System.out.println("Its Collatz length: " + maxCollatz);
	}
}