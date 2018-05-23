package practice;

public class Multiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		multiples(50);
	}
	
	public static void multiples(int n) {
		int i=0;
		for(i=1;i <=100;i++) {
			if(i%n ==0 ) {
				System.out.println(i);
			}
		}
	}

}
