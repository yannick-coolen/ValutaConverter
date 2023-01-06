import java.io.IOException;

import readAndSetter.InputReader;

public class Main {
    /**
     * Initïeer de applicatie door de klasse InputReader aan te roepen,
     * dat de methode readIn() uitvoert
     * @param args
     */
    public static void main(String[] args) {
        // Initiatiepunt
        try {
            InputReader.readIn();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }
}