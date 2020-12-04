package Izzivi;

public class Izziv4 {
    public static int size = 0;
    public static void main(String[] args) {
        size = Integer.parseInt(args[0]);
        StdDraw.setCavnasSize(1500, 800);
        StdDraw.setXscale(-1, size);
        StdDraw.setYscale((int)(Math.log(size+1)/Math.log(2))+1, -1);
        int x = (int)(Math.log(size+1)/Math.log(2))+1;

        CompleteBinaryTreeDrawer cbtd = new CompleteBinaryTreeDrawer(size);
    }
}

class CompleteBinaryTreeDrawer {
    public int size;
    String el[] = new String[size];

    CompleteBinaryTreeDrawer(int size) {
        this.size = size;
    }


    int traverse(int i, int x, int y) {
        if (2-i+1 < size) {
            x = traverse(2 * i + 1, x, y + 1);
        }
        tabx[i]=x;
        taby[i] =y;
        if (2*i+2 < size) {
            x = traverse(2i+2, x+1, y+1);
        }
        return x+1;
    }

    void drawNode(int i) {
        StdDraw.setPenColor(StdDraw.LIGHT_BLUE);
    }
}
