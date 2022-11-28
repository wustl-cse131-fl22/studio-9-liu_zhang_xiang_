package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Integer> team = new HashMap<>();
		team.put("Yusheng Xiang", 186);
		team.put("Jiaheng Zhang", 180);
		team.put("Heming Liu", 180);
		
		while (true) {
			System.out.print("Enter the name: ");
			String inputName = in.next();
			if (inputName == "quit") {
				break;
			} else {
				if (team.get(inputName)!=null) {
					System.out.println(team.get(inputName));
				} else {
					System.out.println("No such person.");
				}
			}
		}

	}
}
