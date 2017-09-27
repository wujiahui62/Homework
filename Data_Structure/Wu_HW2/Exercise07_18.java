import java.util.Scanner;

public class Exercise07_18{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double[] numbers = new double[10];
        System.out.print("Enter ten numbers: ");
        for(int i = 0; i < 10; i++)
            numbers[i] = input.nextDouble();
        
        bubbleSort(numbers);
        for(int i = 0; i < numbers.length - 1; i++)
            System.out.print(numbers[i] + " ");
        System.out.println(numbers[9]);
    }
    
    
    //bubbleSort in decreasing order
    public static void bubbleSort(double[] numbers){
        for(int i = numbers.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(numbers[j] < numbers[j + 1]){
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        
    }
}
