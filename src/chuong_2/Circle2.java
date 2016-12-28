package chuong_2;
/*
interface Figure {
	public void move(PointA p) throws Exception;

	public void draw() throws Exception;

	public double area() throws Exception;

	public double PI = 3.14159;
}

abstract class Shape implements Figure {
	private PointA origin;

	public PointA getOrigin() {
		return origin;
	}

	public Shape() {
		origin = new Point(0, 0);
	}

	public Shape(int x, int y) {
		origin = new Point(x, y);
	}

	public Shape(Point o) {
		origin = o;
	}

	public void move(Point p) {
		origin = p;
	}
}

// Lớp Circe kế thừa từ lớp Shape.
public class Circle2 extends Shape {
	double radius;

	public Circle2(double rad) {
		super();
		radius = rad;
	}

	public Circle2(int x, int y, double rad) {
		super(x, y);
		radius = rad;
	}

	public Circle2(Point o, double rad) {
		super(o);
		radius = rad;
	}

	public double area() {
		return PI * radius * radius;
	}

	public void draw() {
		System.out.println("Circle@" + getOrigin().toString() + ", rad = "
				+ radius);
	}

	static public void main(String argv[]) {
		Circle circle = new Circle(2.0);
		circle.draw();
		circle.move(new Point(1, 1));
		circle.draw();
		System.out.println("circle area = " + circle.area());
	}
}
*/