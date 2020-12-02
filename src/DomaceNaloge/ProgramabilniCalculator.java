package DomaceNaloge;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class ProgramabilniCalculator {
    public static boolean izpPogoj = false;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        Calculator ca = new Calculator();

        Sequence<Stack<String>> zaporedje = new ArrayDeque<>();
        for (int i = 0; i < 42; i++) {
            Stack<String> st = new ArrayDeque();
            zaporedje.add(st);
        }

        ca.vhodKalkulatorja(zaporedje);
    }

}

@SuppressWarnings("unchecked")
class Calculator {
    @SuppressWarnings("unchecked")
    public void clear1(Sequence<Stack<String>> zap, int y) throws CollectionException {
        while (!(zap.get(y).isEmpty())) {
            zap.get(y).pop();
        }
    }

    @SuppressWarnings("unchecked")
    public void clear(Sequence<Stack<String>> zap) throws CollectionException {
        for (int i = 0; i < 42; i++) {
            clear1(zap, i);
        }
    }

    @SuppressWarnings("unchecked")
    public void echo(Sequence<Stack<String>> zap) throws CollectionException {
        if (!zap.isEmpty()) {
            System.out.println(zap.get(0).top());
        }

        else if (zap.isEmpty()){
            System.out.println(" ");
        }
    }

    @SuppressWarnings("unchecked")
    public void print(Sequence<Stack<String>> zap) throws CollectionException {

        int prazen = 0;
        int index = Integer.parseInt(zap.get(0).pop()); 


        // da dobim prazen stack
        for (int i = 1; i < 42; i++) {
            if (zap.get(i).isEmpty()) {// prazen = Integer.parseInt(zap.get(i).pop());
                prazen = i;
                break;

            }
        }
        // izpisan = zap.get(0).pop();

        while (!zap.get(index).isEmpty()) {
            String popan =  zap.get(index).pop();
            zap.get(prazen).push(popan); // vse vrednosti z tega stacka kopiram v nov stack, za izpisovanje
        }

        while (!zap.get(prazen).isEmpty()) {
            String izNjega = (String) zap.get(prazen).pop();
            zap.get(index).push(izNjega); // to vrednost kopiram nazaj v glavni sklad
            System.out.print(izNjega+ " ");


        }
        System.out.print("\n");
    }


    @SuppressWarnings("unchecked")
    public void dup2(Sequence<Stack<String>> zap) throws CollectionException {
        String prvi = zap.get(0).pop();
        String drugi = zap.get(0).pop();

        for (int i = 0; i < 2; i++) {
            zap.get(0).push(drugi);
            zap.get(0).push(prvi);
        }
    }

    @SuppressWarnings("unchecked")
    public void swap(Sequence<Stack<String>> zap) throws Exception, CollectionException{
        String prPar = zap.get(0).pop();
        String drPar = zap.get(0).pop();

        zap.get(0).push(prPar);
        zap.get(0).push(drPar);

    }
    @SuppressWarnings("unchecked")
    public void char1(Sequence<Stack<String>> zap) throws Exception, CollectionException{
        char ch1 = (char) Integer.parseInt( zap.get(0).pop());
        zap.get(0).push(String.valueOf(ch1));
    }

