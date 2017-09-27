import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exercise22_8{
	public static void main(String[] args) throws Exception {
		writeFirstBatchPrimeNumbers(100000);
		DataInputStream input = new DataInputStream(
				new BufferedInputStream(new FileInputStream("PrimeNumber.dat")));
		int count = 0;
		for(int i = 0; input.available() > 0 && i < 10000; i++){
			count++;
			if(count % 10 == 0)
				System.out.println(input.readLong());
			else
				System.out.print(input.readLong() + " ");
		}
		input.close();
		
	}
	
	//find if n is prime number using the known prime number list
	public static boolean isPrimeNumber(long n, long[] list){
		for(int i = 0; i < list.length; i++){
			if(list[i] != 0 && n % list[i] == 0){
				return false;
			}
		}
		return true;
	}
	
	//find the first 10000 prime numbers and write them into the file
	public static void writeFirstBatchPrimeNumbers(long number) throws Exception{
		DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("PrimeNumber.dat")));
		output.writeLong((long)2);
		output.close();
		long[] list = new long[10000];
		//there is one number in the file
		int count = 1;
		//starting from 3
		long n = 3;
		
		while(count <= 10000 && n < number){
			try(DataInputStream input = new DataInputStream(
					 new BufferedInputStream(new FileInputStream("PrimeNumber.dat")))){
				for(int i = 0; i < count && input.available() > 0; i++)
						list[i] = input.readLong();
			}
			
			//check if a number is a prime
			while(true){
				DataOutputStream output1 = new DataOutputStream(new BufferedOutputStream
						(new FileOutputStream("PrimeNumber.dat", true)));
				if(isPrimeNumber(n, list)){
					output1.writeLong(n);
					output1.close();
					count++;
					n++;
					break;
				}
				else
					n++;
			}	
		}
	}
		
	/** ?? have no idea how to read from a certain location
	 * 	eg. starting from the 10001th number in the PrimeNumber.dat
	 */
	
	public static void writePrimeNumbers(long number) throws Exception{
		DataOutputStream output = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("PrimeNumber.dat")));
		long[] list = new long[10000];
		//there is one number in the file
		int count = 1;
		int batch = 0;
		//starting from 100004, since 100003 is the 10000th prime
		long n = 100004;
		File file = new File("PrimeNuber.dat");
		for( ; count <= 10000 && count >= 0; count -= 10000){
			while(count <= 10000 && n < number){
				try(DataInputStream input = new DataInputStream(
						 new BufferedInputStream(new FileInputStream("PrimeNumber.dat")))){
					
					input.skip(batch * 10000 * 8);
					for(int i = 0; i < count && input.available() > 0; i++)
							list[i] = input.readLong();
				}
				
				//check if a number is a prime
				while(true){
					DataOutputStream output1 = new DataOutputStream(new BufferedOutputStream
							(new FileOutputStream("PrimeNumber.dat", true)));
					if(isPrimeNumber(n, list)){
						output1.writeLong(n);
						output1.close();
						count++;
						n++;
						break;
					}
					else
						n++;
				}	
			}
			batch++;
		}
	}
}