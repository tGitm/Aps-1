package DomaceNaloge;

public class test {
    public static void main(String[] args) {
        Ttest2 t = new Ttest2();
        t.setMode("count");
        System.out.println(t.getMode());
        
    }
}

class Ttest2 {
    private int mode;

    Ttest2() {
        this.mode = mode;
    }

    public Ttest2(int mode) {
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
