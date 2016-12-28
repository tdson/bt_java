package chuong_2;

class BoxA {
	int width, height, depth;

	BoxA() {
		width = 0;
		height = 0;
		depth = 0;
	}

	BoxA(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int volumeBox() {
		return width * height * depth;
	}
}// end of class
// -----------------------------------------------------------------

class SubBox extends BoxA {
	// SubBox ke thua cac dac tinh cua Box va co them weight
	// SubBox khong can phai tao lai cac dac diem da co trong Box
	// Tinh ke thua cho phep co the tao cac lop con rieng biet tu lop Box
	int weight;

	SubBox(int width, int height, int depth, int weight) {
		/*
		 * Cach 1 this.width = width; this.height = height; this.depth = depth;
		 * this.weight = weight;
		 */
		/* Cach 2 */
		super(width, height, depth);
		this.weight = weight;
	}

//	public int volumeBox() {
//		return width * height * depth;
//	}
}// end of class
// -----------------------------------------------------------------

class JavaExample03 {
	public static void main(String args[]) {
		SubBox obj1 = new SubBox(2, 3, 4, 5);
		System.out.println(">> The tich 1 = " + obj1.volumeBox());
		System.out.println(">> Trong luong = " + obj1.weight);
	}
}
