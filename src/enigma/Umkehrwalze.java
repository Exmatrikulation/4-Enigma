package enigma;

public class Umkehrwalze {
	// Attribute
	/**
	*
	* Umkehrwalze A
	*
	*/
	public static final char[] UKW_A = new char[] { 'E', 'J', 'M', 'Z', 'A', 'L', 'Y',
	'X', 'V', 'B', 'W', 'F', 'C','R', 'Q', 'U', 'O', 'N', 'T', 'S', 'P', 'I', 'K', 'H',
	'G', 'D' };
	/**
	*
	* Umkehrwalze B
	*
	*/
	public static final char[] UKW_B = new char[] { 'Y', 'R', 'U', 'H', 'Q', 'S', 'L',
	'D', 'P', 'X', 'N', 'G', 'O','K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J',
	'A', 'T' };
	/**
	*
	* Umkehrwalze C
	*
	*/
	public static final char[] UKW_C = new char[] { 'F', 'V', 'P', 'J', 'I', 'A', 'O',
	'Y', 'E', 'D', 'R', 'Z', 'X','W', 'G', 'C', 'T', 'K', 'U', 'Q', 'S', 'B', 'N', 'M',
	'H', 'L' };
	
	private char[] ukw;
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	public Umkehrwalze(char[] kette) {
		this.ukw = kette;		
	}
	
	public char tausche(char zeichen) {
		int index = abc.indexOf(zeichen);
		return ukw[index];
	}
}
