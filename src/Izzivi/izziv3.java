package Izzivi;

public class izziv3 {
    public static void main(String[] args) {
        System.out.print(" n       |    linearno  |   dvojisko  |");
        System.out.println();
        System.out.print("---------+--------------+-------------+");
        System.out.println();
        for (int i = 100000; i < 1000000; i += 10000) {
            System.out.print(i + "   |     " + timeLinear(i) + "    |     " +  timeBinary(i) + "     |");
            System.out.println();
        }
    }

    public static int[] generateTable(int n) {
        int stevila[] = new int [n];
        for (int j = 0; j < stevila.length; j++){
            stevila[j] = j+1;
        }

        return stevila;
    }

    public static int findLinear(int[] a, int v) {
        for (int j = 0; j < a.length; j++){
            if (a[j] == v){
                return j;
            }
        }
        return -1;
    }

    public static int findBinary(int[] a, int l, int r, int v) {
        if (r < l){
            return -1;
        }

        int mediana = l + (r - l) / 2;
        if (v < a[mediana]) {
            return findBinary(a, l, mediana - 1, v);
        }

        if (v > a[mediana]) {
            return findBinary(a,mediana + 1, r, v);
        }

        return mediana;
    }

    public static long timeLinear(int n) {
        int tabela [] = generateTable(n);
        int average = 0;

        for (int i = 0; i < 1000; i++) {
            long startTime = System.nanoTime();
            int stevilo = (int) (Math.random() * n + 1 );

            // for (int j = 0; j < tabela.length; j++) {
            int x = findLinear(tabela, stevilo);
            //  return x;
            //}
            long executionTime = System.nanoTime() - startTime;
            average += executionTime;
        }
        int av = average / 1000;
        return av;
    }

    public static long timeBinary(int n) {
        int tabela [] = generateTable(n);
        int average = 0;

        for (int i = 0; i < 1000; i++){
            long startTime = System.nanoTime();
            int stevilo = (int) (Math.random() * n + 1);

            //for (int j = 0; j < tabela.length; j++){
            int x = findBinary(tabela, 0, tabela.length -1, stevilo);
            //System.out.println(tabela.length);
            //return x;
            //}
            long executionTime = System.nanoTime() - startTime;
            average += executionTime;
        }
        int av = average / 1000;
        return av;
    }
}
