// 1.	Giải phương trình bậc nhất : ax+b=0

package chuong_1;

public class Bai01 {
	public static void main(String[] args) {
		new Bai01().giaiPTBacNhat(3, 5);
	}
	
	// Phương thức giải phương trình bậc nhất
	public void giaiPTBacNhat(double a, double b) {
		if(a != 0) System.out.println("Phương trình " + a + "x +" + b + " = 0 có nghiệm: " + (-b/a));
		else System.out.println("Phương trình không tồn tại.");
	}
}
