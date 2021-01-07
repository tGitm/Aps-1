package DomaceNaloge;

public class TurnTable {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int[] turnedTable = new int[a.length];

        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            turnedTable[j - 1] = a[i];
            j = j - 1;
        }

        //print od reversed table
        for (int i = 0; i < turnedTable.length; i++) {
            System.out.print(turnedTable[i]);
        }
    
    }
}
