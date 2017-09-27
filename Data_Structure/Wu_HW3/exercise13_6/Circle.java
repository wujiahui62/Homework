package exercise13_6;

public class Circle {
	private double radius;
	
	public Circle(){
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public double getArea(){
		return radius * radius * Math.PI;
	}
	
	public double getDiameter(){
		return 2 * radius;
	}
	
	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String toString(){
		return "The circle with radius " + radius;
	}
}
