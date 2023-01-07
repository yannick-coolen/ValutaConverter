package readAndSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static readAndSetter.InvoerBestemming.setBestemmingBestand;

public class InputSource {
    /**
     * Biedt de mogelijkheid om een bestaand bestand te openen
     * als de invoer van de gebruiker gelijk is met het bestaand bestand
     * @throws IOException Als de invoer niet gelijk is met het bestaand bestand
     * treed er een Exception waarbij deze een bericht terug geeft dat het bestand
     * niet bestaat, en voert vervolgens het programma niet uit.
     */
    public static void readIn() {
        System.out.println("Voer de naam van het bronbestand in die je wilt openen:");
        Scanner scanBronBestand = new Scanner(System.in);
        String inputBronBestand = scanBronBestand.nextLine(); // product
        Path bronPath = Path.of("C:\\Users\\yanni\\IdeaProjects\\ValutaConverter\\" + inputBronBestand + ".txt");
        try {
            String alleTekst = Files.readString(bronPath);

            if (Files.exists(bronPath) && Files.isRegularFile(bronPath)) {
                System.out.println(alleTekst);
                System.out.println();

                // class OutputSetter
                setBestemmingBestand(bronPath);
            }
            scanBronBestand.close();
        } catch (IOException e) {
            System.out.println("bronbestand: '" + bronPath.getFileName().toString() + "' is onbekend");
        }
    }
}

