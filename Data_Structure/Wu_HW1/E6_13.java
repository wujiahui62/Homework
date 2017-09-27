public class E6_13{
    //test program
    public static void main(String[] args){
        System.out.println("i          m(i)");
        System.out.println("---------------");
        int i = 20;
        for (int j = 1; j <= i; j++)
            System.out.printf("%-8d%.4f\n", j, m(j));
    }
    //method to compute the sum of the series
    public static double m(int i){
        double sum = 0;
        for (int j = 1; j <= i; j++)
            sum += j / (j + 1.0);
        return sum;
    }
}