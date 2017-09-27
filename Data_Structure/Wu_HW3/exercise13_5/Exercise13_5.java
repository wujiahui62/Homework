package exercise13_5;

public class Exercise13_5 {
	public static void main(String[] args) {
		//Test max method
		GeometricObject a = new Circle(5);
		GeometricObject b = new Circle(6);
		GeometricObject c = new Rectangle(12, 6);
		GeometricObject d = new Rectangle(15, 10);
		GeometricObject.max(a, b);
		GeometricObject.max(c, d);
		GeometricObject.max(b, c);
		GeometricObject.max(b, d);
	}
}


