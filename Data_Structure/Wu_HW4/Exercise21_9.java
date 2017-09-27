import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise21_9 {
	public static void main(String[] args) {
		String[][] stateAndCapital = {
			{"Alabama", "Montgomery"},
			{"Alaska", "Juneau"}, 
			{"Arizona", "Phoenix"},
			{"Arkansas", "Little Rock"},
			{"California", "Sacramento"},
			{"Colorado", "Denver"},
			{"Connecticut", "Hartford"},
			{"Delaware", "Dover"},
			{"Florida", "Tallahassee"},
			{"Georgia", "Atlanta"},
			{"Hawaii", "Honolulu"},
			{"Idaho", "Boise"},
			{"Illinois", "Springfield"},
			{"Indiana", "Indianapolis"},
			{"Iowa", "Des Moines"},
			{"Kansas", "Topeka"},
			{"Kentucky", "Frankfort"},
			{"Louisiana", "Baton Rouge"},
			{"Maine", "Augusta"},
			{"Maryland", "Annapolis"},
			{"Massachusetts", "Boston"},
			{"Michigan", "Lansing"},
			{"Minnesota", "St. Paul"},
			{"Mississippi", "Jackson"},
			{"Missouri", "Jefferson City"},
			{"Montana", "Helena"},
			{"Nebraska", "Lincoln"},
			{"Nevada", "Carson City"},
			{"New Hampshire", "Concord"},
			{"New Jersey", "Trenton"},
			{"New Mexico", "Santa Fe"},
			{"New York", "Albany"},
			{"North Carolina", "Raleigh"},
			{"North Dakota", "Bismarck"},
			{"Ohio", "Columbus"},
			{"Oklahoma", "Oklahoma City"},
			{"Oregon", "Salem"},
			{"Pennsylvania", "Harrisburg"},
			{"Rhode Island", "Providence"},
			{"South Carolina", "Columbia"},
			{"South Dakota", "Pierre"},
			{"Tennessee", "Nashville"},
			{"Texas", "Austin"},
			{"Utah", "Salt Lake City"},
			{"Vermont", "Montpelier"},
			{"Virginia", "Richmond"},
			{"Washington", "Olympia"},
			{"West Virginia", "Charleston"},
			{"Wisconsin", "Madison"},
			{"Wyoming", "Cheyenne"}};
		
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < stateAndCapital.length; i++){
			map.put(stateAndCapital[i][0], stateAndCapital[i][1]);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a state: ");
		String state = input.nextLine();
		String stateConversion = (state.substring(0, 1)).toUpperCase()
				+ (state.substring(1)).toLowerCase();
		if(map.containsKey(stateConversion))
			System.out.println("The capital of " + state + " is " + map.get(stateConversion));
		else
			System.out.println("input of state is invalid");			
	}	
}
