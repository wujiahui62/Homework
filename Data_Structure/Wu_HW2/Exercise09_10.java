import java.util.Scanner;

public class Exercise09_10{
 public static void main(String[] args){
  Scanner input = new Scanner(System.in);
  System.out.print("Enter a, b, c: ");
  double a = input.nextDouble();
  double b = input.nextDouble();
  double c = input.nextDouble();
 
  QuadraticEquation x = new QuadraticEquation(a, b, c);
  
  if(x.getDiscriminant() < 0)
   System.out.println("The equation has no real roots");
  else if(x.getDiscriminant() == 0)
   System.out.println("The equation has one root " + x.getRoot1());
  else
   System.out.println("The equation has two roots " + x.getRoot1() + " " + x.getRoot2());
 }
}

