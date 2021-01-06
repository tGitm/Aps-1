package DomaceNaloge;

public class test2 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        t.setMode("count");
        System.out.println(t.getMode());
        int tab[] = {0,1,2,3,4,5,6,7,8,9};
        t.integer(tab);
        
        
    }
}


class Test3 {
    private int mode;

    Test3() {
        this.mode = mode;
    }

    public Test3(int mode) {
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

    public void integer(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



}

