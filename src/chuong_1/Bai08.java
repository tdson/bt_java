/* 8.	Viết chương trình tính  :
S=1+1/3!+1/5!+…..+1/(2n-1)!

 * */

package chuong_1;

public class Bai08 {
	public static void main(String[] args) {
		System.out.println(new Bai08().S(5));
	}

	public double S(int n) {
		double s = 0;
		for (int i = 1; i <= n; i++) {
			s += (double)1/new Bai07().factorial(2*i-1);
		}
		return s;
	}
}
