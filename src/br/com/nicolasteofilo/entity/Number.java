package br.com.nicolasteofilo.entity;

import br.com.nicolasteofilo.exception.InvalidNumberException;
import br.com.nicolasteofilo.util.ManualDigitMap;

public class Number {
	private String number;
	private int base;
    
	public Number (String number, int base) {
		this.number = number;
		this.base = base;
		boolean isValidNumber = this.validateNumber();
		
		if(!isValidNumber) {
			throw new InvalidNumberException(
					"Número " + number + " inválido para base " + base
			);
		}
	};
	
	public String getNumber() {
		return this.number;
	}
	
	private boolean validateNumber() {
		String numStr = this.number.toUpperCase();
		for(int i = 0; i < numStr.length(); i++) {
			char c = numStr.charAt(i);
			try {
				int value = ManualDigitMap.getValue(c);
				if(value >= this.base) return false;
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}
