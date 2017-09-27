package exercise13_6;

public class ComparableCircle extends Circle 
implements Comparable<ComparableCircle>{
	
	public ComparableCircle(double radius){
		super(radius);
	}
	
	public int compareTo(ComparableCircle o) {
		if(getArea() > o.getArea())
			return 1;
		else if(getArea() < o.getArea())
			return -1;
		else 
			return 0;	
	}
}
