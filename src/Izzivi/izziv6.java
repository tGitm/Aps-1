package Izzivi;
import java.util.Scanner;

public class izziv6 {
    public static void main(String[] args) {
        int velikost;
        Scanner sc = new Scanner(System.in);
        System.out.print("Vnesi veliksot n: ");
        velikost = sc.nextInt();
        System.out.println();
        
        Oseba[] t = new Oseba[velikost];
        Oseba[] tt = new Oseba[velikost];
        int len = tt.length;
        
        boolean zagon = true;
        while(zagon) {
            //prekopiraj tabelo t v tabelo tt -> uporabil bom .arraycopy()
            //(src, el., dest, el, length)
            System.arraycopy(tt, 0, t, 0, len);
            for (int i = 0; i < t.length; i++) {    //izpis
                System.out.println(t[i] + " ");
            }

            System.out.print("Vnesi atr: ");
            int atr = sc.nextInt();
            Oseba.setAtr(atr);
            System.out.println();

            System.out.print("Vnesi smer: ");
            int smer = sc.nextInt();
            Oseba.setSmer(smer);
            System.out.println();

            System.out.print("Izpis sledi algoritma: ");
            Oseba.bubblesort_improved(t);
            

            System.out.print("Vnesi 'konec' ali 'nadaljuj': ");
            String s = sc.next();
            if (s.equals("konec")) 
                zagon = false;
                break;
        }
        

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

    //public static void izpis(Oseba[] o, boolean )

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

    //metoda za zamenjavo elementov
    public static void swap(Oseba temp, Oseba[] org) {
        for (int i = 0; i < org.length; i++) {
            org[i] = org[i-1];
            org[i-1] = temp;
        }
    }

    public static void trace(int stevilo, Oseba[] os) {
        for (int i = 0; i < os.length; i++) {
            System.out.println(os[i] + " ");
            if (i == stevilo)
                System.out.println("|");    //ločim urejeni del
                
        }System.out.println();  //zapis v novo vrstico
    }

    
    public static void bubblesort_improved(Oseba[] tab) {
        trace(-1, tab); //črto postavim na položaj -1
        int m = 0;

        for (int i = 1; i < tab.length; i++) {
            m = tab.length - 1;
            for (int j = tab.length; j > i; --i) {
                if (smer == 1) {    //naraščujoče
                    if (tab[j].compareTo(tab[i-1]) < 0) {}
                        Oseba temp = tab[j];
                        swap(temp, tab);
                         m = j;
                }
                else {  //padajoče
                    if (tab[j].compareTo(tab[i-1]) > 0) {
                        Oseba temp = tab[j];
                        swap(temp, tab);
                        m = j;
                    }
                }
            }
            trace(m-1, tab);
        }
    }
}

interface Comparable {
    public int compareTo(Object o);
}