package practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestPrimeFactor(13195));
		
		for(Integer ii : listPrimeFactors(13195)) {
			System.out.println("ii "+ii);
		}
	}
	public static int largestPrimeFactor(long number) {
        int i;
        long copyOfInput = number;

        for (i = 2; i < copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i;
               // i--;
            }
        }

        return i;
    }
	
	public static List<Integer> listPrimeFactors(long number) {
        int i;
        long copyOfInput = number;
        List<Integer> li = new ArrayList<>();
        
        for (i = 2; i < copyOfInput; i++) {
            if (copyOfInput % i == 0) {
            	li.add(i);
                copyOfInput /= i;
               // i--;
            }
        }
        li.add(i);
        return li;
    }
}
