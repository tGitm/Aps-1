import java.awt.*;

public class Izziv4 {
    public static int size = 0;
    public static void main(String[] args) {
        //StdDraw.setCanvasSize(1500, 800);
        size = Integer.parseInt(args[0]);
        //StdDraw.setXscale(-1, size);
        //StdDraw.setYscale((int)(Math.log(size+1)/Math.log(2))+1, -1);
        int x = (int)(Math.log(size+1)/Math.log(2))+1;

        CompleteBinaryTreeDrawer cbtd = new CompleteBinaryTreeDrawer(size);
        //cbtd.levelOrder();
        //cbtd.inOrder(0);
        cbtd.drawPostorder(0);
    }
}

class CompleteBinaryTreeDrawer {
    public int size;
    int []tabx;
    int []taby;
    String el[] = new String[size];

    CompleteBinaryTreeDrawer(int size) {
        this.size = size;
        this.tabx = new int[size];
        this.taby = new int[size];
        traverse(0,0,0);
    }

    void drawEdgeToParent(int i) {
        int koorX = tabx[i];
        int koorY = taby[i];
        //i je indedks vozlišča -> izračunam kdo je oče (i-n)/2
        int x2 = tabx[(i-1) /2];
        int y2 = taby[(i-1) /2];

        //narišem črto
        //StdDraw.line(koorX, koorY, x2, y2);
    }

    void drawNode(int i) {
        //StdDraw.setPenColor(Color.BLUE);
        //StdDraw.filledCircle(tabx[i], taby[i], 0.2);
    }

    //slide 104 vaje
    int traverse(int i, int x, int y) {
        if (2*i+1 < size) {
            x = traverse(2 * i + 1, x, y + 1);
        }
        tabx[i] = x;
        taby[i] = y;
        if (2*i+2 < size) {
            x = traverse(2*i+2, x+1, y+1)-1;
        }
        return x+1;
    }

    //kot na vajah
    void levelOrder() {
        for (int i = 0; i < size; i++) {
            //najprej narišem povezavo nato šele krog
            drawEdgeToParent(i);
            drawNode(i);
        }
    }

    void inOrder(int i) {
        if (2*i+1 < size) {
            inOrder(2*i+1);
        }
        //najprej narišem povezavo nato šele krog
        drawEdgeToParent(i);
        drawNode(i);

        if (2*i+2 < size) {
            inOrder(2*i+2);
        }
    }

    void drawPostorder(int i) {
        if (2 * i + 1 < size) {
            inOrder(2 * i + 1);
        }
        if (2 * i + 2 < size) {
            inOrder(2 * i + 2);
        }
        //najprej narišem povezavo nato šele krog
        drawEdgeToParent(i);
        drawNode(i);
    }



}
