package exercise13_6;

public class Exercise13_6 {
	public static void main(String[] args) {
		//find the larger ComparableCircle object
		ComparableCircle a = new ComparableCircle(5);
		ComparableCircle b = new ComparableCircle(4);
		if(a.compareTo(b) == 1)
			System.out.println(a + " is larger than " + b);
		else if(a.compareTo(b) == -1)
			System.out.println(b + " is larger than " + a);
		else
			System.out.println(a + " and " + b + " are equal");
	}
}
