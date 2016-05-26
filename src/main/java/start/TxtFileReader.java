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
                if (Character.isLetter(s) || (char) s == '-' || (char) s == '`') {
                    sb.append((char) s);
                } else {
                    String engl = String.valueOf(sb).toLowerCase();
                    char[] chars = engl.toCharArray();
                    if ((chars.length >= 3 && (chars[(chars.length-1)] != '-') && engl.contains("-") && ((chars[0] != '-' && chars[0] != '`') && engl.matches(".*[A-Za-z].") && !engl.equals("") && ((engl.contains("-")) || engl.contains("'"))))) {
                        WordUnit wordUnit = new WordUnit(engl, i);
                        list.add(wordUnit);
                        sb.delete(0, sb.length());
                        i++;
                    } else {
                        sb.delete(0, sb.length());
                    }
                }
            }
        }
    }
}