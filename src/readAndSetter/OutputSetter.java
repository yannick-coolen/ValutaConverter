package readAndSetter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Biedt de mogelijke methodes om een bestand aan te maken,
 * waarbij deze automatisch vraagt om een waarde dollar bedrag in te voer
 * waarbij deze vervolgens wordt omgerekend in eurocenten.
 */
public class OutputSetter {
    /**
     *
     * @param bronPath
     * @throws IOException
     */
    public static void setOutput(Path bronPath) throws IOException {
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

    /**
     *
     * @param bestemmingPath
     * @param out
     * @param arrOfString
     * @throws IOException
     */
    private static void setValutaText(Path bestemmingPath, BufferedWriter out, String[] arrOfString, double getValuta) throws IOException {
        double euro = Double.parseDouble(arrOfString[1]) * (91.8720 * getValuta);
        BigDecimal bigDecimal = new BigDecimal(euro).setScale(2, RoundingMode.HALF_UP);
        if (Files.exists(bestemmingPath) && Files.isRegularFile(bestemmingPath)) {
            out.write(arrOfString[0] + ": " + bigDecimal + " eurocent");
        } else {
            System.out.println(arrOfString[0] + ": " + bigDecimal + " eurocent");
            out.write(arrOfString[0] + ": " + bigDecimal + " eurocent");
        }
        out.newLine();
    }


    private static void ingevoerBedrag(Path bestemmingPath, BufferedWriter out, List<String> alleRegels) throws IOException {
        try {
            System.out.println("Voer een dollarbedrag in waarbij het patroon van (getal.getal) aangehouden wordt," +
                    " om het in eurocenten om te rekenen." +
                    "\n\nLET OP: comma's voor decimale zijn niet toegestaan:");
            Scanner scanValuta = new Scanner(System.in);
            String valutaInput = scanValuta.nextLine();
            double getValuta = Double.parseDouble(valutaInput);

            if (!Double.isNaN(getValuta)) {
                if (getValuta == 0.0) {
                    getValuta = 1;
                }
                for (String regel : alleRegels) {
                    String[] arrOfString = regel.split(": ");
                    // method
                    setValutaText(bestemmingPath, out, arrOfString, getValuta);
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invoer dienen te worden ingevoerd en moet van getallen worden voorzien," +
                    "\nwaarvan de punt decimalen optioneel zijn");
        }
    }
}