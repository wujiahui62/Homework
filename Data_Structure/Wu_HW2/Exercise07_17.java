import java.util.Scanner;

public class Exercise07_17{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        
        String[] names = new String[numberOfStudents];
        System.out.print("Enter the students' names: ");
        for(int i = 0; i < names.length; i++)
            names[i] = input.next();
            
        double[] scores = new double[numberOfStudents];
        System.out.print("Enter the students' scores: ");
        for(int i = 0; i < names.length; i++)
            scores[i] = input.nextDouble();
            
        sort(scores, names);
        for(int i = 0; i < names.length; i++)
            System.out.println(names[i] + " scores " + scores[i]);
    }
    
    public static void sort(double[] scores, String[] names){
        for(int i = 0; i < names.length - 1; i++){
            double currentMax = scores[i];
            int currentMaxIndex = i;
        
            for(int j = i + 1; j < names.length; j++){
                if(currentMax < scores[j]){
                    currentMax = scores[j];
                    currentMaxIndex = j;
                }
            }
            if(currentMaxIndex != i){
                scores[currentMaxIndex] = scores[i];
                scores[i] = currentMax;
                
                String temp = names[currentMaxIndex];
                names[currentMaxIndex] = names[i];
                names[i] = temp;
            }
        }
    }
}