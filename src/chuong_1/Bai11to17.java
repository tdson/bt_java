/* 11.	Nhập một số và kiểm tra có phải nguyên tố không?
 * 12.	Kiểm tra số P có phải là số chính phương không?
 * 13.	Kiểm tra số M có phải là số đối xứng không?
 * 14.	In ra các số nguyên tố nhỏ hơn hoặc bằng số nguyên dương n cho trước
 * 15.	In ra các số hoàn hảo nhỏ hơn 1000
 * 		( Ví dụ : 6=1+2+3, 28=1+2+4+7+14)
 * 16.	In ra n chữ số fibonacci đầu tiên
 * 17.	Kiểm tra số K có thuộc dãy fibonacci hay không?
 */

package chuong_1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Bai11to17 {
	public static void main(String[] args) {
		System.out.print("Nhập vào một số nguyên: ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		if (n < 0) {
			System.out.println("Nhập sai!");
		} else {
			Bai11to17 bt = new Bai11to17();
			int choice;
			do {
				System.out.println("\nChọn công việc:");
				System.out.println("1. (Bài 11) Kiểm tra số nguyên tố");
				System.out.println("2. (Bài 12) Kiểm tra số chính phương");
				System.out.println("3. (Bài 13) Kiểm tra số đối xứng");
				System.out
						.println("4. (Bài 14) In ra các số nguyên tố nhỏ hơn hoặc bằng "
								+ n);
				System.out
						.println("5. (Bài 15) In ra các số hoàn hảo nhỏ hơn 1000");
				System.out.println("6. (Bài 16) In ra " + n
						+ " chữ số Fibnaci đầu tiên");
				System.out.println("7. (Bài 17) Kiểm tra số " + n
						+ " có thuộc dãy fibonacci không");
				System.out.println("0. Thoát");
				System.out.print(">> Chọn: ");
				choice = kb.nextInt();

				switch (choice) {
				case 1:
					bt.ktNguyenTo(n);
					break;
				case 2:
					bt.ktChinhPhuong(n);
					break;
				case 3:
					bt.ktDoiXung(n);
					break;
				case 4:
					bt.inSoNT(n);
					break;
				case 5:
					bt.inSoHoanHao();
					break;
				case 6:
					bt.inFibonacci(n);
					break;
				case 7:
					bt.ktFibonacci(n);
					break;
				default:
					break;
				}
			} while (choice != 0);
			System.out.println("Tạm biệt!");
			kb.close();
		}
	}

	// Phương thức kiểm tra một số có nằm trong dãy fibonacci không
	private void ktFibonacci(int n) {
		// SIZE là kích cỡ của dãy fibonacci.
		int SIZE = 0;
		/*
		 * Để tối ưu tốc độ thuật toán. Nếu số nhập vào nhỏ thì chỉ cần tìm kiếm
		 * trong một size nhỏ thôi nhằm tiết kiệm thời gian
		 */
		if (n < 10000)
			SIZE = 20;
		else
			// Kích thước tối đa mà kiểu double cho phép là 46
			SIZE = 46;
		// Bắt đầu vòng lặp và so sánh
		double f;
		// Làm tròn đến hàng đơn vị vì f kiểu double nên có dấu chấm thập
		// phân.
		boolean isFibonacci = false;
		DecimalFormat df = new DecimalFormat("0");
		for (int i = 1; i <= SIZE; i++) {
			f = (1 / Math.sqrt(5) * (Math.pow(((1 + Math.sqrt(5)) / 2), i) - Math
					.pow(((1 - Math.sqrt(5)) / 2), i)));
			Integer fibonacci = new Integer(df.format(f));
			if (fibonacci == n) {
				// Nếu n là số fibonacci thì in kết quả, dừng vòng lặp
				System.out.println(n + " nằm trong dãy Fibonacci.");
				isFibonacci = true;
				break;
			} else
				continue;
		}
		// In ra kết quả không phải số fibonacci sau khi dừng vòng lặp và không
		// tìm thấy
		if (!isFibonacci)
			System.out.println(n + " không nằm trong dãy Fibonacci.");
	}

	// Phương thức in ra n chữ số fibonacci đầu tiên
	private void inFibonacci(int n) {
		/*
		 * Công thức tổng quát của số Fibonacci X = (1/√5).(((1+√5)/2)^n -
		 * ((1-√5)/2)^n)
		 */
		if (n > 46) {
			System.out.println("Không đủ bộ nhớ!");
		} else {
			System.out.print(n + " chữ số Fibonacci đầu tiên: ");
			double f;
			// Làm tròn đến hàng đơn vị vì f kiểu double nên có dấu chấm thập
			// phân.
			DecimalFormat df = new DecimalFormat("0");
			for (int i = 1; i <= n; i++) {
				f = (1 / Math.sqrt(5) * (Math.pow(((1 + Math.sqrt(5)) / 2), i) - Math
						.pow(((1 - Math.sqrt(5)) / 2), i)));
				Integer fibonacci = new Integer(df.format(f));
				System.out.print(fibonacci + " ");
			}
		}
	}

	// Phương thức in ra các số hoàn hảo nhỏ hơn 1000
	private void inSoHoanHao() {
		System.out.print("Dãy số hoàn hảo nhỏ hơn 1000: ");
		int temp_tong = 0;
		for (int i = 2; i < 1000; i++) {
			for (int j = 1; j < i; j++) {
				if (ktUoc(j, i)) {
					temp_tong += j;
				}
			}
			if (temp_tong == i) {
				System.out.print(i + " ");
			}
			temp_tong = 0;
		}
	}

	// Phương thức kiểm tra n ước số cua m hay khong
	private boolean ktUoc(int n, int m) {
		if (m % n == 0)
			return true;
		else
			return false;
	}

	// Phương thức in ra các số nguyên tố nhỏ hơn n
	private void inSoNT(int n) {
		if (n < 2)
			System.out.println("Không có số nguyên tố nhỏ hơn " + n);
		else {
			System.out.println("Dãy số nguyên tố nhỏ hơn " + n);
			for (int i = 2; i <= n; i++) {
				int count = 0;
				for (int j = 2; j < i; j++) {
					if (i % j == 0)
						count++;
				}
				if (count == 0) {
					System.out.println(i);
				}
			}
		}
	}

	// Phương thức kiểm tra tính đối xứng của một số
	private void ktDoiXung(int n) {
		// Nếu n là số đối xứng thì chuỗi số đảo ngược của nó bằng chính nó
		// Chuyển số thành xâu
		String str = n + "";
		String tmp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			tmp += str.charAt(i);
		}
		int reverseNo = Integer.parseInt(tmp);
		if (reverseNo == n) {
			System.out.println(n + " là số đối xứng.");
		} else {
			System.out.println(n + " không phải số đối xứng.");
		}
	}

	// Phuong thuc kiem tra N co phai la so chinh phuong khong
	private void ktChinhPhuong(int n) {
		boolean flag = false;
		if (n == 1) {
			System.out.println(n + " là số chính phương.");
		} else {
			for (int i = 2; i <= n / 2; i++) {
				if (i * i == n) {
					flag = true;
				}
			}
			if (flag)
				System.out.println(n + " là số chính phương.");
			else
				System.out.println(n + " không phải là số chính phương.");
		}
	}

	// Phuong thuc kiem tra so N co phai la so nguyen to khong
	private void ktNguyenTo(int N) {
		if (N < 2)
			System.out.println(N + " khong phai la so nguyen to.");
		else {
			int count = 0;
			for (int i = 2; i < (N / 2 + 1); i++)
				if (N % i == 0)
					count++;
			if (count == 0)
				System.out.println(N + " la so nguyen to.");
			else
				System.out.println(N + " khong phai la so nguyen to.");
		}
	}
}
