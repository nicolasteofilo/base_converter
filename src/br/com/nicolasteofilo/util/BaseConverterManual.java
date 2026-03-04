package br.com.nicolasteofilo.util;

import java.math.BigInteger;
import br.com.nicolasteofilo.entity.Number;

public class BaseConverterManual {
	// cada posição do array ja representa o valor do dígito
    private static final char[] DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
	
	public static BigInteger toDecimal(Number number, int base) {
		String formattedNumber = number.getNumber().toUpperCase();
		BigInteger decimalNumber = BigInteger.ZERO;
		BigInteger baseBig = BigInteger.valueOf(base);
		
		for(int i = 0; i < formattedNumber.length(); i++) {
			char c = formattedNumber.charAt(i);
			int value = ManualDigitMap.getValue(c);
			decimalNumber = decimalNumber.multiply(baseBig).add(BigInteger.valueOf(value));
		}
		
		return decimalNumber;
	}
	
	public static String fromDecimal(BigInteger decimalNumber, int outputBase) {
		if(decimalNumber.equals(BigInteger.ZERO)) return "0";
		
		BigInteger baseBig = BigInteger.valueOf(outputBase);
		StringBuilder sb = new StringBuilder();
		
		while(decimalNumber.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] divRem = decimalNumber.divideAndRemainder(baseBig);
			sb.append(DIGITS[divRem[1].intValue()]); // o resto sempre está entre 0 - (base - 1)
		
			/**
			 * A função divideAndRemainder no Java retorna um array com dois elementos:
			 * - posição 0 → quociente da divisão inteira (decimalNumber / outputBase)
			 * - posição 1 → resto da divisão (decimalNumber % outputBase)
			 */
			
			/**
			 * Exemplo:
			 * - 31 / 15 = 1 -> resto 15 -> DIGITS[15] -> 'F'
			 * - 1 / 6 = 0 -> resto 1 -> DIGITS[1] -> '1'
			 * - Logo o resultado fica 'F1'
			 */
			decimalNumber = divRem[0];;
		}
		return sb.reverse().toString();
	}
	
	public static String convert(Number number, int inputBase, int outputBase) {
	    BigInteger decimal = toDecimal(number, inputBase);
	    return fromDecimal(decimal, outputBase);
	}
}
