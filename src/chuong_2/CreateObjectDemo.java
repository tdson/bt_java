package chuong_2;

class Rectangle {
	public int width = 0;
	public int height = 0;
	public PointA origin;

	// four constructors
	public Rectangle() {
		origin = new PointA(0, 0);
	}

	public Rectangle(PointA p) {
		origin = p;
	}

	public Rectangle(int w, int h) {
		this(new PointA(0, 0), w, h);
	}

	public Rectangle(PointA p, int w, int h) {
		origin = p;
		width = w;
		height = h;
	}

	// a method for moving the rectangle
	public void move(int x, int y) {
		origin._x = x;
		origin._y = y;
	}

	// a method for computing the area of the rectangle
	public int area() {
		return width * height;
	}
}

public class CreateObjectDemo {
	public static void main(String[] args) {
		// create a point object and two rectangle objects
		PointA origin_one = new PointA(23, 94);
		Rectangle rect_one = new Rectangle(origin_one, 100, 200);
		Rectangle rect_two = new Rectangle(50, 100);
		// display rect_one's width, height, and area
		System.out.println("Width of rect_one: " + rect_one.width);
		System.out.println("Height of rect_one: " + rect_one.height);
		System.out.println("Area of rect_one: " + rect_one.area());
		// set rect_two's position
		rect_two.origin = origin_one;

		// display rect_two's position
		System.out.println("X Position of rect_two: " + rect_two.origin._x);
		System.out.println("Y Position of rect_two: " + rect_two.origin._y);
		// move rect_two and display its new position
		rect_two.move(40, 72);
		System.out.println("X Position of rect_two: " + rect_two.origin._x);
		System.out.println("Y Position of rect_two: " + rect_two.origin._y);
	}
}
