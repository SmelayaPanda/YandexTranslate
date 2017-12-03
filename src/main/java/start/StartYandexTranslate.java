package start;

import start.support.FileReader;
import ytrans.ApiKeys;
import ytrans.Language;
import ytrans.Translate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;


public class StartYandexTranslate {
    public static void main(String[] args) throws IOException {

        Translate.setKey(ApiKeys.YANDEX_API_KEY);
        TreeMap map = FileReader.readFileToMap("./src/main/resources/forAvac/deuWordsWikiArranged.txt");
        PrintWriter pw = new PrintWriter(new FileWriter("./src/main/resources/forAvac/translatedDeuWikiToRus.txt"));
        AtomicInteger counter = new AtomicInteger();
        map.forEach((key, val) -> {
            counter.getAndIncrement();
            String to = null;
            try {
                to = Translate.execute((String) val, Language.GERMAN, Language.RUSSIAN);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(counter + " --> " + val + " = " + to);
            pw.write(val + ": " + to + "\n");
            pw.flush();
        });

        pw.close();
    }
}

