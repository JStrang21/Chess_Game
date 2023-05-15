public class Square {
    boolean isOccupied = false;
    int color;
    Piece piece;

    public void addPiece(Piece p) {
        //Square is occupied
        piece = p;
        isOccupied = true;
    }

    public Piece removePiece() {
        //Create a temp piece so you can return what is being removed
        //Piece temp = new Piece();
        //Square is not occupied
        isOccupied = false;
        //piece = null;
        return piece;
    }

}
