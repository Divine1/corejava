package practice;

public class PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="divine";
		StringBuilder output= new StringBuilder();
		for(int i=input.length()-1;i>=0;i--) {
			output.append(input.charAt(i));
		}
		System.out.println("output "+output);
			
	}

}
