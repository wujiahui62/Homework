package exercise20_11;
import java.io.File;
import java.util.*;

public class Exercise20_11{
	
	//create a boolean method isGroupingSysbols
	public static boolean isGroupingSymbols(Character ch){
		Character[] groupingSymbols = {'{', '}', '[', ']', '(', ')'};
			if(Arrays.asList(groupingSymbols).contains(ch))
				return true;
			return false;
	}
	
	//create a method matchGroupingSymbols using Stack
	public static void matchGroupingSymbols(ArrayList<Character> list){
		Stack<Character> stack = new Stack<>();
		for(Character ch: list){
			if(ch == '{' || ch =='[' || ch == '('){
				stack.push(ch);
			}
			else if(ch == '}' && stack.peek() == '{'){
				stack.pop();
			}
			else if(ch == ']' && stack.peek() =='['){
				stack.pop();
			}
			else if(ch == ')' && stack.peek() == '('){
				stack.pop();
			}			
		}	
		if(stack.isEmpty())
			System.out.println("The grouping symbols are matched");
		else
			System.out.println("The grouping symbols are not matched");
	}
	
	//main
	public static void main(String[] args) throws Exception{
		if(args.length != 1){
			System.out.println("Usage: java Exercise20_11 javaFileName");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		if(!file.exists()){
			System.out.println("file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		try(Scanner input = new Scanner(file);){
			//add grouping symbols to a ArrayList
			ArrayList <Character> list = new ArrayList<>();
			while(input.hasNext()){
				String words = input.next();
				for(int i = 0; i < words.length(); i++){
					if(isGroupingSymbols(words.charAt(i)))
						list.add(words.charAt(i));
				}
			}
			//test: print the list
			System.out.print("The grouping symbols are: ");
			for(Character words: list)
				System.out.print(words + " ");
			System.out.println();
			
			matchGroupingSymbols(list);
		}
	}
}
