public class Square {
    boolean isOccupied;
    Piece piece;

    public Square() {
        isOccupied = false;
    }

    public void addPiece(Piece p) {
        if (isOccupied == true) this.piece = null;
        //Square is occupied
        this.piece = p;
        isOccupied = true;
    }


    public void removePiece() {
        //Create a temp piece you can return what is being removed
        //Piece temp = new Piece();
        //Square is not occupied
        isOccupied = false;
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

}
