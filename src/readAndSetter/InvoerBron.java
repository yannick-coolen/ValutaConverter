package readAndSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static readAndSetter.InvoerBestemming.setBestemmingBestand;

public class InvoerBron {
    /**
     * Biedt de gebruiker de mogelijkheid om een invoer binnen de terminal
     * toe te passen, waardoor het programma zoekt naar de naam van een bestaand
     * bestand die overeenkomt met de invoerwaarde
     * <br/><br/>
     * Bij het invoeren van een waarde dat niet overeenkomt met de naam van
     * een bestaand bestand wordt er een IOException uitgevoerd, waarbij deze
     * voorziet met een foutbericht.
     */
    public static void invoerBronBestand() {
        System.out.println("Voer de naam van het bronbestand in die je wilt openen:");
        Scanner scanBronBestand = new Scanner(System.in);
        String inputBronBestand = scanBronBestand.nextLine(); // product
        Path bronPath = Path.of("C:\\Users\\yanni\\IdeaProjects\\ValutaConverter\\" + inputBronBestand + ".txt");
        try {
            String alleTekst = Files.readString(bronPath);

            if (Files.exists(bronPath) && Files.isRegularFile(bronPath)) {
                System.out.println(alleTekst);
                System.out.println();

                // static method from class InvoerBestemming
                setBestemmingBestand(bronPath);
            }
            scanBronBestand.close();
        } catch (IOException e) {
            System.out.println("bronbestand: '" + bronPath.getFileName().toString() + "' is onbekend");
        }
    }
}

