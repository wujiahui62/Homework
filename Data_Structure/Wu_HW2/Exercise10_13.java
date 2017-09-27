public class Exercise10_13{
 public static void main(String[] args){
 
  MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
  
  System.out.printf("The area of r1 is %.2f\n", r1.getArea());
  System.out.println("The perimeter of r1 is: " + r1.getPerimeter());
  System.out.println("The point(3, 3) is in r1? " + r1.contains(3,3));
  System.out.println("The rectangle(4, 5, 10.5, 3.2) is in r1? " +
                      r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
  System.out.println("The rectangle(3, 5, 2.3, 5.4) overlaps with r1? " + 
                      r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
  
 }
}