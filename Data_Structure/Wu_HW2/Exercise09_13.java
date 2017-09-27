import java.util.Scanner;

public class Exercise09_13{
 public static void main(String[] args){
  Scanner input = new Scanner(System.in);
  
  System.out.print("Enter the number of rows and columns in the array: ");
  int rows = input.nextInt();
  int columns = input.nextInt();
  
  double[][] array = new double[rows][columns];
  
  System.out.println("Enter the array: ");
  for(int i = 0; i < rows; i++){
   for(int j = 0; j < columns; j++){
    array[i][j] = input.nextDouble();
   }
  }
  
  Location x = locateLargest(array);
    
  System.out.println("The location of the largest element is " + x.maxValue + 
  " at (" + x.row + ", " + x.column + ")");
 }
 
 public static Location locateLargest(double[][] a){
  return new Location(a);
  }

}