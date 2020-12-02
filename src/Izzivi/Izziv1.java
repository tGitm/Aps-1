package Izzivi;

public class Izziv1 {
    public static void main(String[] args) throws CollectionException {
        Stack<String> s = new ArrayDeque<>();
        Deque<String> d = new ArrayDeque<>();
        Sequence<String> sq = new ArrayDeque<>();

        s.push("ABC"); s.push("DEF"); s.push("GHI");

        System.out.print("Stack: ");
        while (!s.isEmpty()){
            System.out.print(s.top() + " ");
            d.enqueueFront(s.pop());
        }


        System.out.print("\nDeque: ");
        while (!d.isEmpty()){
            System.out.print(d.back() + " ");
            sq.add(d.dequeueBack());
        }

        System.out.print("\nSequence: ");
        for (int i = 0; i < sq.size(); i++){
            System.out.print((i + 1) + "." + sq.get(i) + " ");
        }
    }
}

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


interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}


interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}


interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}

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