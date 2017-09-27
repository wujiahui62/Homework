import java.util.Scanner;

public class Exercise08_6{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double[][] a = new double[3][3];
        double[][] b = new double[3][3];
        System.out.print("Enter matrix1: ");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                a[i][j] = input.nextDouble();
            }
        System.out.print("Enter matrix2: ");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                b[i][j] = input.nextDouble();
            }
        
        double[][] c = multiplyMatrix(a, b);
        
        System.out.println("The multiplication of the matrices is");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) { 
                    System.out.print(a[i][j] + " ");
                    if (i == 1 && j == 2) {
                        System.out.print(" * ");
                    }
                    else {
                        System.out.print("   ");
                    }
                }
                
                for (int j = 0; j < 3; j++) {
                    System.out.print(b[i][j] + " ");
                    if (i == 1 && j == 2) {
                        System.out.print(" = ");
                    }
                    else {
                        System.out.print("   ");
                    }
                }
                
                for (int j = 0; j < 3; j++) {
                    System.out.printf("%.1f    " , c[i][j]);
                }
                System.out.println();
            }
 
        }
     
    public static double[][] multiplyMatrix(double[][]a, double[][]b){
        double[][] c = new double[a.length][a[0].length];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[0].length; j++){
                for(int k = 0; k < c.length; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }            
        } 
        return c;
    }
    
}