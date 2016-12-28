package chuong_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Viết chương trình thực hiện các công việc sau: a. Nhập ma trận a (m dòng, n
 * cột) gồm các phần tử kiểu int b. Tính tích các số bội 3 nằm trên dòng đầu
 * tiên của ma trận a. c. Tạo ra mảng một chiều X[i] là các giá trị lớn nhất
 * trên dòng i của ma trận a d. Xoá đi phần tử đầu tiên của mảng X[i], xuất lại
 * mảng X[i].
 */

public class Bai6_5 {

	public static void main(String[] args) {
		int a[][], x[] = null, row = 1, col = 1;
		Bai6_5 obj = new Bai6_5();
		// Nhập số lượng phần tử
		try {
			do {
				System.out.println("a. Nhập ma trận: ");
				System.out.print("Nhập số hàng ma trận: ");
				row = obj.nextInt();
				System.out.print("Nhập số cột ma trận: ");
				col = obj.nextInt();
			} while (row < 1 || col < 1);
		} catch (IOException e) {
		}

		// Cap phat vung nho cho ma tran a
		a = new int[row][col];
		x = new int[row];

		// Nhap so lieu ma tran a
		obj.inputMatrix(a, row, col);

		// In ra ma tran a
		System.out.println("\n>> Ma trận vừa nhập vào: ");
		obj.printMatrix(a, row, col);

		// Đếm số bội 3 trên cột đầu tiên
		System.out.print("b. Tích các bội số của 3 ở dòng đầu tiên: "
				+ obj.tinhTich(a, col));

		// Tạo mảng x[i] chứa các phần tử max của dòng thứ i của ma trận a và
		// xuất ra màn hình
		obj.extractMax(a, row, col, x);
		System.out.print("\nc. Mảng X gồm các phần tử MAX của mỗi dòng: ");
		obj.printArray(x);
		System.out.print("Mảng X sau khi xóa phần tử đầu tiên: ");
		obj.printArray(obj.deleteElement(x));
	}

	// Hàm nhập số nguyên
	public int nextInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return Integer.parseInt(str);
	}

	// Phương thức nhập ma trận
	public void inputMatrix(int[][] x, int row, int col) {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				System.out
						.print("Phần tử [" + (i + 1) + "," + (j + 1) + "] = ");
				try {
					x[i][j] = nextInt();
				} catch (IOException e) {
				}
			}
	}

	// Phương thức in ra ma trận
	public void printMatrix(int[][] x, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(" " + x[i][j] + " ");
			System.out.print("\n");
		}
	}

	// Phương thức đếm các số chia hết cho 3 ở hàng 1
	public int tinhTich(int[][] x, int col) {
		int p = 1;
		for (int i = 0; i < col; i++) {
			if (x[0][i] % 3 == 0)
				p *= x[0][i];
		}
		return p;
	}

	public void extractMax(int[][] x, int row, int col, int[] y) {
		// int i,j;
		for (int i = 0; i < row; i++) {
			y[i] = x[i][0];
			for (int j = 0; j < col - 1; j++) {

				if (y[i] < x[i][j + 1])
					y[i] = x[i][j + 1];
			}
		}
	}

	// Phương thức xóa phần tử đầu của mảng.
	public int[] deleteElement(int[] x) {
		int[] tmp = new int[x.length - 1];
		for (int i = 1; i < x.length; i++) {
			tmp[i - 1] = x[i];
		}
		return tmp;
	}

	// Phương thức xuất mảng
	public void printArray(int[] x) {
		for (int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
		System.out.print("\n");
	}

}