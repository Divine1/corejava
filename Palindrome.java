package practice;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 1801;
		
		int remainder = 0;
		int reverse = 0;
		while(input !=0) {
			remainder = input%10;
			reverse = reverse*10 +remainder;
			input /=10;
		}
		System.out.println(reverse);
	}

}
