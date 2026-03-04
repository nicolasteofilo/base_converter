package br.com.nicolasteofilo.application;

import java.util.*;

import br.com.nicolasteofilo.exception.InvalidNumberException;
import br.com.nicolasteofilo.util.BaseConverterManual;
import br.com.nicolasteofilo.entity.Number;

public class Main {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("===== CONVERSOR DE BASES =====");
			
			int inputBase = readBase(scan, "Base de entrada (2 a 36): ");
			int outputBase = readBase(scan, "Base de saída(2 a 36): ");
			Number number = readNumber(scan, inputBase);
			String convertedNumber = BaseConverterManual.convert(number, inputBase, outputBase);
			System.out.printf("Resultado: %s\n\r", convertedNumber);
		}
	}
		
	private static int readBase(Scanner scan, String message) {
		int base = -1;
		while(true) {
			System.out.print(message);
			String readedLine = scan.nextLine().trim();
			try {
				base = Integer.parseInt(readedLine);
				if(base < 2 || base > 36) {
					System.out.println("Base inválida! Deve ser entre 2 e 36.");
					continue; // interrompe a execução e roda o loop novamente
				}
				break;
			} catch (NumberFormatException  e) {
	            System.out.println("Digite um número inteiro válido para a base.");
			}
		}
		return base;
	}
	
	private static Number readNumber(Scanner scan, int inputBase) {
		Number number = null;
		while(number == null) {
			System.out.print("Digite seu número: ");
			String line = scan.nextLine().trim();
			try {
				number = new Number(line, inputBase);
			} catch (InvalidNumberException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
		}
		return number;
	}
}