    @SuppressWarnings("unchecked")
    public void even(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        if (Integer.parseInt(zap.get(0).pop()) % 2 == 0){
            zap.get(0).push(String.valueOf(1));
        }
        else{
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void odd(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        if (Integer.parseInt(zap.get(0).pop()) % 2 != 0){
            zap.get(0).push(String.valueOf(1));
        }
        else{
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void fakt(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int zmnozeno = 1;
        int range = Integer.parseInt(zap.get(0).pop());

        for (int i = 1; i <= range; i++) {
            zmnozeno = zmnozeno * i;

        }
        zap.get(0).push(String.valueOf(zmnozeno));
    }

    @SuppressWarnings("unchecked")
    public void len(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        String dolz = zap.get(0).pop();
        zap.get(0).push(String.valueOf(dolz.length()));
    }

    @SuppressWarnings("unchecked")
    public void manjVec(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr = Integer.parseInt(zap.get(0).pop()); //y
        int dr = Integer.parseInt(zap.get(0).pop()); //x

        if (dr < pr || dr > pr) {
            zap.get(0).push(String.valueOf(1));
        }
        else if (pr == dr) {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void manj(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_ = Integer.parseInt(zap.get(0).pop()); //y
        int dr_ = Integer.parseInt(zap.get(0).pop()); //x

        if (dr_ < pr_) {
            zap.get(0).push(String.valueOf(1));
        }else {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void manjEnako(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_2 = Integer.parseInt(zap.get(0).pop()); //y
        int dr_2 = Integer.parseInt(zap.get(0).pop()); //x

        if (dr_2 <= pr_2) {
            zap.get(0).push(String.valueOf(1));
        }else {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void enako(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_3 = Integer.parseInt(zap.get(0).pop()); //y
        int dr_3= Integer.parseInt(zap.get(0).pop()); //x

        if (pr_3 == dr_3) {
            zap.get(0).push(String.valueOf(1));
        }else {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void vecje(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_4 = Integer.parseInt(zap.get(0).pop());
        int dr_4 = Integer.parseInt(zap.get(0).pop());

        if (dr_4 > pr_4) {
            zap.get(0).push(String.valueOf(1));
        }else {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void vecjeEnako(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_5 = Integer.parseInt(zap.get(0).pop()); //y
        int dr_5 = Integer.parseInt(zap.get(0).pop()); //x

        if (dr_5 >= pr_5) {
            zap.get(0).push(String.valueOf(1));
        }else {
            zap.get(0).push(String.valueOf(0));
        }
    }

    @SuppressWarnings("unchecked")
    public void sestevanje(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_6 = Integer.parseInt(zap.get(0).pop());
        int dr_6 = Integer.parseInt(zap.get(0).pop());

        zap.get(0).push(String.valueOf(pr_6 + dr_6));

    }

    @SuppressWarnings("unchecked")
    public void odstevanje(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_7 = Integer.parseInt(zap.get(0).pop());
        int dr_7 = Integer.parseInt(zap.get(0).pop());

        zap.get(0).push(String.valueOf(dr_7 - pr_7));

    }

    @SuppressWarnings("unchecked")
    public void mnozenje(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int pr_8 = Integer.parseInt(zap.get(0).pop());
        int dr_8 = Integer.parseInt(zap.get(0).pop());

        zap.get(0).push(String.valueOf(pr_8 * dr_8));

    }

    @SuppressWarnings("unchecked")
    public void deljenje(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        //tuki pogledam če se deli z 0
        if (zap.get(0).top().equals("0")) {
            ProgramabilniCalculator.izpPogoj = false;
        }

        int pr_9 = Integer.parseInt(zap.get(0).pop()); //y
        int dr_9 = Integer.parseInt(zap.get(0).pop()); //x

        int zdeljen = dr_9 / pr_9;

        zap.get(0).push(String.valueOf(zdeljen));

    }

    @SuppressWarnings("unchecked")
    public void ostanek(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        if (zap.get(0).top().equals("0")) {
            ProgramabilniCalculator.izpPogoj = false;
        }

        int pr_10 = Integer.parseInt(zap.get(0).pop()); //y
        int dr_10 = Integer.parseInt(zap.get(0).pop()); //x

        int ostanek = dr_10 % pr_10;

        zap.get(0).push(String.valueOf(ostanek));

    }

    @SuppressWarnings("unchecked")
    public void zlepi(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        String pr_str = zap.get(0).pop();
        String dr_str = zap.get(0).pop();

        String zlepljen = " ";
        zlepljen = dr_str + pr_str;
        zap.get(0).push(zlepljen);

    }

    @SuppressWarnings("unchecked")
    public void randnom(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int max = Integer.parseInt(zap.get(0).pop());
        int min = Integer.parseInt(zap.get(0).pop());

        int rnd = (int) (Math.random()*(max - min) + min);
        zap.get(0).push(String.valueOf(rnd));

    }

    @SuppressWarnings("unchecked")
    public void then(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        String vrhnje = zap.get(0).pop();

        if (!vrhnje.equals("0")) {
            ProgramabilniCalculator.izpPogoj = true;
        }
        else {
            ProgramabilniCalculator.izpPogoj = false;
        }

    }

    @SuppressWarnings("unchecked")
    public void tElse(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        if (!ProgramabilniCalculator.izpPogoj) {
            ProgramabilniCalculator.izpPogoj = true;
        }
        else {
            ProgramabilniCalculator.izpPogoj = false;
        }

    }

    @SuppressWarnings("unchecked")
    public void reverse(Sequence<Stack<String>> zap) throws Exception, CollectionException {

        /*int prazen = 0;
        int prazen2 = 0;
        */int top = Integer.parseInt(zap.get(0).pop()); // z glavenga stacka zbrišem številko katera je prej bla vnesena


        // da dobim prazen stack
        /*for (int i = 1; i < 42; i++) {
            if (zap.get(i).isEmpty()) {// prazen = Integer.parseInt(zap.get(i).pop());
                prazen = i;
                break;

            }
        }

        for (int j = 0; j < 42; j++) {
            if (zap.get(j).isEmpty()) {
                prazen2 = j;
                break;
            }
        }*/

        Stack<String> prazen = new ArrayDeque();
        Stack<String> prazen2 = new ArrayDeque();


        while (!zap.get(top).isEmpty()) {
            prazen.push(zap.get(top).pop());
            /*String popan =  zap.get(top).pop();
            zap.get(prazen).push(popan); // vse vrednosti z tega stacka kopiram v nov stack, za izpisovanje
        */}

        while (!prazen.isEmpty()) {
            prazen2.push(prazen.pop());
            /*String izNjega = (String) zap.get(prazen).pop();
            zap.get(prazen2).push(izNjega); // to vrednost kopiram nazaj v glavni sklad
            //System.out.print(izNjega + " ");*/


        }

        while (!prazen2.isEmpty()) {
            zap.get(top).push(prazen2.pop());
            /*String izPraz2 = (String) zap.get(prazen2).pop();
            zap.get(top).push(izPraz2);
            //System.out.print(izPraz2 + " ");*/
        }
    }

    @SuppressWarnings("unchecked")
    public void move(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        int top = Integer.parseInt(zap.get(0).pop());
        int podTop = Integer.parseInt(zap.get(0).pop());

        for (int i = 0; i < podTop; i++) {
            zap.get(top).push(zap.get(0).pop());
        }
    }

    @SuppressWarnings("unchecked")
    public void run(Sequence<Stack<String>> zap, int index) throws Exception, CollectionException {
        int prazen = 0;
        for (int i = 1; i < zap.size(); i++) {
            if (zap.get(i).isEmpty()) {
                prazen = i;
            }
        }
        
        while (!zap.get(index).isEmpty()) {
            zap.get(prazen).push(zap.get(index).pop());
        }
    }


    @SuppressWarnings("unchecked")
    public void loop(Sequence<Stack<String>> zap) throws Exception, CollectionException {
        String prvi = zap.get(0).pop();
        int x = Integer.parseInt(prvi);
        String drugi = zap.get(0).pop();
        int y = Integer.parseInt(prvi);

        
        /*for (int i = 0; i < y; i++) {
            
        }*/
    }

    @SuppressWarnings("unchecked")
    public void vhodKalkulatorja(Sequence<Stack<String>> zap) throws CollectionException, Exception {
        //s pomočjo 3 scannerjev preberem standardni vhod
        String s1 = "";
        String s2 = "";
        Scanner sc1;
        Scanner sc2;

        sc1 = new Scanner(System.in);
        //sc1 = new Scanner(new File("viri/test.txt"));
        while (sc1.hasNextLine()) {
            s1 = sc1.nextLine();
            ProgramabilniCalculator.izpPogoj = false;
            clear(zap);

            sc2 = new Scanner(s1);
            while (sc2.hasNext()){
                s2 = sc2.next();
                
                if (s2.equals("fun")) { 
                    int top = Integer.parseInt(zap.get(0).pop());
                    int podTop = Integer.parseInt(zap.get(0).pop());
                        
                    for (int i = 0; i < podTop; i++) {
                        s2 = sc2.next();
                        zap.get(top).push(s2);
                    }continue;
                }

                

                if (s2.contains("?")) {
                    String [] sp = s2.split("\\?");
                    //String s3[] = new String[s2.length()];
                    if (ProgramabilniCalculator.izpPogoj) {
                        //for (int j = 1; j <= s3.length; j++) {
                            switch(sp[1]) {
                                case "echo":
                                echo(zap);
                                break ;

                                case "clear":
                                    clear(zap);
                                    break;

                                case "pop":
                                    zap.get(0).pop();
                                    break;

                                case "dup":
                                    zap.get(0).push(zap.get(0).top());
                                    break;

                                case "dup2":
                                    dup2(zap);
                                    break;

                                case "swap":
                                    swap(zap);
                                    break;

                                case "char":
                                    char1(zap);
                                    break;

                                case "even":
                                    even(zap);
                                    break;

                                case "odd":
                                    odd(zap);
                                    break;

                                case "!":
                                    fakt(zap);
                                    break;

                                case "len":
                                    len(zap);
                                    break;

                                case "<>":
                                    manjVec(zap);
                                    break;

                                case "<":
                                    manj(zap);
                                    break;

                                case "<=":
                                    manjEnako(zap);
                                    break;

                                case "==":
                                    enako(zap);
                                    break;

                                case ">":
                                    vecje(zap);
                                    break;

                                case ">=":
                                    vecjeEnako(zap);
                                    break;

                                case "+":
                                    sestevanje(zap);
                                    break;

                                case "-":
                                    odstevanje(zap);
                                    break;

                                case "*":
                                    mnozenje(zap);
                                    break;

                                case "/":
                                    deljenje(zap);
                                    break;

                                case "%":
                                    ostanek(zap);
                                    break;

                                case ".":
                                    zlepi(zap);
                                    break;

                                case "rnd":
                                    randnom(zap);
                                    break;

                                case "then":
                                    then(zap);
                                    break;

                                case "else":
                                    tElse(zap);
                                    break;

                                case "print":
                                    print(zap);
                                    break;

                                case "move":
                                    move(zap);
                                    break;

                                case "fun":
                                    int top = Integer.parseInt(zap.get(0).pop());
                                    int podTop = Integer.parseInt(zap.get(0).pop());
                            
                                    for (int i = 0; i < podTop; i++) {
                                        zap.get(top).push(s2);
                                    }
                                    break;
                                
                                case "run":
                                    int ind = Integer.parseInt(zap.get(0).pop());
                                    
                                    
                                    while (!zap.get(ind).isEmpty()) {
                                        zap.get(0).push(zap.get(ind).pop());
                                    }    
                                    break;

                                case "loop":
                                    loop(zap);
                                    break;

                                case "reverse":
                                    reverse(zap);
                                    break;

                                default:
                                    zap.get(0).push(sp[1]);
                                }
                            //}  for loop
                        }  //notranji if
                    }  //zunanji if

                    else {
                        switch (s2) {
                            case "echo":
                            echo(zap);
                            break ;

                            case "pop":
                                zap.get(0).pop();
                                break;

                            case "clear":
                                clear(zap);
                                break;

                            case "dup":
                                zap.get(0).push(zap.get(0).top());
                                break;

                            case "dup2":
                                dup2(zap);
                                break;

                            case "swap":
                                swap(zap);
                                break;

                            case "char":
                                char1(zap);
                                break;

                            case "even":
                                even(zap);
                                break;

                            case "odd":
                                odd(zap);
                                break;

                            case "!":
                                fakt(zap);
                                break;

                            case "len":
                                len(zap);
                                break;

                            case "<>":
                                manjVec(zap);
                                break;

                            case "<":
                                manj(zap);
                                break;

                            case "<=":
                                manjEnako(zap);
                                break;

                            case "==":
                                enako(zap);
                                break;

                            case ">":
                                vecje(zap);
                                break;

                            case ">=":
                                vecjeEnako(zap);
                                break;

                            case "+":
                                sestevanje(zap);
                                break;

                            case "-":
                                odstevanje(zap);
                                break;

                            case "*":
                                mnozenje(zap);
                                break;

                            case "/":
                                deljenje(zap);
                                break;

                            case "%":
                                ostanek(zap);
                                break;

                            case ".":
                                zlepi(zap);
                                break;

                            case "rnd":
                                randnom(zap);
                                break;

                            case "then":
                                then(zap);
                                break;

                            case "else":
                                tElse(zap);
                                break;

                            case "print":
                                print(zap);
                                break;

                            case "move":
                                move(zap);
                                break;

                            case "run":
                                int ind = Integer.parseInt(zap.get(0).pop());
                                //for (int i = 0; i < zap.get(0).size(); i++) {
                                run(zap, ind);
                                break;

                            case "loop":
                                loop(zap);
                                break;

                            case "reverse":
                                reverse(zap);
                                break;

                            default:
                                zap.get(0).push(s2);
                        }
                    
                }
            }
        }
    }

}
        
//Koda Izziv 1
@SuppressWarnings("unchecked")
class CollectionException extends Exception {
    public CollectionException(String msg) {
        super(msg);
    }
}

interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();
    boolean isFull();
    int size();

    String toString();
}

@SuppressWarnings("unchecked")
interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}

@SuppressWarnings("unchecked")
interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}

@SuppressWarnings("unchecked")
interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}

@SuppressWarnings("unchecked")
class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    private T[] a;
    private int front, back, size;

    public ArrayDeque() {
        a = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {

        return back == DEFAULT_CAPACITY;
    }

    private int next(int i) {

        return (i + 1) % DEFAULT_CAPACITY;
    }

    private int prev(int i) {
        return (DEFAULT_CAPACITY + i - 1) % DEFAULT_CAPACITY;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        if (size > 0) {
            sb.append(a[front].toString());
        }
        for (int i = 0; i < (size - 1); i++) {
            sb.append("," + a[next(front+i)]);

        }
        sb.append("]");
        return sb.toString();
    }

    public T top() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        return a[prev(back)];
    }

    public void push(T x) throws CollectionException {
        if (isFull()) {
            throw new CollectionException(ERR_MSG_FULL);
        }

        a[back] = x;
        back = next(back);
        size++;
    }

    public T pop() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        back = prev(back);
        T o = a[back];
        a[back] = null;
        size--;
        return o;
    }

    private int index(int i) {
        return (front + i) % DEFAULT_CAPACITY;
    }

    public void add (T x) throws CollectionException {
        push(x);
    }

    public T get(int i) throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        if (i < 0 || i >= size) {
            throw new CollectionException(ERR_MSG_INDEX);
        }

        return a[index(i)];
    }


    public T front() throws CollectionException {
        return get(size);
    }

    public T back() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        return a[prev(back)];
    }

    public void enqueue(T x) throws CollectionException {
        if (isFull()) {
            throw new CollectionException(ERR_MSG_FULL);
        }

        push(x);
    }

    public void enqueueFront(T x) throws CollectionException {
        if (isFull()) {
            throw new CollectionException(ERR_MSG_FULL);
        }

        front = prev(front);
        a[front] = x;
        size++;

    }


    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        front = prev(front);
        T o = a[front];
        a[front] = null;
        size--;
        return o;
    }

    public T dequeueBack() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }

        back = prev(back);
        T o = a[back];
        a[back] = null;
        size--;
        return o;
    }
}