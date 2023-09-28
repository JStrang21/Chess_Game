public abstract class Piece extends Square{
    //1 = white && 2 = black
    int color;
    //Current square position
    int curX;
    int curY;
    String name;

    /*public boolean canMove(int desX, int desY) {
        //From current square position check if specific piece can make given move

        return false;
    }*/

    abstract boolean canMove(Square[][] b, int desX, int desY);

    public void setCoords(int desX, int desY) {
        curX = desX;
        curY = desY;
    }

    public int getX() {
        return curX;
    }

    public int getY() {
        return curY;
    }

    public String getColor() {
        if (color == 1) {
            return "White";
        }
        return "Black";
    }

    public String getColorChar() {
        if (color == 1) {
            return "w";
        }
        return "b";
    }

    public String getNameChar() {
        String name = this.getName();
        String firstLetter = this.getName().substring(0, 1);
        return firstLetter;
    }

    public int getColorInt() {
        return color;
    }

    abstract String getName(

    );

    public void print() {
        System.out.println(curX + " " + curY + " " + this.getColor() + " " + this.getName());
    }
    public void printOnBoard() {
        System.out.print(this.getColorChar() + this.getNameChar());
    }
    //abstract boolean tracePath(int destX, int destY);
}
