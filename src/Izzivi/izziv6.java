package Izzivi;

public class izziv6 {
    public static void main(String[] args) {

    }
}

class Oseba {
    String priimek;
    String ime;
    int letoR;
    static int atr;
    static int smer;
    private final static String[] imena = {"Ana", "Bojan", "Cilka", "Mitja", "Donald", "Mihc"};
    private final static String[] priimki = {"Arh", "Klepec", "Cah", "Duh", "Trump", "Novak"};


    Oseba() {
        this.priimek = priimki[(int) (Math.random() * (priimki.length))];
        this.letoR = (int) (Math.random() * (2019 - 1910) + 1);
        this.ime = imena[(int) (Math.random() * (imena.length))];
    }

    public static int getAtr() {
        return atr;
    }

    public static int getSmer() {
        return smer;
    }

    public static void setAtr(int atribut) {
        //če je vnešen atribut 0 1 2, atr nastavim atr na to cifro
        if (atribut <= 2 && atribut >= 0)
            atr = atribut;
    }

    public static void setSmer(int s) {
        //če je vnešena smer enaka 1 ali -1 (naraščujoče, padajoče) smeri dodelim to vrednost
        if (s == 1 || s == -1)
            smer = s;
    }

    int compareTo(Oseba o) {
        switch(atr) {
            case 0: return this.ime.compareTo(o.ime);
            case 1: return this.priimek.compareTo(o.priimek);
            //enostavnejši način pokazan na vajah
            case 2: return this.letoR - o.letoR;
            default:
                return 0;
        }
    }


}


interface Comparable {
    public int compareTo(Object o);
}