package ad.praktikum1;


public class Main {

	public static void main(String[] args) {
// Test for Auf4
//	    "10 + 2 * 6"            ---> 22     26
//	    "100 * 2 + 12"          ---> 212
//	    "100 * ( 2 + 12 )"      ---> 1400
//	    "100 * ( 2 + 12 ) / 14" ---> 100 
		System.out.println(EvaluateExpressionUsingStacks.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateExpressionUsingStacks.evaluate("100 * ( 2 + 12 ) / 14"));

// Code for Auf5
//		int count = 0;
//		int leng = 100;
//		int[] a = new int[leng];
//		for (int i = 0; i < leng; i++) {
//			a[i] = leng - i;
//		}
//		int min = a[0];
//		int max = a[leng -1];
//		
//		for (int i = 0; i <= leng / 2; i++) {
//			if (a[i] >= a[leng - i - 1]) {
//				int temp = a[i];
//				a[i] = a[leng - i - 1];
//				a[leng - i - 1] = temp;
//			}
//			count++;		
//		}
//		
//		for (int i = 0; i <= leng / 2; i++) {
//			if (a[i] < min) {
//				min = a[i];
//			}
//			count++;
//		}
//		
//		for(int i = leng - 1; i > leng / 2; i--) {
//			if(a[i] > max) {
//				max = a[i];
//			}
//			count++;
//		}
//		
//		System.out.println("max = " + max);
//		System.out.println("min = " + min);
//		System.out.println("so buoc = " + count);

	}

}
