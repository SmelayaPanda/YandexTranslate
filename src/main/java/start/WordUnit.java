package start;

public class WordUnit implements Comparable<WordUnit> {

    private String ru = null;
    private String eng = null;
    private int ordinar;

    public WordUnit(String eng, int ordinar) {
        this.eng = eng;
        this.ordinar = ordinar;
    }

    public WordUnit(String ru, String eng, int ordinar) {
        this.ru = ru;
        this.eng = eng;
        this.ordinar = ordinar;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public int getOrdinar() {
        return ordinar;
    }

    public String getRu() {
        return ru;
    }

    public void setOrdinar(int ordinar) {
        this.ordinar = ordinar;
    }

    @Override
    public int compareTo(WordUnit otherWord) {
        int c = otherWord.ordinar - ordinar;
        if (c != 0) {
            return c;
        } else {
            int nameDiff = eng.compareTo(otherWord.getEng());
            return nameDiff;
        }
    }


    @Override
    public String toString() {
        return eng + " " + ru + " " + ordinar;
    }
}