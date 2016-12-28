package chuong_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai6_4 {
	public static void main(String[] args) {
		try {
			System.out.print("Số phần tử của mảng: ");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(
					System.in));
			int n = Integer.parseInt(keyboard.readLine());
			int[] a = new int[n];
			// Nhập mảng
			for (int i = 0; i < n; i++) {
				System.out.print("Nhập phần tử thứ " + i + ": ");
				a[i] = Integer.parseInt(keyboard.readLine());
			}

			// Tính tổng các số dương lẻ
			System.out.print("a. Tổng các số dương lẻ: ");
			int tong = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] % 2 != 0 && a[i] > 0)
					tong += a[i];
			}
			System.out.println(tong);

			// Kiểm tra phần tử
			System.out.print("b. Nhập số nguyên k = ");
			int k = Integer.parseInt(keyboard.readLine());
			int index = -1;
			for (int i = 0; i < n; i++) {
				if (a[i] == k) {
					index = i;
					break;
				}
			}
			if (index != -1)
				System.out.println(">> " + k
						+ " có trong mảng, là phần tử thứ " + index);
			else
				System.out.println(">> " + k + " không nằm trong mảng.");

			// Sắp xếp mảng
			a = quickSort(a);
			System.out.println("c. Mảng sắp xếp tăng dần: ");
			for (int i = 0; i < n; i++) {
				System.out.print(" " + a[i] + " ");
			}

			// Thêm phần tử vào mảng
			System.out.print("\nNhập phần tử muốn chèn: ");
			int e = Integer.parseInt(keyboard.readLine());
			int[] b = new int[a.length + 1];
			b = insertElement(e, a);
			// In lại mảng đã chèn
			System.out.println("Mảng hiện tại: ");
			for (int i = 0; i < b.length; i++) {
				System.out.print(" " + b[i] + " ");
			}
		} catch (NumberFormatException e) {
			System.out.println("Số không đúng.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] insertElement(int e, int[] a) {
		int[] tmp = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			tmp[i] = a[i];
		}
		tmp[a.length] = e;
		quickSort(tmp);
		return tmp;
	}

	// Hàm tìm kiếm trả về vị trí của phần tử trong mảng
	// Nếu giá trị trả về = -1 nghĩa là không tìm thấy
	public static int binarySearch(int[] a, int e) {
		int left = 0, right = a.length - 1, midle;
		int index = -1;
		do {
			midle = (left + right) / 2;
			if (e == a[midle])
				index = midle;
			else if (e < a[midle])
				right = midle - 1;
			else
				left = midle + 1;
		} while (left <= right);
		return index;
	}

	public static int[] quickSort(int[] a) {
		return Sort(a, 0, a.length - 1);
	}

	private static int[] Sort(int[] a, int t, int p) {
		int i, j;
		int x;
		x = a[(t + p) / 2]; // chon phan tu o giua lam moc
		i = t;
		j = p;
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		} while (i < j);
		if (t < j)
			Sort(a, t, j);
		if (i < p)
			Sort(a, i, p);
		return a;
	}
}
