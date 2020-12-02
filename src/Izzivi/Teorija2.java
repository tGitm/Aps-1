package Izzivi;
import java.util.Stack;

public class Teorija2 {
    public static void main(String[] args) {
        Stack stackOrg = new Stack();
        stackOrg.push(1);
        stackOrg.push(2);
        stackOrg.push(3);
        stackOrg.push(4);
        stackOrg.push(5);

        System.out.println("Začetni sklad: " + stackOrg);
        obrni(stackOrg, 1, 3);
    }

    public static void obrni(Stack s, int n, int m){
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        Stack st3 = new Stack();

        int size = s.size() -1;

        for (int i = n+1; i < m; i++) {
            st1.push(s.pop());
        }

        for (int i = m; i <= size ; i++) {
            st2.push(s.pop());
        }
        st3.push(s);
        st3.push(st2);
        st3.push(st1);
        /*System.out.println("st1:" + st1);
        System.out.println("st2:" + st2);
        System.out.println("ostanek - st3:" + s);*/
        System.out.println("Obrnjen sklad: " + st3);
    }
}