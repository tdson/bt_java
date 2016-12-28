/* 9.	  Tính n!!	=	1*3*5*…..*n(n lẽ)
 *			=	2*4*6*….*n(n chẵn)
 * */
package chuong_1;

public class Bai09 {
	public static void main(String[] args) {
		System.out.println(new Bai09().giaiThuaKep(9));
	}

	public long giaiThuaKep(int n) {
		long gt = 1;
		for (int i = (n % 2 == 0 ? 2 : 1); i <= n; i += 2)
			gt *= i;
		return gt;
	}
}
