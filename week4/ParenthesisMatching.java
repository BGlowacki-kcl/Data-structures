package Week4_StacksQueues;
import java.util.Map;

public class ParenthesisMatching {

	private static Map<Character, Character> parenthesis = Map.of(')','(',']','[','}','{');
	
	public static boolean checkIfValid(String list) {
		Stack<Character> s = new ArrayStack<>(20);
		while(list.length() > 0) {
			char first = list.charAt(0);
			if(parenthesis.containsKey(first)) {
				if(s.isEmpty()) return false;
				if(s.pop() != parenthesis.get(first)) return false;
			} else {
				s.push(first);
			}
			list = list.substring(1, list.length());
		}
		if(s.isEmpty()) return true;
		else return false;
	}
	
	public static void main(String[] main) {
		String str = "((){[]([])}()){}";
		System.out.println(checkIfValid(str));
	}
	
}
