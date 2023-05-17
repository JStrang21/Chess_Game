public class King extends Piece{
    String name = "King";

    public King(int c) {
        //Constructor to specify color
        color = c;
    }

    public boolean canMove(Square[][] b, int x, int y) {
        return true;
    }

    public String getName() {
        return name;
    }

    /*public void printPiece() {
        System.out.println();
    }

    *public boolean traceMovement() {
        return false;
    }

    public void name() {
        System.out.println(name);
    }
    public void printTest() {
        System.out.println("Hello");
    }

    boolean tracePath(int destX, int destY) {

        return false;
    }*/

    /*public String getColor() {
        if (color == 1) {
            return "White";
        }
        return "Black";
    }

    public int getColorInt() {
        return color;
    }*/
}
