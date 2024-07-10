package main;
import java.math.BigDecimal;
import java.math.MathContext;

import data.Pi;
import models.AproxPi;

public class Main {

	public static final MathContext mc = new MathContext(1000);

	public static void main(String[] args) {

		BigDecimal pi = BigDecimal.ZERO;
		long maximo = 1650;
		AproxPi aproxPi = new AproxPi(maximo, mc);
		
		aproxPi.ejecutar(AproxPi.NEWTONSERIES);
		pi = aproxPi.getPi();
		
		System.out.println("El número de términos calculado es: " +  maximo);
		System.out.println("Se obtuvo un total de " + pi.scale() + " decimales calculados.");
		comparar(pi);

	}

	public static void comparar(BigDecimal pi) {
		String pi_string = pi.toString();
		String pi_externo = Pi.getPi(pi_string.length() - 2);;
		String format_indicador;
		int detener = 0;

		for (int i = 0; i < pi_externo.length(); i++) {
			if (pi_string.charAt(i) == pi_externo.charAt(i)) {
				continue;
			} else {
				detener = i;
				break;
			}
		}

		format_indicador = "%" + detener + "s";
		System.out.println(pi_string);
		System.out.println(pi_externo);

		if (detener == 0) {
			System.out.println("Se alcanzó el máximo");
		} else {

			System.out.println(
					String.format(format_indicador, "^").replaceAll(" ", "-") + String.format(" Pos. %d", detener - 2));

		}
	}


}
