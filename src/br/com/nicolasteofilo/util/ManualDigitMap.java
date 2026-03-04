package br.com.nicolasteofilo.util;

import java.util.HashMap;
import java.util.Map;

public class ManualDigitMap {
	// Mapa estático que associa cada caractere ao seu valor numérico
    private static final Map<Character, Integer> CHAR_TO_VALUE = new HashMap();

    // Bloco de inicialização estática: roda somente uma vez quando a classe é carregada na memória
    static {
    	// números (0 - 9)
    	for(int i = 0; i <= 9; i++) {
    		// '0' + i -> transforma 0...9 em caractere '0' ... '9' (casting de dados)
    		CHAR_TO_VALUE.put((char)('0' + i), i);
    	}
    	
    	// letras (A - Z)
    	for(int i = 0; i < 26; i++) {
    		CHAR_TO_VALUE.put((char)('A' + i), 10 + i);
    		CHAR_TO_VALUE.put((char)('a' + i), 10 + i); // aceita letras minusculas
    		/*
    		 * Detalhamento:
    		 * - A tem valor ASCII 65
    		 * - O i vai variar de 0 até 25
    		 * - (A + i) => (65 + i) => número que representa o caracter na tabela ASCII
    		 * - (char) converte esse número de volta para caractere
    		 * - 10 + i é o valor númerico correspondente
    		 * Exemplo:
    		 * i = 0 → 'A' + 0 = 65 → (char)65 = 'A' → valor 10
    		 * i = 1 → 'A' + 1 = 66 → (char)66 = 'B' → valor 11
    		 * ... e assim até 'Z' = 35
    		 * - mesma lógica para letras minúsculas
    		 * 
    		 * Obs: No Java o char é referente a 16 bits (2 bytes), pois ele precisa de mais espaço
    		 * porque segue a Unicode, Isso porque o Java foi projetado para portabilidade internacional
    		 */
    	}
    }
    
    public static int getValue(char c) {
    	Integer value = CHAR_TO_VALUE.get(c);
    	if (value == null) {
            throw new IllegalArgumentException("Dígito inválido: " + c);
        }
    	return value;
    }
}
