package com.example.richiesteFascicolo.utilities;

public class RichiesteCambioBase {

	/**
	 * passando un codice alfabetico calcola il numerico corrispondente partendo da
	 * A = 1 es. "A" = 1 "B" = 2 , "CA"=79
	 * 
	 * @param str
	 * @return l'intero corrispondente alla stringa
	 */
	public int toNumericCode(String str) {
		String decimal = "";
		String str1 = str.replaceAll(" ", "").toUpperCase();
		int length = str1.length();
		
		for (int i = 0; i < length; i++) { 
			if (isValid(str1.charAt(i))) {
						
				if(str1.charAt(i)!='Z' || i == 0) {
				String curr = Integer.toString(str1.charAt(i)-'@');		
				decimal += convertFromBaseToBase(curr, 10, 26);
				} else {
					int decimalWithCarry = (Integer.valueOf(convertFromBaseToBase(decimal, 26 , 10)) + 1);
					decimal = convertFromBaseToBase(String.valueOf(decimalWithCarry), 10, 26) + "0" ;
					
				}
			}else
			return 0;
		}
		
		return Integer.parseInt(convertFromBaseToBase(decimal, 26, 10));
	}
	
	// decimal = convertFromBaseToBase(String.valueOf((Integer.valueOf(convertFromBaseToBase(decimal, 26 , 10)) + 1)), 10, 26) + "0" ;
	
	/*
	 * metodo che verifica se un char è una lettera tra la A e la Z
	 */
	boolean isValid(char c) {

		if ((((int) c - 64) > 0 && ((int) c - 64) < 27) || (((int) c - 96) > 0 && ((int) c - 96) < 27))
			return true;
		else
			return false;
	}

	/**
	 * * passando un codice numerico calcola il alfabetico corrispondente partendo
	 * da 1 = "A" es. 1 = "A" 2 = "B" , 79 = "CA"
	 * 
	 * @param number
	 * @return la stringa corrispondente al numero
	 */
	public String toStringCode(int number) {

		if (number <= 0)
			return "";
		String letters = "";
		String numbersBase26 = convertFromBaseToBase(Integer.toString(number - 1), 10, 26);
		for (int i = 0; i < numbersBase26.length(); i++) {
			String curr = Character.toString(numbersBase26.charAt(i));
			if (i == numbersBase26.length() - 1) {
				letters += (char) ('@' + Integer.parseInt(convertFromBaseToBase(curr, 26, 10)) + 1);
			} else {
				letters += (char) ('@' + Integer.parseInt(convertFromBaseToBase(curr, 26, 10)));
			}
		}
		return letters;

	}

	public String convertFromBaseToBase(String str, int fromBase, int toBase) {
		return Integer.toString(Integer.parseInt(str, fromBase), toBase);
	}

	/**
	 * passando un codice alfabetico calcola il codice progressivo successivo, una
	 * volta arrivati a Z si continua con AA es. "A" -> "B" "B" -> "C" , "Z"="AA"
	 * 
	 * @param code
	 * @return il codice numerico successivo a code
	 */
	public String nextCode(String code) {

		if (toNumericCode(code) == 0) {
			return "";
		}
		int numCode = toNumericCode(code);
		numCode++;
		return toStringCode(numCode);
	}

}
