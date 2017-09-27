package exercise13_5;

public class Circle extends GeometricObject{
	private double radius;
	
	public Circle(){
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color, filled);
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

	@Override
	public int compareTo(GeometricObject o){
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else 
			return 0;
	}
}


