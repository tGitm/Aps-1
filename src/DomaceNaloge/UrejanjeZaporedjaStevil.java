package DomaceNaloge;

import java.util.Scanner;

public class UrejanjeZaporedjaStevil {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            
                        
            //arg[0] - trace/count, arg[1] - sortings, arg[2] - up/dow
            String read = sc.nextLine();
            String[] instructions = read.split("\\s+");
                
            String[] nums = sc.nextLine().split("\\s+"); //številke za sortiranje
            int[] elements = new int[nums.length];

            Sorting sorts = new Sorting(elements);
                
            
            for (int i = 0; i < nums.length; i++) {
                elements[i] = Integer.parseInt(nums[i]);
            }
            sorts.setMode(instructions[0]);
            sorts.setDirection(instructions[2]);

            switch(instructions[1]) {
                case "insert": sorts.insertionS(elements);
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
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}

class Sorting {
    private int modes;
    private int[] arr;
    private int moves;
    private int last;
    private int compare;
    private int direction; //1 - up, 0 - down


    Sorting(int[] elements) {   //konstruktorju dodam tabelo elementov
        this.arr = elements;
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

    
    public int getDirection() { return this.direction; }

    public void setDirection(String instruction) {
        if (instruction.equals("up")) 
            this.direction = 1;
        else if (instruction.equals("down"))
            this.direction = 0;

        //return this.direction;
    }
 
    public void printTrace() {
        System.out.print(arr[0]);
        if (last == 0)
            System.out.print("|");
        
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
            if (last == i)
                System.out.print("|");
        }
        System.out.print(arr[arr.length - 1]);

        if (last == arr.length-1)
            System.out.print("|");
        
        System.out.println();
            
    }


    public void insertionS(int[] arr) {
        int n = arr.length;
        last = n;
        for (int i = 1; i < n-1; i++) {
            int key = arr[i];
            int j = i;

            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j = j - 1;
            }
            arr[j] = key;

            if (this.modes == 0) {  //izpisovanje urejanja
                printTrace();
            }
            last = i;
        }
    }

}
