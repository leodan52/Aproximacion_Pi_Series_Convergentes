package models.series;

import java.math.BigDecimal;
import java.math.MathContext;

public class LeibnizSeriesToPi extends SeriesToPi {

	public LeibnizSeriesToPi(MathContext mc) {
		super(mc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal getTermAt(long n) {
		double numerator = Math.pow(-1, (double) n);
		double denominator = 2*n + 1;
		
		BigDecimal four = BigDecimal.valueOf(4);
		BigDecimal fraction = (new BigDecimal(numerator, this.mc))
								.divide(new BigDecimal(denominator), this.mc);
		
		return four.multiply(fraction);
	}

}
