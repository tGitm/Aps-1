package DomaceNaloge;

import java.util.Scanner;

class UrejanjeZaporedjaStevil {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String read = sc.nextLine();
            String[] arg = read.split("\\s+");

            
            String[] input = sc.nextLine().split("\\s+"); //številke za sortiranje
            //arg[0] - trace/count, arg[1] - sortings, arg[2] - up/down
            switch(arg[1]) {
                case "insert": 
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

}
