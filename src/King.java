public class King extends Piece{
    //Current square position
    String name = "King";

    public King(int c) {
        color = c;
    }

    public boolean canMove(int x, int y) {
        return true;
    }


    public boolean traceMovement() {
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
    }

    /*public String getColor() {
        if (color == 1) {
            return "White";
        }
        return "Black";
    }

    public int getColorInt() {
        return color;
    }*/

    public String getName() {
        return name;
    }
    public void printPiece() {
        System.out.println();
    }
}
