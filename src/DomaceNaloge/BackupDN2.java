package DomaceNaloge;

import java.util.Scanner;

public class BackupDN2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
                        
            //arg[0] - trace/count, arg[1] - sortings, arg[2] - up/dow
            String read = sc.nextLine();
            String[] instructions = read.split("\\s+");
                
            String[] nums = sc.nextLine().split("\\s+"); //številke za sortiranje
            int[] elements = new int[nums.length];

            Sorting sorts = new Sorting(instructions[0], elements);
                
            
            for (int i = 0; i < nums.length; i++) {
                elements[i] = Integer.parseInt(nums[i]);
            }
            sorts.setMode(instructions[0]);
            sorts.setDirection(instructions[2]);

            switch(instructions[1]) {
                case "insert": sorts.insertionS();
                break;
                case "select": sorts.selectionS(elements);
                break;
                case "bubble": sorts.bubbleS();      
                break;
                case "heap": 
                break;
                case "merge": 
                break;
                case "quick": //sorts.quickS();
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
    private String modes;
    private boolean direction; //true - up, false - down
    int[] arr;
    int moves;
    int compares;

    Sorting(String mode, int[] elements) {   //konstruktorju dodelim tabelo elementov
        this.arr = elements;
        this.modes = mode;
    }

    public String getModes() { return this.modes; }

    public void setMode(String modes) {
        if (modes.equals("trace"))
            this.modes = "trace";
        else
            this.modes = "count";
    }

    
    public boolean getDirection() { return this.direction; }

    public void setDirection(String instruction) {
        if (instruction.equals("up")) 
            this.direction = true;
        else if (instruction.equals("down"))
            this.direction = false;

        //return this.direction;
    }

    public void printOriginal() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
 
    public void printTrace(int change) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

            if (change == i) System.out.print("| ");
            
        }
        System.out.println();
    }

    

    private void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        this.moves += 3;        //za swap prištejem 3 premike
    }


    public void insertionS() {
        int n = arr.length;
        int change = 1;
        printOriginal();
        System.out.println();
        
        if (direction) {
            for (int i = 1; i <= n-1; i++) {
                int key = arr[i];
                int j = i;

                while (j > 0 && arr[j-1] > key) {
                    ++this.compares;
                    arr[j] = arr[j-1];
                    ++this.moves;   //povečam premik za 1
                    j = j - 1;
                }
                arr[j] = key;

                if (this.modes == "trace") {  //izpisovanje urejanja
                    printTrace(change);
                }
                change++;
            }
        }
        else {
            for (int i = 1; i <= n-1; i++) {
                int key = arr[i];
                int j = i;

                while (j > 0 && arr[j-1] < key) {
                    ++this.compares;
                    arr[j] = arr[j-1];
                    ++this.moves;   //povečam premik za 1
                    j = j - 1;
                }
                arr[j] = key;

                if (this.modes == "trace") {  //izpisovanje urejanja
                    printTrace(change);
                } else {
                    count();
                }
                change++;
            }
        }
    }

    public int[] selectionS(int[] arr) {
        int change = 0;
        printOriginal();    //izpišem vhodno tabelo števil

        System.out.println();

        for (int i = 0; i <= arr.length - 2; i++) {
            int m = i;
            for (int j = i + 1; j <= arr.length-1; j++) {
                this.compares++;
                if (direction) {
                    if (arr[j] < arr[m]) {
                        m = j;
                    }
                }
                else {
                    if (arr[j] > arr[m]) {
                        m = j;
                    }
                }
            }
            swap(i, m);
            if (this.modes == "trace") {  //izpisovanje urejanja
                printTrace(change);
            } else {
                count();
            }
            change++;
        }
        return arr;
    }

    public void count() {
            int[] count1 = selectionS(arr); //uredim
            System.out.print(this.moves + " " + this.compares + " | ");
            this.moves = 0;     //oba counterja resetiram in grem štet na novo, čez že urejeno tabelo
            this.compares = 0;
            
            //nato gremo izvajat 2. tokrat to izvajamo nad urejenim zaporedjem
            int[] count2 = selectionS(count1);
            System.out.print(this.moves + " " + this.compares + " | ");
            this.moves = 0;     //ponovno resetiram counterja na 0
            this.compares = 0;

            //3tja izvedba je ko imamo urejeno polje, ga uredimo v obratni smeri (obrnemo tabelo!!), če je bila smer naraščujoča je zdej padajoča oziroma obratno
            //enako preštejemo št premikov in primerjav
            int[] tableAround = new int[count2.length];
            int j = count2.length;
            for (int i = 0; i < count2.length; i++) {
                tableAround[j - 1] = count2[i];
                j = j - 1;
            }

            //uredimo obrnjeno tabelo
            int[] count3 = selectionS(tableAround);
            System.out.print(this.moves + " " + this.compares );
            this.moves = 0;     //ponovno resetiram counterja na 0
            this.compares = 0;
        
    }

    public void bubbleS() {
        int last;
        printOriginal();
        System.out.println();

        //while (i < arr.length - 1) {
        for (int i = 0; i < arr.length - 1; i = last) {
            last = arr.length - 1;
            if (direction) {
                for (int j = arr.length - 1; j > i; j--) {
                    this.compares++;
                    if (arr[j - 1] > arr[j]) {
                        swap(j - 1, j);
                        last = j;
                    }
                }
            }
            else {
                for (int j = arr.length - 1; j > i;j--) {
                    this.compares++;
                    if (arr[j - 1] < arr[j]) {
                        swap(j - 1, j);
                        last = j;
                    }
                }
            }
            if (this.modes == "trace") {
                printTrace(last-1);
            }
        }
    }

    public void mergeS() {
        if (arr.length <= 1);
    }

    public int partition(int left, int right) {
        int p = arr[left];
        int l = left;
        int r = right + 1;

        if (direction) {
            while (true) {
                do {
                    l++;
                } while ( arr[l] < p && l < right);

                do {
                    r--;
                } while (arr[r] > p);

                if (l >= r) break;
            }
            swap(l, r);       
        } else {
            while (true) {
                do {
                    l++;
                } while ( arr[l] > p && l < right);

                do {
                    r--;
                } while (arr[r] < p);

                if (l >= r) break;
            }
            swap(l, r); 
        }

        swap(left, r);
        return r;
    }

    public void quickS(int left, int right) {
        if (left > right) {
            int r = partition(left, right);

            quickS(left, r - 1);
            quickS(r + 1, right);
            if (this.modes == "trace") {  //izpisovanje urejanja
                //printTrace();
            }
        }
    }
}