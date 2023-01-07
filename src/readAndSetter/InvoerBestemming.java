package readAndSetter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static readAndSetter.UitvoerValuta.ingevoerBedrag;

public class InvoerBestemming {
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

                // method
                ingevoerBedrag(bestemmingPath, out, alleRegels);

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
