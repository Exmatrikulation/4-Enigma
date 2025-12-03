package enigma;

import java.util.ArrayList;

public class Steckbrett {
    private ArrayList<SteckbrettVerbindung> steckerbrett;

    public Steckbrett(ArrayList<SteckbrettVerbindung> steckerbrett) {
        this.steckerbrett = steckerbrett;
    }
    
    public char tausche(char x) {
    	char zeichenNeu = x;
    	// For-each loop
    	for (SteckbrettVerbindung stck : steckerbrett) {
    		if (x == stck.getEingang()) {
    			zeichenNeu = stck.getAusgang();
    		}
    		
    		if (x == stck.getAusgang()) {
    			zeichenNeu = stck.getEingang();
    		}
    	}
    	
    	return zeichenNeu;
    }
}