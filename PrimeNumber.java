package practice;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 47;
		boolean flag = true;
		for(int i=2;i<input;i++) {
			if(input%i == 0) {
				flag = false;
				break;
			}
		}
		System.out.println("prime (true/false) "+flag);
	}

}
