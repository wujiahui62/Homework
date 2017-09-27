public class E5_24{
    public static void main(String[] args){
        double sum = 0;
        for (int i = 1; i <= 97; i += 2){
            sum += i / (i + 2.0);
        }
        System.out.printf("The sum of the series is %.4f\n", sum);
    }
}