package practice;

public class Palindrome3Digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		int mul=0;
		int rev=0;
		int holdLargest = 0;
		int holdi=0,holdj=0;
		for(int i=100;i<=999;i++) {
			for(int j=100;j<=999;j++) {
				mul = i*j;
				rev = reverse(mul);
				if(mul == rev) {
					if(holdLargest<mul) {
						holdLargest = mul;
						holdi = i;
						holdj=j;
					}
				}
			}
		}
		System.out.printf("largest palindrome %d * %d = %d ",holdi,holdj,holdLargest);
	}
	
	public static int reverse(int n) {
		int rem=0,rev=0;
		while(n!=0) {
			rem = n%10;
			rev = rev *10+rem;
			n = n/10;
		}
		return rev;
	}

}
