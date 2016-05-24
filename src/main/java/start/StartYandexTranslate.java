package start;

import ytrans.Language;
import ytrans.Translate;

import java.util.ArrayList;
import java.util.List;

public class StartYandexTranslate {
    public static void main(String[] args) {


        List<WordUnit> list = new ArrayList();

        try {
            Translate.execute("from", Language.ENGLISH,Language.RUSSIAN);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String fileName = "C:\\Users\\SmelayaPanda\\IdeaProjects\\YandexTranslate\\src\\main\\resources\\countRating2.txt";
//        try {
//            TxtFileReader.readFile(fileName, list);
//        } catch (IOException e) {
//            System.out.println("Hz что произошло");
//        }
//        int i = 104490;
//        for (WordUnit l : list) {
//            try {
//                String eng = l.getEng();
//                Translate.setKey(ApiKeys.YANDEX_API_KEY);
//                String rus = Translate.execute(eng, Language.ENGLISH, Language.RUSSIAN);
//                System.out.println(eng + " " + rus + " " + l.getOrdinar());
//
//                if (!rus.equals(eng)) {
//                    WriteNewTxt.writeWithTranslate(eng, rus, i);
//                    i++;
//                }
//            } catch (Exception e) {
//                System.out.println("tr error");
//            }
//        }

    }
}

