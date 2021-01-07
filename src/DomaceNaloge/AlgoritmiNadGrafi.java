package DomaceNaloge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlgoritmiNadGrafi {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc1, sc2;
        sc1 = new Scanner(System.in);

        String s1, s2;
        String[] comand = {"none", "none"}; // za 3 to bo sam za tiste ko majo 3 ukate
        String comand11 = null; // za 2 to pa bo za tiste ko majo dva ukaza
        String directed_undirected = null; // to mamo sam za to sam za undrirecred directed
        int st_vozlisc = 0;

        Test t = new Test();


        TestArray voz = new TestArray();

        int q = 0;
        while (sc1.hasNextLine()) {
            s1 = sc1.nextLine();

            sc2 = new Scanner(s1);
            while (sc2.hasNext()) {

                s2 = sc2.next();

                if (s2.equals("undirected") || s2.equals("directed")) {
                    directed_undirected = s2;
                } else if (s2.equals("sp") || s2.equals("walks")) { // 3
                    comand[1] = s2; // to bo Sp/walks
                    s2 = sc2.next();
                    comand[2] = s2; // to bo št neka
                } else if (s2.equals("info") || s2.equals("dfs") || s2.equals("bfs") || s2.equals("comp")) { // 2
                    comand11 = s2; // to bo Sp/walks
                } else {
                    if (q < 1) {
                        st_vozlisc = Integer.parseInt(s2);
                        q = 10;
                        continue;
                    }
                    String[] tab = new String[2];
                    tab = s1.split(" ");
                    voz.dodaj(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]));
                    break;
                }

            }
            sc2.close();// konc

        }
        sc1.close();// konc
        voz.zmanjsajVel();

        System.out.println(st_vozlisc + " " + voz.array.length);


        if (directed_undirected.equals("undirected")) {
            if (comand[1].equals("sp")) { // 3 ukaze ma

            } else if (comand[1].equals("walks")) { // 3 ukaze ma

            } else if (comand11.equals("info")) { // ukaz ma 2
                t.undirected_info_voz(voz, st_vozlisc);
            } else if (comand11.equals("dfs")) {  // ukaz ma 2

            } else if (comand11.equals("bfs")) {  // ukaz ma 2

            } else if (comand11.equals("comp")) { // ukaz ma 2

            }


        } else if (directed_undirected.equals("directed")) {
            if (comand[1].equals("sp")) { // 3 ukaze ma

            } else if (comand[1].equals("walks")) { // 3 ukaze ma

            } else if (comand11.equals("info")) { // ukaz ma 2
                t.directed_info_voz(voz, st_vozlisc);
            } else if (comand11.equals("dfs")) {  // ukaz ma 2

            } else if (comand11.equals("bfs")) {  // ukaz ma 2

            } else if (comand11.equals("comp")) { // ukaz ma 2

            }
        }
    } 

}
    class Test {

        public int stetjeStopnja(int[][] matrika, int st_voz,int zaKero) { // undirected
            int count = 0;
                for (int j = 0; j <matrika.length; j++) {
                    if (matrika[zaKero][j] == 1 || matrika[j][zaKero]==1) {
                        count++;
                    }
            }
            return count;

        }

        public int[][] undirected_Matrix(TestArray tabela, int st_voz) { // undirected
            int[][] matrix = new int[st_voz][st_voz];
            for (int i = 0; i < tabela.array.length; i++) {
                    int tmp1=tabela.array[i][0]; // vrstica
                    int tmp2= tabela.array[i][1]; // stolpec
                    matrix[tmp1][tmp2] = 1;
            }
            return matrix;
        }


        public void undirected_info_voz(TestArray voz, int st_vozlisc) {
            int[][] info_voz = new int[voz.array.length][2];
            for (int i = 0; i < st_vozlisc; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 1)
                        info_voz[i][j] = stetjeStopnja(undirected_Matrix(voz,st_vozlisc), st_vozlisc, i);
                    else
                        info_voz[i][j] = i;
                }
            }

            for (int i = 0; i < st_vozlisc; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(info_voz[i][j] + " ");
                }
                System.out.println();
            }
        }

        public int[] directed_stopnja(TestArray tabela, int st_voz, int za_kero) { // undirected
            int in = 0;
            int out = 0;
            for (int i = 0; i < tabela.array.length; i++) {
                if (za_kero == tabela.array[i][0])
                    out++;
            }

            for (int j = 0; j < tabela.array.length; j++) {
                if (za_kero == tabela.array[j][1])
                    in++;
            }

            int[] tab = {in, out};
            return tab;

        }


        public void directed_info_voz(TestArray voz, int st_vozlisc) {
            int[][] info_voz = new int[voz.array.length][3];
            int[] tab1;

            for (int i = 0; i < st_vozlisc; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 1) {
                        tab1 = directed_stopnja(voz, st_vozlisc, i);
                        info_voz[i][1] = tab1[1]; // out
                        info_voz[i][2] = tab1[0]; // in
                        tab1 = null;
                    } else
                        info_voz[i][j] = i;
                }
            }

            for (int i = 0; i < st_vozlisc; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(info_voz[i][j] + " ");
                }
                System.out.println();
            }

        }

        public int[][] navadnaTabela(TestArray st) { // nevem če je tko uredu
            int[][] tabela1 = new int[st.array.length][2];
            for (int i = 0; i < st.array.length; i++) {
                for (int j = 0; j < 2; j++) {
                    tabela1[i][j] = st.array[i][j];
                }
            }
            return tabela1;
        }

    }


    class TestArray {

        public int array[][];
        public int stevec;
        public int vel;

        public TestArray() {
            array = new int[1][2];
            stevec = 0;
            vel = 1;
        }

        // funkcija ki preprosto poveča velikost tabele *2 če je prej bla 2 je zdej  2*2 = 4
        public void povecajVel() {

            int tempArr[][];
            tempArr = new int[vel * 2][2]; // povečam velikost za 2x
            for (int i = 0; i < vel; i++) {
                for (int j = 0; j < 2; j++) {
                    tempArr[i][j] = array[i][j];
                }
            }
            array = tempArr;
            vel = vel * 2;
        }


        public void dodaj(int stevilo1, int stevilo2) {


            if (vel == stevec) {
                povecajVel();
            }
            array[stevec][0] = stevilo1;
            array[stevec][1] = stevilo2;
            stevec++;

        }

        public void zmanjsajVel() {
            int ArrTemp[][] = new int[stevec][2];
            for (int i = 0; i < stevec; i++) {
                for (int j = 0; j < 2; j++) {
                    ArrTemp[i][j] = array[i][j];
                }
            }
            vel = stevec;
            array = ArrTemp;
        }


    }
