/**
 *
 *  @author Tomaszewska Justyna S15313
 *
 */

package calcforbigdec;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Calc {
	
	private interface BigDecimalMath {
		BigDecimal operation(BigDecimal a, BigDecimal b);
	}
	
	private HashMap<Character, BigDecimalMath> operations = new HashMap<>();
	private DecimalFormat formatter = new DecimalFormat("0.#######");
	
	public Calc(){
		operations.put('+', (a, b) -> a.add(b));
		operations.put('-', (a, b) -> a.subtract(b));
		operations.put('*', (a, b) -> a.multiply(b));
		operations.put('/', (a, b) -> a.divide(b, 7, RoundingMode.HALF_UP));
	}
			


	private BigDecimal operateBinary(BigDecimal a, BigDecimal b, BigDecimalMath op) {
		return op.operation(a, b);
	}

	String doCalc(String arg) {
		try {
			String[] skladniki = arg.split("\\s+");
			BigDecimal liczba1 = new BigDecimal(skladniki[0]);
			char operator = skladniki[1].charAt(0);
			BigDecimal liczba2 = new BigDecimal(skladniki[2]);
			BigDecimal result = operateBinary(liczba1, liczba2, operations.get(operator));
			return formatter.format(result);
		}
		catch (Throwable ex) {
			return "Invalid command to calc";
		}

	}
}
