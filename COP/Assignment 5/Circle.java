

public class Circle {
	
	int radius;
	
	Circle (int rad) {
		radius=rad;
	}

	double calArea() {
		return Math.PI * radius * radius;
	}

	double calPerimeter() {
		return Math.PI * radius * 2;
	}
}
