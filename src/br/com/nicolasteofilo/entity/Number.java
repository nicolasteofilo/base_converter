package br.com.nicolasteofilo.entity;

import br.com.nicolasteofilo.exception.InvalidNumberException;
import br.com.nicolasteofilo.util.ManualDigitMap;

public class Number {
	private String number;
	private int base;

	public Number(String number, int base) {
		this.number = number;
		this.base = base;
		this.validateNumber();
	};

	public String getNumber() {
		return this.number;
	}

	private void validateNumber() {
		String numStr = this.number.toUpperCase();
		if(numStr.contains("-")) {
			throw new InvalidNumberException("Número " + number + " inválido. O sistema não aceita números negativos.");
		}
		if(numStr.contains(".") || numStr.contains(",")) {
			throw new InvalidNumberException("Número " + number + " inválido. O sistema não aceita números decimais.");
		}
		for (int i = 0; i < numStr.length(); i++) {
			char c = numStr.charAt(i);
			int value = ManualDigitMap.getValue(c);
			if (value >= this.base) {
				throw new InvalidNumberException("Número " + number + " inválido para base " + base);
			}
		}
	}
}
