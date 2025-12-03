package enigma;


public class Walze {
	// Attribute
	/**
	* Walze I
	*/
	public static final char[] WALZE_I = new char[] { 'E', 'K', 'M', 'F', 'L', 'G',
	'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S',
	'P', 'A', 'I', 'B', 'R', 'C', 'J' };
	/**
	* Walze II
	*/
	public static final char[] WALZE_II = new char[] { 'A', 'J', 'D', 'K', 'S', 'I',
	'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z',
	'N', 'P', 'Y', 'F', 'V', 'O', 'E' };
	/**
	* Walze III
	*/
	public static final char[] WALZE_III = new char[] { 'B', 'D', 'F', 'H', 'J', 'L',
	'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G',
	'A', 'K', 'M', 'U', 'S', 'Q', 'O' };
	/**
	* Walze IV
	*/
	public static final char[] WALZE_IV = new char[] { 'E', 'S', 'O', 'V', 'P', 'Z',
	'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T',
	'G', 'K', 'D', 'C', 'M', 'W', 'B' };
	/**
	* Walze V
	*/
	public static final char[] WALZE_V = new char[] { 'V', 'Z', 'B', 'R', 'G', 'I',
	'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M',
	'J', 'Q', 'O', 'F', 'E', 'C', 'K' };
	
	private int position;
	private char[] walze;
	private String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Walze(int position, char[] walze) {
		this.position = position;
		this.walze = walze;
	}
	
	public boolean updatePosition() {
		dreheWalze();
		if (position > 26) {
			this.position = 0;
			return true;
		} else {
			this.position ++;
			return false;	
		}
	}
	
	/*
	* Walze um eine Stelle weiter drehen
	*/
	private void dreheWalze() {
		//letztes Zeichen muss erstes Zeichen werden
		char temp = walze[walze.length-1]; //hole das letzte Zeichen und speichere es
		//verschiebe alle Zeichen um eine Stelle
		for (int i = walze.length-1; i >0 ; i--) {
			walze[i] = walze[i-1];
		}
		walze[0] = temp; //speichere den letzten Wert im ersten Zeichen
	}
	
	public char tausche(char zeichen, boolean hin) {
		// hin true = hinweg
		if(hin) {
			int index = abc.indexOf(zeichen);
			return walze[index];
		} else {
			// Rueckweg
			int index = -1;

			for (int i = 0; i < walze.length; i++) {
			    if (walze[i] == zeichen) {
			        index = i;
			        break;
			    }
			}

			return abc.charAt(index);
		}
	}

}
