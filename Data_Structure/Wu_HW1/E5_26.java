public class E5_26{
    public static void main(String[] args){
        double e = 1.0;
        double item = 1.0;
        for (int i = 10000; i <= 100000; i += 10000){
            for (int j = 1; j <= i ; j++){
                item = item / j;
                e += item;
            }
            System.out.println("The e value for " + i + " is " + e);
        }
    }
}