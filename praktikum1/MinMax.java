package ad.praktikum1;

public class MinMax {
	public static void minMax(int[] a) {
		int count = 0;
		int leng = a.length;
		
		
		int min = a[0];
		int max = a[leng -1];
		
		for (int i = 0; i <= leng / 2; i++) {
			if (a[i] >= a[leng - i - 1]) {
				int temp = a[i];
				a[i] = a[leng - i - 1];
				a[leng - i - 1] = temp;
			}
			count++;		
		}
		
		for (int i = 0; i <= leng / 2; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			count++;
		}
		
		for(int i = leng - 1; i > leng / 2; i--) {
			if(a[i] > max) {
				max = a[i];
			}
			count++;
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.println(count + " Vergleichen");

	}
}
