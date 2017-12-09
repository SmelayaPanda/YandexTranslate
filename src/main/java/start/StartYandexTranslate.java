package start;

import start.support.FileReader;
import ytrans.ApiKeys;
import ytrans.Language;
import ytrans.Translate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;


public class StartYandexTranslate {
    public static void main(String[] args) throws IOException {

        Translate.setKey(ApiKeys.YANDEX_API_KEY);
        TreeMap map = FileReader.readFileToMap("./src/main/resources/forAvac/spaWordsWikiArranged.txt");
        PrintWriter pw = new PrintWriter(new FileWriter("./src/main/resources/forAvac/translatedSpaWikiToRus.txt"));
        final int[] counter = {0};
        map.forEach((Object key, Object val) -> {
            counter[0]++;
            String to = null;
            if (counter[0] > 109323) {
                try {
                    to = Translate.execute((String) val, Language.SPANISH, Language.RUSSIAN);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(counter[0] + " --> " + val + " = " + to);
                pw.write(val + ": " + to + "\n");
                pw.flush();
            }
        });

        pw.close();
    }
}

