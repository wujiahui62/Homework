package exercise13_5;

public abstract class GeometricObject implements Comparable<GeometricObject>{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject(){
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled){
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		return filled;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated(){
		return dateCreated;
	}
	
	@Override
	public String toString(){
		return "created on " + dateCreated + "\ncolor: " + color + 
				" and filled: " + filled;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public static void max(GeometricObject a, GeometricObject b){
		if(a.compareTo(b) == 1)
			System.out.println(a + " has larger area");
		else if(a.compareTo(b) == -1)
			System.out.println(b + " has larger area");
		else
			System.out.println("The areas of " + a + " and " + b + " are equal");
			
	}		
}

