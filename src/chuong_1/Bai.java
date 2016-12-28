package chuong_1;

import java.util.Scanner;

public class Bai {
	private static Scanner sc;
	public static int congviec;
	public double b6(int n) {
		double s=0;
		for(int i=1; i<=n; i++) s += (double)1/i;
		return s;
	}
	public static long giaithua(int n) {
		long s = 1;
		if(n==1 || n==0) return 1;
		for(int i=1; i<=n; i++) s *= (long)i;
		return s;
	}
	public double b7(int n) {
		double s = 15;
		for(int i=1; i<=n; i++) {
			if(i%2==0) s += (double)1/giaithua(i);
			else s -= (double)1/giaithua(i);
		}
		return s;
	}
	public double b8(int n) {
		double s = 0;
		for(int i=1; i<=n; i++) s += (double)1/giaithua(2*i-1);
		return s;
	}
	public long b9(int n) {
		long s = 1;
		if(n%2==0) for(int i=2; i<=n; i+=2) s *= i;
		else for(int i=1; i<=n; i+=2) s *= i;
		return s;
	}
	public void b10(int n) {
		int s = 0, p = 1;
		if(n<=0) System.out.print("Nhập sai!");
		else {
			System.out.print("\nSố " + n + " có ");
			while(n!=0) {
				s += n%10;	p *= n%10;
				n -= n%10;	n /= 10;
			}
		}
		System.out.print("P = " +p+ ", S = " +s);
	}
	private void menu() {
		System.out.print("\n===========================\n"
				+ "Chọn bài toán cần xử lí: \n"
				+ "6. S=1+1/2+1/3+ … +1/n \n"
				+ "7. S=15-1+1/2-1/3!+ … +(-1)^n.1/n! \n"
				+ "8. S=1+1/3!+1/5!+ … +1/(2n-1)! \n"
				+ "9. S = n!! \n"
				+ "10. S(int), P(int) \n"
				+ "5. Thoát \n"
				+ "Lựa chọn: ");
		sc = new Scanner(System.in);
		do {
			congviec = sc.nextInt();
		} while(congviec<5 || congviec>10); //Nhập công việc ngoài phạm vi thì phải nhập lại.
	}
	public static void main(String[] args) {
		int n;
		Bai mainObj = new Bai(); //Tạo đối tượng MainObjective.
		sc = new Scanner(System.in);
		do {
			mainObj.menu(); //Gọi menu.
			switch(congviec) {//Thực hiện chức năng tương ứng mỗi công việc
			case 5: System.out.print("Tạm biệt!"); break;
			case 6: System.out.print("Nhập n = "); n = sc.nextInt();
					System.out.print("S = " + mainObj.b6(n)); break;
			case 7: System.out.print("Nhập n = "); n = sc.nextInt();
					System.out.print("S = " + mainObj.b7(n)); break;
			case 8: System.out.print("Nhập n = "); n = sc.nextInt();
					System.out.print("S = " + mainObj.b8(n)); break;
			case 9: System.out.print("Nhập n = "); n = sc.nextInt();
					System.out.print("S = " + mainObj.b9(n)); break;
			case 10: System.out.print("Nhập 1 số nguyên: "); n = sc.nextInt();
					mainObj.b10(n); break;
			default: break;
			}
		} while (congviec!=5); //Khi chức năng thoát chưa dùng thì vẫn tiếp tục các việc trên
	}
}
