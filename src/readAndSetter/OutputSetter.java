package readAndSetter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class OutputSetter {
    /**
     *
     * @param bronPath
     * @throws IOException
     */
    public static void setOutput(Path bronPath) throws IOException {
//        System.out.println("Voer de bestemmingbestand in:");
//        Scanner scanBestemmingBestand = new Scanner(System.in);
//        String bestemmingInput = scanBestemmingBestand.nextLine(); // product
//        Path bestemmingPath = Path.of("C:\\Users\\yanni\\IdeaProjects\\ValutaConverter\\" + bestemmingInput + ".txt");

        String[] arrOfString;
        List<String> alleRegels = Files.readAllLines(bronPath);

        // TODO: 29/12/2022
        // Set the converted amount in euro together with the index 0 of arrOfString
        // in a created file, for which the name has been created after this was been
        // entered by the user with the Scanner object
        //
        // If the name of the file already exist, DO NOT remove that file and find another way to solve this.

//        if (!Files.exists(bestemmingPath && !Files.isRegularFile(bestemmingPath)) {
//            System.out.println("Nieuw bestand " + input + ".txt is aangemaakt");
//            BufferedWriter out = Files.newBufferedWriter(bestemmingPath);
//            out.write("Test");
//            out.close();
//        } else {
//            System.out.println("De ingevoerde naam voor bestand bestaat al");
//        }

        for (String regel: alleRegels) {
            arrOfString = regel.split(": ");
            double euro = Double.parseDouble(arrOfString[1]) * 91.8720;
            BigDecimal bigDecimal = new BigDecimal(euro).setScale(2, RoundingMode.HALF_UP);

            System.out.println(bigDecimal);
        }
//         scanBestemmingBestand.close();
    }
}


//        InputStream inputStream = new InputStream(Path.of("C:\\Users\\yanni\\IdeaProjects\\ValutaConverter\\" + input + ".txt")) {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        }
