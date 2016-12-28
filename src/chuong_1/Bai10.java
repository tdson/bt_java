/*10.	Tính tổng và tích các chữ số của một số nguyên dương m cho trước
 *(Ví dụ : m=234=> S=2+3+4=9, P=2*3*4=24)
 */

package chuong_1;

import java.util.Scanner;

public class Bai10 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhập vào số nguyên dương: ");
			n = keyboard.nextInt();
		} while (n <= 0);

		int m = n;
		keyboard.close();

		int s = 0, p = 1;
		while (n != 0) {
			s += n % 10;
			p *= n % 10;
			n /= 10;
		}
		
		System.out.println("\nTổng các chữ số của " + m + " là: " + s);
		System.out.println("Tích các chữ số của " + m + " là: " + p);
	}
}
