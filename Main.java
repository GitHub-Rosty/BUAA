
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EOFException {
        ArrayList<String> strArray = new ArrayList<>();
        String line;
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                strArray.add(line);
            }
        } finally {
            WordAnalyze wordAnalyze = new WordAnalyze(strArray);
            wordAnalyze.analyze();
        }
    }
}
