package com.example.richiesteFascicolo.utilities;

public class Richieste {

	/**
	 * passando un codice alfabetico calcola il numerico corrispondente partendo da
	 * A = 1 es. "A" = 1 "B" = 2 , "CA"=79
	 * 
	 * @param str
	 * @return l'intero corrispondente alla stringa
	 */
public int toNumericCode(String str) {

		int decimal = 0;
		String str1 = str.replaceAll(" ", "");
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			if (isValid(str1.charAt(i))) {
				String curr = Character.toString(str1.charAt(i));
				int index = length - (1 + i);
				int intByString = (Integer.valueOf(convertFromBaseToBase(curr, 36, 10)) - 9);
				decimal += intByString * Math.pow(26, index);
			}
		}

		return decimal;
	}

	/*
	 * il metodo che esegue il calcolo per toNumericCode(String str)
	 */
	int numberCalculation(char c, int pos) {

		return (int) (((int) c - 64) * (Math.pow(26, pos)));
	}

	/*
	 * metodo che verifica se un char è una lettera tra la A e la Z
	 */
	boolean isValid(char c) {

		if (((int) c - 64) > 0 && ((int) c - 64) < 27)
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
		int baseChar = 'A';
		do {
			number--;
			letters = String.valueOf((char) (baseChar + (number % 26))) + letters;
			number = (number / 26);
		} while (number > 0);

		return letters;

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
