package models.series;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public abstract class SeriesToPi {

	public static final BigInteger ONE = BigInteger.ONE;
	public static final BigInteger TWO = BigInteger.TWO;

	public MathContext mc;

	public SeriesToPi(MathContext mc) {
		this.mc = mc;
	}

	public abstract BigDecimal getTermAt(long n);

}
