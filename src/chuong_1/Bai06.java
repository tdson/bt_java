/* 6.	Viết chương trình tính :
 * S=1+1/2+1/3+....+1/n
 */

package chuong_1;

public class Bai06 {
	double S(int n) {
		double s = 0;
		for(int i = 1; i <= n; i++) {
			s += (double)1/i;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(new Bai06().S(3));
	}
}
