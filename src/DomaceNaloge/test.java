package DomaceNaloge;

public class test {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.setMode("count");
        System.out.println(t.getMode());
        
    }
}

class Test2 {
    private int mode;

    Test2() {
        this.mode = mode;
    }

    public Test2(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        if (mode.equals("trace"))
            this.mode = 0;
        else
            this.mode = 1;
    }



}
