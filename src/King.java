public class King extends Piece{
    //Current square position
    String name = "King";

    public boolean canMove(int x, int y) {
        System.out.println(curX);
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

    public String getName() {
        return name;
    }
    public void printPiece() {
        System.out.println();
    }
}
