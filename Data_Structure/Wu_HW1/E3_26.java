import java.util.Scanner;

public class E3_26{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = input.nextInt();
        boolean divide1 = (integer % 5 == 0) && (integer % 6 == 0);
        System.out.println("Is " + integer + " divisible by 5 and 6? " + divide1);
        boolean divide2 = (integer % 5 == 0) || (integer % 6 == 0);
        System.out.println("Is " + integer + " divisible by 5 or 6? " + divide2);
        boolean divide3 = (integer % 5 == 0) ^ (integer % 6 == 0);
        System.out.println("Is " + integer + " divisible by 5 or 6, but not both? " + divide3);
    }
}