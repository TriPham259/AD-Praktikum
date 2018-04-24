package ad.praktikum1;

public class Main {

	public static void main(String[] args) {
// Test for Auf4
//	    "10 + 2 * 6"            ---> 12 + 6 = 72
//	    "100 * 2 + 12"          ---> 212
//	    "100 * ( 2 + 12 )"      ---> 1400
//	    "100 * ( 2 + 12 ) / 14" ---> 100 
		System.out.println(EvaluateExpressionUsingStacks.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 ) / 14"));

        int leng = 100;
		int[] a = new int[leng];
		for (int i = 0; i < leng; i++) {
			a[i] = leng - i;
		}
		MinMax.minMax(a);

	}

}
