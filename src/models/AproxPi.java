package models;

import java.math.BigDecimal;
import java.math.MathContext;

import models.series.LeibnizSeriesToPi;
import models.series.NewtonSeriesToPi;
import models.series.SeriesToPi;

public class AproxPi {

	public static final String NEWTONSERIES = "newton";
	public static final String LEIBNIZSERIES = "leibniz";

	private long totalTerms;
	private MathContext mc;
	private BigDecimal pi;

	public AproxPi(long totalTerms, MathContext mc) {
		this.totalTerms = totalTerms;
		this.mc = mc;
		this.pi = BigDecimal.ZERO;
	}

	public void ejecutar(String series_name) {

		SeriesToPi serie;

		switch (series_name) {
		case AproxPi.NEWTONSERIES: {
			serie = new NewtonSeriesToPi(this.mc);
			break;
		}
		case AproxPi.LEIBNIZSERIES: {
			serie = new LeibnizSeriesToPi(this.mc);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + series_name);
		}

		for (long i = 0; i < this.totalTerms; i++) {
			this.pi = this.pi.add(serie.getTermAt(i), this.mc);
		}

	}

	public long getTotalTerms() {
		return totalTerms;
	}

	public void setTotalTerms(long totalTerms) {
		this.totalTerms = totalTerms;
	}

	public MathContext getMc() {
		return mc;
	}

	public void setMc(MathContext mc) {
		this.mc = mc;
	}

	public BigDecimal getPi() {
		return pi;
	}

}
