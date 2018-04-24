package ad.praktikum1;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
// Test for Auf4
//	    "10 + 2 * 6"            ---> 12 + 6 = 72   787108ns
//	    "100 * 2 + 12"          ---> 212           31788ns
//	    "100 * ( 2 + 12 )"      ---> 1400          27564ns
//	    "100 * ( 2 + 12 ) / 14" ---> 100           48720ns
		System.out.println(EvaluateExpressionUsingStacks.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 ) / 14"));

        // Test for Auf5
        int leng = 100;
		int[] a = new int[leng];
		for (int i = 0; i < leng; i++) {
			a[i] = leng - i;
		}

		System.out.println("max = " + MinMax.minMax(a)[0]);
		System.out.println("min = " + MinMax.minMax(a)[1]);
		System.out.println(MinMax.minMax(a)[2] + " Vergleichen");

	}

}
