/* 4.	Viết chương trình tính tiền cho bài toán KaraOke
			+ Giờ bắt đầu : a (int)
			+ Giờ kết thúc : b (int)
			+ Nếu nhỏ hơn 18h : 45000đ/1h, lớn hơn 18h : 60000đ/1h
 */

package chuong_1;

public class Bai04 {
	/*
	 * Thời gian bắt đầu (startTime) và thời gian kết thúc (endTime)
	 */
	public int tinhTien(int startTime, int endTime) {
		// Giả sử mặc định bắt đầu hát trước 18h và hát xong sau 18h
		int cost = (18-startTime)*45000 + (endTime-18)*60000;
		// Nếu hát xong trước 18h
		if(endTime<18)
			cost = (endTime - startTime) * 45000;
		// Nếu bắt đầu hát sau 18h
		if(startTime>18)
			cost = (endTime - startTime) * 60000;
		return cost;
	}

	public static void main(String[] args) {
		System.out
				.print("Số tiền: " + new Bai04().tinhTien(16, 20) + "VNĐ");
	}
}
