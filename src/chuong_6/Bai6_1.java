package chuong_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bai6_1 {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		int a, b;
		try {
			do {
				System.out.print("Nhập vào số a = ");
				a = Integer.parseInt(keyboard.readLine());
				System.out.print("Nhập vào số b = ");
				b = Integer.parseInt(keyboard.readLine());
			} while (a < 1 || b < 1);
			System.out.println("ƯCLN của " + a + " và " + b + ": "
					+ new Bai6_1().ucln(a, b));
			System.out.println("BCNN của " + a + " và " + b + ": "
					+ (a * b / new Bai6_1().ucln(a, b)));
		} catch (Exception e) {
			System.out.println("Số không đúng!");
		}
	}

	private int ucln(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}
}
