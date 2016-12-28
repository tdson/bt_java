package chuong_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Bai6_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Nhập chuỗi của bạn: ");
		String str = keyboard.readLine();
		// Chuẩn hóa chuỗi
		String stdStr = standardize(str);

		// In mỗi từ một hàng
		String[] data = stdStr.split(" ");
		System.out.println("1. Mỗi từ một dòng:");
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

		// Đếm số từ trong câu
		System.out.println("2. Số từ có trong câu: " + countWords(stdStr));

		// Tần suất xuất hiện của từ
		System.out.println("3. Tần suất xuất hiện các từ trong câu:");
		HashMap map = wordFreq(stdStr);
		Iterator i = map.keySet().iterator();
		while (i.hasNext()) {
			String key = (String) i.next();
			System.out.println("- \"" + key + "\"" + " xuất hiện: "
					+ map.get(key) + " lần.");
		}
	}

	// Phương thức chuẩn hóa chuỗi
	private static String standardize(String str) {
		String result;
		// Cắt bỏ các ký tự space đầu và cuối chuỗi
		result = str.trim();
		// Xóa các ký tự space thừa ở giữa câu
		while (result.indexOf("  ") != -1) {
			result = result.replaceAll("  ", " ");
		}
		return result;
	}

	// Phương thức đếm số từ trong chuỗi (phải chuẩn hóa trước)
	private static int countWords(String str) {
		String[] data = str.split(" ");
		return data.length;

		// cách 2
		/*
		 * int count = 0; for (int i = 0; i < str.length(); i++) { if
		 * (str.charAt(i) == ' ') count++; } return ++count;
		 */
	}

	// Phương thức đếm tần suất xuất hiện các từ trong chuỗi
	private static HashMap wordFreq(String str) {
		// Đưa từng từ của xâu vào mảng
		String[] data = str.split(" ");

		// Khởi tạo map: key = từ, value = tần xuất
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// Đưa các phần tử của mảng vào map
		for (int i = 0; i < data.length; i++) {
			// Sử dụng hashmap để lưu trữ "Từ" - "Tần xuất"
			String key = data[i];
			Integer value = 1;

			// Kiểm tra nếu từ đã có trong map rồi
			if (map.containsKey(key)) {
				// Lấy giá trị (tần số) của từ đó
				value = map.get(key);
				// Xóa phần tử đó đi
				map.remove(key);
				// Đưa phần tử vào lại với giá trị tần suất tăng lên 1
				map.put(key, ++value);
				// Nếu từ chưa có trong map thì chỉ put phần tử đó vào map
			} else {
				map.put(key, value);
			}
		}
		return map;
	}

	// Phương thức sắp xếp một HashMap theo #value
	private static HashMap<String, Integer> sort(HashMap<String, Integer> map) {
		Iterator i = map.keySet().iterator();

		return map;
	}
}
