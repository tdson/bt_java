package chuong_2;

class PointB {
	private double x, y;

	PointB(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double getX() {
		return x;
	}

	double getY() {
		return y;
	}
}

class Square {
	private double width;

	Square(double width) {
		this.width = width;
	}

	double getWidth() {
		return width;
	}
}

class Rectangle1 extends Square {
	private double length;

	Rectangle1(double width, double length) {
		super(width);
		this.length = length;
	}

	double getLength() {
		return length;
	}
}

class Shapes {
	public static void main(String[] args) {
		Square s = new Square(100);
		System.out.println("s.width = " + s.getWidth());
		Rectangle1 r = new Rectangle1(50, 25);
		System.out.println("r.width = " + r.getWidth());
		System.out.println("r.length = " + r.getLength());
	}
}
