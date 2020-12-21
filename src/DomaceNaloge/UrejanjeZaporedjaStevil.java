package DomaceNaloge;

import java.util.Scanner;

public class UrejanjeZaporedjaStevil {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String read = sc.nextLine();
            String[] arg = read.split("\\s+");
            Sorting sort = new Sorting();
                        
            //arg[0] - trace/count, arg[1] - sortings, arg[2] - up/down
            sort.setMode(sc.next());

            
            String[] input = sc.nextLine().split("\\s+"); //številke za sortiranje
            int[] elements = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                elements[i] = Integer.parseInt(input[i]);
            }

            switch(arg[1]) {
                case "insert": sort.insertionS(elements);
                break;
                case "select": 
                break;
                case "bubble":       
                break;
                case "heap": 
                break;
                case "merge": 
                break;
                case "quick": 
                break;
                case "radix": 
                break;
                case "bucket": 
                break;
                default: System.out.println("Algoritem ne obstaja, preverite napake");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class Sorting {
    private int modes;
    private int[] arr;
    private final int START_CAPACITY = 64;
    private int moves;
    private int compare;
    private int direction; //1 - up, 0 - down


    Sorting() {
        this.arr = new int[START_CAPACITY];
        this.modes = modes;
    }

    public void resizeMyArray(int array[]) {
        int[] array1 = new int[this.arr.length*2];    //povečam * 2 org velikosti

        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }

        //grem čez arrayResized, da odstranim vse 0 na koncu
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0)
                for (int j = 0; j < array1.length - 1; j++) {
                    array1[j] = array1[j+1];
                }
                break;
        }
    }

    public int getModes() { return this.modes; }

    public void setMode(String modes) {
        if (modes.equals("trace"))
            this.modes = 0;
        else
            this.modes = 1;
    }

    public void setDirection(String dir) {
        if (dir.equals("up")) 
            this.direction = 1;
        else if (dir.equals("down"))
            this.direction = 0;

        //return this.direction;
    }

    public void insertionS(int[] elements) {
        
    }

}
