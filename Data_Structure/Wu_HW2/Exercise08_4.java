import java.util.Scanner;

public class Exercise08_4{
    public static void main(String[] args){
        int[][] employHours = readInput();
        int total[][] = new int[8][2];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++)
                total[i][1] += employHours[i][j];
            total[i][0] = i;    
        }
        
        selectionSort(total);  
        
        for(int i = 7; i >= 0; i--)
            System.out.println("total weekly working hours of Employee " 
            + total[i][0] + " : " + total[i][1]);
    }
    
    
    public static int[][] readInput(){
        Scanner input = new Scanner(System.in);
        int[][] employHours = new int[8][7];
        System.out.println("Enter the daily hours from Sun to Sat for employee 0 - 7: ");
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 7; j++)
                employHours[i][j] = input.nextInt();
                
            return employHours;
        }

    public static void selectionSort(int[][] list){
        for(int i = 0; i < list.length - 1; i++){
            int currentMin = list[i][1];
            int currentMinIndex = i;
            
                for(int j = i + 1; j < list.length; j++){
                    if(currentMin > list[j][1]){
                        currentMin = list[j][1];
                        currentMinIndex = j;
                    }   
                }
                
                if(currentMinIndex != i){
                    list[currentMinIndex][0] = list[i][0];
                    list[i][0] = currentMinIndex;
                    list[currentMinIndex][1] = list[i][1];
                    list[i][1] = currentMin;
                }
        }   
    }
        
}