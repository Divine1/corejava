package practice;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(fibonacci(50));
		fibo(20);
	}

	public static int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void fibo(int n) {
		int a=0,b=1,sum=0;
		
		for(int i=0;i<=n && sum <60;i++) {
			sum = a+b;
			a=b;
			b=sum;
			System.out.println(sum);
		}
	}
}
