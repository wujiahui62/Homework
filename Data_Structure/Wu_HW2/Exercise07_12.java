import java.util.Scanner;

public class Exercise07_12{
    public static void main(String[] args){
        int[] list = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        for(int i = 0; i < list.length; i++)
            list[i] = input.nextInt();
        System.out.println(java.util.Arrays.toString(reverse(list)));
    }
    
    public static int[] reverse(int[] list){
        int temp;
        for(int i = 0, j = list.length - 1; i < list.length / 2; i++, j--){
            temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
        return list;
    }
}