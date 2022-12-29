package readAndSetter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

public class InputReader {
    /**
     *
     * @throws IOException
     */
    public static void readIn() throws IOException {
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
                OutputSetter.setOutput(bronPath);
            } else {
                throw new IOException(bronPath.getFileName().toString());
            }
            scanBronBestand.close();
        } catch (NoSuchFileException e) {
            System.out.println("bronbestand '" + bronPath.getFileName().toString() + "' is onbekend");
        }
    }
}

