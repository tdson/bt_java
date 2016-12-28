package chuong_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai6_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Nhập một xâu bất kỳ: ");
		String str = (String) keyboard.readLine();
		String a = reverseString(str);
		System.out.println("1. Chuỗi đảo ngược: " + "\t\t" + a);
		System.out.println("2. Chuỗi in hoa: " + "\t\t" + str.toUpperCase());
		System.out.println("3. Chuỗi in thường: " + "\t\t" + str.toLowerCase());
		System.out.println("4. Chuỗi in hoa và in thường: " + "\t"
				+ changeLetter(str));
	
	}

	private static String reverseString(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--)
			result += str.charAt(i);
		return result;
	}

	private static String changeLetter(String str) {
		String result = "";
		char tmp;
		for (int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);
			if (tmp >= 'a' && tmp <= 'z') {
				tmp -= 32;
			} else {
				if (tmp >= 'A' && tmp <= 'Z') {
					tmp += 32;
				}
			}
			result += tmp;
		}
		return result;
	}
}
