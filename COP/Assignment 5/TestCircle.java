/*
 Q2. Create a class Circle, it will have only one constructor which accepts radius as an argument. Write two methods in the class - calcuateArea(), calculatePermiter(). 
Write test class to test method calls.

 */


public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		System.out.printf("Area = %.2f\n", c1.calArea());
		System.out.printf("Perimeter = %.2f", c1.calPerimeter());
	}

}
