public class King extends Piece{
    String name = "King";

    public King(int c) {
        //Constructor to specify color
        color = c;
    }

    @Override
    public String getNameString() {
        return name;
    }

    public boolean canMove(Square[][] b, int desX, int desY) {
        Piece occupyingPiece = b[desX][desY].getPiece();
        //King can only move one space
        if (Math.abs(desX - curX) != 1 || Math.abs(desY - curY) != 1) {
            return false;
        }


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
