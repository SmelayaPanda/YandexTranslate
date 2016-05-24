package start;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TxtFileReader {
    public static void readFile(String fileName, List<WordUnit> list) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            int s;
            int i = 1;
            while (((s = in.read()) != -1)) {
                if (Character.isLetter(s)) {
                    sb.append((char) s);
                } else {
                    String engl = String.valueOf(sb).toLowerCase();
                    if (!engl.equals("")) {
                        WordUnit wordUnit = new WordUnit(engl,i);
                        list.add(wordUnit);
                        sb.delete(0, sb.length());
                        i++;
                    }
                }
            }
        }
    }
}