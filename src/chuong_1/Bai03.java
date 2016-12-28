// 3.	Tìm số trung gian của 3 số a,b,c

package chuong_1;

public class Bai03 {
	public static void main(String[] args) {
		int a = 0, b = 2, c = 1;
		System.out.println("Số trung gian của " + a + ", " + b + ", " + c
				+ " là: " + new Bai03().soTrungGian(a, b, c));
	}

	// Phương thức tìm số trung gian
	private int soTrungGian(int a, int b, int c) {
		return Math.min(Math.max(a, b), Math.max(Math.min(a, b), c));
	}
}
