package chuong_2;

class PointA {
	// This is a mere sketch
	int _x;
	int _y;

	public PointA(int x, int y) {
		_x = x;
		_y = y;
	}

	public String toString() {
		return "(" + _x + "," + _y + ")";
	} // sample output: "(2,3)"
}

abstract class Shape {
	private PointA _origin;

	public PointA getOrigin() {
		return _origin;
	}

	public Shape() {
		_origin = new PointA(0, 0);
	}

	public Shape(int x, int y) {
		_origin = new PointA(x, y);
	}

	public Shape(PointA o) {
		_origin = o;
	}

	abstract public void draw(); // deliberately unimplemented
}

class Circle extends Shape {
	double radius;

	public Circle(double rad) {
		super();
		radius = rad;
	}

	public Circle(int x, int y, double rad) {
		super(x, y);
		radius = rad;
	}

	public Circle(PointA o, double rad) {
		super(o);
		radius = rad;
	}

	public void draw() {
		System.out.println("Circle@" + getOrigin().toString() + ", rad = "
				+ radius);
	}

	static public void main(String argv[]) {
		Circle circle = new Circle(1.0);
		circle.draw();
	}
}
