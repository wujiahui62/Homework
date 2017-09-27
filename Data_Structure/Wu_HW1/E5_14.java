import java.util.Scanner;

public class E5_14{
    public static void main(String[] args){
        int gcd = 1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        for (int d = Math.min(n1, n2); d >= 1; d--){
            if (n1 % d == 0 && n2 % d ==0){
            gcd = d;
            break;
            }
        }
        System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " is " + gcd);        
    }
}