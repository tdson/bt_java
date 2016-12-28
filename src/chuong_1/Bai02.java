// 2.	Phương trình bậc hai : ax2 + bx + c=0

package chuong_1;

public class Bai02 {
	public static void main(String[] args) {
		new Bai02().giaiPTBacHai(3, 0, -1);
	}

	// Phương thức giải PT bậc 2
	public void giaiPTBacHai(double a, double b, double c) {
		if (a == 0)
			if (b == 0)
				if (c == 0)
					System.out
							.println("Phương trình thỏa mãn với mọi giá trị của x.");
				else
					System.out.println("Không tồn tại phương trình.");
			else
				new Bai01().giaiPTBacNhat(b, c);
		else {
			double delta = b * b - 4 * a * c;
			if (delta < 0)
				System.out.println("Phương trình vô nghiệm.");
			else {
				if (delta == 0)
					System.out.println("Phương trình có 1 nghiệm: x = "
							+ (-b / (2 * a)));
				else {
					System.out.println("Phương trình có 2 nghiệm:");
					System.out.println("x1 = "
							+ (-b - Math.sqrt(delta) / (2 * a)));
					System.out.println("x2 = "
							+ (-b + Math.sqrt(delta) / (2 * a)));
				}
			}
		}
	}
}
