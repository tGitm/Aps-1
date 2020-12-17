package Izzivi;

public class bubblesort2 {
    public static void bubblesort1(Comparable[] tab, boolean smer) {
        int TrenutniElement = 1;
        int MestoZadnjeZamenjave;
        Comparable x;

        while (TrenutniElement < tab.length) { //Dokler se vsa tabela ne uredi, hodi skoznjo
            MestoZadnjeZamenjave = tab.length - 1;
            for (int i = tab.length - 1; i >= TrenutniElement; --i) //Od zadnjega proti prvemu do meje kjer je že urejena tabela
                if (smer) //Če je smer true, potem je zaporedje naraščujoče
                {
                    if (tab[i].compareTo(tab[i - 1]) < 0) {

                        //Zamenjava elementa
                        x = tab[i];
                        tab[i] = tab[i - 1];
                        tab[i - 1] = x;
                        MestoZadnjeZamenjave = i; //zapomnemo si mesto menjave
                    }
                }
                else //Drugače pa je zaporedje padajoče
                {
                    if (tab[i].compareTo(tab[i - 1]) > 0) {
                        //Zamenjava elementa
                        x = tab[i];
                        tab[i] = tab[i - 1];
                        tab[i - 1] = x;
                        MestoZadnjeZamenjave = i; //zapomnemo si mesto menjave
                    }
                }
            TrenutniElement = MestoZadnjeZamenjave + 1; //Skočimo na mesto zamenjave in od tam povečujemo urejeni del tabele

            NarisiCrto(tab, MestoZadnjeZamenjave - 1); //Narišemo črto | na pravem mestu
            System.out.println();

        }
    }
}
