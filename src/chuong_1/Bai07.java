/* 7.	Viết chương trình tính : 
 * S=15-1+1/2-1/3!+....+(-1)n  1/n!
 * */

package chuong_1;

public class Bai07 {
	// Hàm tính giai thừa
	public long factorial(int n) {
		long f = 1;
		if (n == 1 || n == 0)
			return 1;
		for (int i = 1; i <= n; i++)
			f *= (long) i;
		return f;
	}

	// Hàm tính giá trị biểu thức
	public double S(int n) {
		double s = 15;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				s += (double) 1 / factorial(i);
			else
				s -= (double) 1 / factorial(i);
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new Bai07().S(3));
	}
}
