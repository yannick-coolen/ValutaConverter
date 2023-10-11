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
    public static void setOutput(Path bronPath) throws IOException {
        String[] arrOfString;
        List<String> alleRegels = Files.readAllLines(bronPath);

        for (String regel: alleRegels) {
            arrOfString = regel.split(": ");
            double euro = Double.parseDouble(arrOfString[1]) * 91.8720;
            BigDecimal bigDecimal = new BigDecimal(euro).setScale(2, RoundingMode.HALF_UP);

            System.out.println(bigDecimal);
        }
    }
}
