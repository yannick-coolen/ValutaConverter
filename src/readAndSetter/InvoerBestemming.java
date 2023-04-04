package readAndSetter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static readAndSetter.UitvoerValuta.invoerBedrag;

public class InvoerBestemming {
    /**
     * Biedt de gebruiker de mogelijkheid om een bestand aan te maken waarbij de invoerwaarde de naam wordt.
     * @param bronPath Doorgespeelde data vanuit de Class Invoerbron, met als doel de inhoud over te nemen
     *                 waarbij deze verwerking daarvan in een nieuw bestand komen te staan.
     * @throws IOException Wanneer het invoerveld binnen de terminal leeg staat treed er een IOException op
     * waarbij deze een foutmelding teruggeeft.
     */
    public static void setBestemmingBestand(Path bronPath) throws IOException {
        try {
            System.out.println("Voer de bestemmingsbestand in:");
            Scanner scanBestemmingBestand = new Scanner(System.in);
            String bestemmingInput = scanBestemmingBestand.nextLine(); // product
            Path bestemmingPath = Path.of("C:\\Users\\yanni\\IdeaProjects\\ValutaConverter\\" + bestemmingInput + ".txt");

            if (!bestemmingInput.isEmpty()) {
                List<String> alleRegels = Files.readAllLines(bronPath);
                BufferedWriter out = Files.newBufferedWriter(bestemmingPath,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);

                // static method afkomstig van Class UitvoerValuta
                invoerBedrag(bestemmingPath, out, alleRegels);

                scanBestemmingBestand.close();
                out.newLine();
                out.close();
            } else {
                throw new InputMismatchException("Invoerveld voor bestemmingsbestand dient te worden ingevoerd!");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
