package enigma;

public class SteckbrettVerbindung {
	// Attribute
	private char eingang;
	private char ausgang;
	
	// Konstruktor
	public SteckbrettVerbindung(char eingang, char ausgang) {
		this.eingang = eingang;
		this.ausgang = ausgang;
	}
	
	public char getEingang() {
		return this.eingang;
	}
	
	public char getAusgang() {
		return this.ausgang;
	}

}
