public class E5_11{
    public static void main(String[] args){
        int count = 0;
        final int NUMBER_OF_RESULTS_PER_LINE = 10;
        
        for (int number = 100; number <= 200; number++){
            boolean isResult = true;
            if(number % 5 != 0 && number % 6 != 0)
                isResult = false;
                
            if(isResult){
                count++;
                if (count % NUMBER_OF_RESULTS_PER_LINE == 0 || number == 200)
                    System.out.println(number);
                else
                    System.out.print(number + " ");                
            }
        }
    }
}