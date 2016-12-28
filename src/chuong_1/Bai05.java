// 5.	Nhập vào tháng, năm bất kỳ. In ra số ngày tương ứng với tháng, năm đó.

package chuong_1;

import java.util.Scanner;

public class Bai05 {
	public static void main(String[] args) {
		// Tạo đối tượng kb để quét phím nhập vào
		Scanner kb = new Scanner(System.in);
		System.out.print("Nhập tháng, năm (MM/YYYY): ");
		// Đọc xâu vào
		String inputStr = kb.nextLine();
		kb.close();
		// Lấy giá trị ngày tháng từ xâu vào
		int month = Integer.parseInt(inputStr.substring(0, 2));
		int year = Integer.parseInt(inputStr.substring(3, 7));

		// In ra số ngày tương ứng với tháng của năm
		System.out.println("Tháng " + month + " có "
				+ new Bai05().timSoNgay(month, year) + " ngày.");
	}

	// hàm tìm số ngày của tháng dựa vào tháng và năm
	private int timSoNgay(int month, int year) {
		// Mặc định tháng có 31 ngày
		int day = 31;
		
		switch (month) {
		// 4, 6, 9, 11 có 30 ngày => sửa lại biến day
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		// Tháng 2 có 28 ngày, nếu nhuận thì có 29 ngày
		case 2:
			// Nếu rơi vào năm nhuận
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				day = 29;
			} else
				// Trường hợp còn lại (không nhuận)
				day = 28;
		}
		return day;
	}
}
