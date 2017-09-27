public class Exercise10_22 {
 public static void main(String[] args) {

  char[] array1 = {'A', 'B', 'c', 'd', 'e', '2'};
  char[] array2 = {'A', 'B', 'c', 'd', 'e', '2'};  
  char[] array3 = {'A', 'B', 'c', 'd', 'e', '3'};  
  char[] array4 = {'A', 'B', 'c', 'd', 'e'};  

  MyString1 ch = new MyString1(array1);
  MyString1 ch2 = new MyString1(array2);
  MyString1 ch3 = new MyString1(array3);
  MyString1 ch4 = new MyString1(array4);
  
  System.out.println("charAt: " + ch.charAt(1));

  System.out.println("length: " + ch.length());

  System.out.print("substring: ");
  MyString1 substr = ch.substring(0,2);
  for (int i = 0; i < substr.length(); i++) {
   System.out.print(substr.charAt(i));		
		}
   System.out.println();

  System.out.print("lowercase: ");
  MyString1 lowerCase = ch.toLowerCase();
   for (int i = 0; i < lowerCase.length(); i++) {
   System.out.print(lowerCase.charAt(i));		
		}
  System.out.println();

  System.out.println("equals: " + ch.equals(ch2));
  System.out.println("equals: " + ch.equals(ch3));
  System.out.println("equals: " + ch.equals(ch4));

  System.out.print("valueOf: ");
		MyString1 valueOf = ch.valueOf(35321);
		for (int i = 0; i < valueOf.length(); i++) {
			System.out.print(valueOf.charAt(i));		
		}
		System.out.println();

	}
}