package models.utils;

import java.math.BigInteger;

public class MathOperations {
	
	public static BigInteger factorial(BigInteger n) {
		BigInteger i = BigInteger.ONE;
		BigInteger zero = BigInteger.ZERO;

		if (i.compareTo(n) == 0) {
			return i;
		} else if (zero.compareTo(n) == 0) {
			return i;
		} else {
			return n.multiply(factorial(n.subtract(i)));
		}
	}
	
}
