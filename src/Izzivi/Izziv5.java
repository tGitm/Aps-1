package Izzivi;

public class Izziv5 {
    public  static int st = 0;

    public static void main(String[] args) {
        st = Integer.parseInt(args[0]);
        System.out.println(st);
        Blablablba bla = new Blablablba(st);
        bla.lumpać();
    }
}

class Blablablba {
    public int stevilo;
    Blablablba(int stevilo){
        this.stevilo = stevilo;
    }
    void lumpać() {
        if(stevilo == 15){
            System.out.println("ti lumpać");
        }
    }
}
