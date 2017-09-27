import java.util.Scanner;

public class E6_17{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();
        printMatrix(n);
    }
    public static void printMatrix(int n){
        for(int i = 1; i <= n * n; i++){
            int random = (int)(Math.random()*2);
            if(i % n == 0)
                System.out.printf("%2d\n", random);
            else
                System.out.printf("%2d", random);
        }
    }
}