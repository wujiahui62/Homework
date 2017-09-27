import java.util.Scanner;

public class E3_31{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the exchange rate from dollars to RMB: ");
        double rate = input.nextDouble();
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        int selection = input.nextInt();
        double convertedAmount = 0;
        switch (selection){
            case 0: 
                System.out.print("Enter the dollar amount: ");
                double amount1 = input.nextDouble();
                convertedAmount = amount1 * rate;                
                System.out.printf("$" + amount1 + " is %.2f yuan\n", convertedAmount);
                break;
            case 1: 
                System.out.print("Enter the RMB amount: ");
                double amount2 = input.nextDouble();
                convertedAmount = amount2 / rate;
                System.out.printf(amount2 + " yuan is $%.2f\n", convertedAmount);
                break;
            default: System.out.println("Incorrect input");
                System.exit(1);
        }
    }
}