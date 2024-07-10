package models.series;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import models.utils.MathOperations;

public class NewtonSeriesToPi extends SeriesToPi{

	public NewtonSeriesToPi(MathContext mc) {
		super(mc);
	}

	@Override
	public BigDecimal getTermAt(long n) {
		
		BigInteger bign = BigInteger.valueOf(n);
		BigInteger numerator = MathOperations.factorial(TWO.multiply(bign));

		BigInteger firstFactorbotton = TWO.pow((int) (4 * n)); // 2^{4n} or 16^n
		BigInteger secondFactorbotton = MathOperations.factorial(bign).pow(2); // (n!)^2
		BigInteger thirdFactorbotton = TWO.multiply(bign).add(ONE); // (2n + 1)
		BigInteger denominator = firstFactorbotton
										.multiply(secondFactorbotton)
										.multiply(thirdFactorbotton);

		BigDecimal tree = BigDecimal.valueOf(3);
		BigDecimal fraction = (new BigDecimal(numerator, this.mc))
				.divide(new BigDecimal(denominator), this.mc);

		return tree.multiply(fraction);
		
	}
	
	
}
