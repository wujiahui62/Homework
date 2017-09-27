import java.util.*;
import java.io.*;
public class Exercise21_8 {
	public static void main(String[] args) throws Exception{
		if(args.length != 1){
			System.out.println("Usage: java Exercise21_8 fileName");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		
		if(!file.exists()){
			System.out.println("file " + file + " does not exist");
			System.exit(2);
		}

		try(Scanner input = new Scanner(file);){
			
			//add each word delimited by whitespace to an arraylist
			List<String> list  = new ArrayList<>();
			while(input.hasNext()){
					list.add(input.next());
			}

			System.out.println(list);
			
			//turn the arraylist to a string
			String text = "";
			for(String s: list){
				text += s + " ";
		}
			
			System.out.println(text);
			
			//split the string
			//cannot split string by quotation marks
			String[] word = text.split("[ ,;.:?'\"()]");
			
			for(int i = 0; i < word.length; i++)
				System.out.print(word[i] + " ");
			System.out.println();
			
			Map<String, Integer> map = new HashMap<>();
			for(int i = 0; i < word.length; i++){
				String key = word[i].toLowerCase();
				if(key.length() > 0 
						&& ((key.charAt(0) >= 'a' && key.charAt(0) <= 'z') ||
						(key.charAt(0) >= 'A' && key.charAt(0) <= 'Z'))){
					if(map.get(key) == null){
						map.put(key, 1);
					}
					else{
						int value = map.get(key);
						value++;
						map.put(key, value);
					}
				}
			}
			
			Map<String, Integer> treemap = new TreeMap<>(map);
			
			Set<Map.Entry<String, Integer>> entrySet = treemap.entrySet();
			for(Map.Entry<String, Integer> entry: entrySet)
				System.out.println(entry.getValue() + "\t" + entry.getKey());
		}
	}
}
