package enigma;

import java.util.ArrayList;

public class Enigma {

    public static void main(String[] args){
        // 1. Steckverbindungen anlegen
        ArrayList<SteckbrettVerbindung> verbindungen = new ArrayList<>();
        verbindungen.add(new SteckbrettVerbindung('D', 'M'));
        verbindungen.add(new SteckbrettVerbindung('A', 'T'));
        // weitere Verbindungen nach Bedarf hinzufügen...

        // 2. Steckbrett mit Liste der Steckverbindungen anlegen
        Steckbrett steckbrett = new Steckbrett(verbindungen);

        // 3. Startpositionen der Walzen abfragen (z.B. über Tastatur)
        Keyboard kb = new Keyboard();
        System.out.println("Startposition Walze A (0-25): ");
        int posA = kb.readInt();
        System.out.println("Startposition Walze B (0-25): ");
        int posB = kb.readInt();
        System.out.println("Startposition Walze C (0-25): ");
        int posC = kb.readInt();

        // 4. Walzen auswählen und initialisieren
        Walze walzeA = new Walze(posA, Walze.WALZE_I);
        Walze walzeB = new Walze(posB, Walze.WALZE_II);
        Walze walzeC = new Walze(posC, Walze.WALZE_III);

        // 5. Umkehrwalze auswählen und initialisieren
        Umkehrwalze ukw = new Umkehrwalze(Umkehrwalze.UKW_A);

        // 6. Nachricht einlesen
        System.out.println("Bitte Nachricht eingeben (nur Großbuchstaben): ");
        String nachricht = kb.readString().toUpperCase();

        StringBuilder verschluesselt = new StringBuilder();

        // 7. Schleife über alle Zeichen
        for (int i = 0; i < nachricht.length(); i++) {
            char zeichen = nachricht.charAt(i);

            // nur Buchstaben A-Z verschlüsseln
            if (zeichen < 'A' || zeichen > 'Z') {
                verschluesselt.append(zeichen);
                continue;
            }

            // Ablauf: Steckbrett -> Walze A -> Walze B -> Walze C -> UKW -> zurück
            char temp = steckbrett.tausche(zeichen);
            temp = walzeA.tausche(temp, true);
            temp = walzeB.tausche(temp, true);
            temp = walzeC.tausche(temp, true);
            temp = ukw.tausche(temp);
            temp = walzeC.tausche(temp, false);
            temp = walzeB.tausche(temp, false);
            temp = walzeA.tausche(temp, false);
            temp = steckbrett.tausche(temp);

            verschluesselt.append(temp);

            // Walzen drehen
            if (walzeA.updatePosition()) {
                if (walzeB.updatePosition()) {
                    walzeC.updatePosition();
                }
            }
        }

        // 8. Ausgabe
        System.out.println("Verschlüsselte Nachricht: " + verschluesselt.toString());
    }
    
    
}