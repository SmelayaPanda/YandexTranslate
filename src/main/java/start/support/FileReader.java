package start.support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader {

    public static TreeMap<Integer, String> readFileToMap(String filePath) throws IOException {
        TreeMap<Integer, String> map = new TreeMap<>();
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            int counter = 0;
            while (sc.hasNextLine()) {
                String word = sc.nextLine().trim();
                if (!map.containsValue(word)) {
                    map.put(counter, word);
                    counter++;
                }
                if (counter % 1000 == 0) {
                    System.out.println(counter);
                }
            }
            System.out.println(counter);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return map;
    }
}
