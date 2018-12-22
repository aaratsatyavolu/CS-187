package finalE;

public class SortString {
	public static String sortedString(String str) {
		String newstr = new String();
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c)
					newstr += c;
			}
		}
		
		return newstr;
	}
	
	public static void main(String[] args) {
		System.out.println(sortedString("cardie"));
	}
}
