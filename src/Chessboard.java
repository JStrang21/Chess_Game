public class Chessboard {
    //8x8 Board of squares/chessboard
    public Square[][] board = new Square[8][8];

    public Chessboard() {
        //Sets up board with white pieces on one side and black pieces on other side
        initalizePieces();
    }

    public Piece getPiece(int x, int y) {
        return board[x][y].piece;
    }

    //TODO: determine if this method needs to be boolean or void
    public boolean movePiece(int srcX, int srcY, int desX, int desY) {
        //Player decides where to move piece, board checks if move is possible given the specific pieces movement
        //Get target piece from inputted x and y
        Piece targetPiece = board[srcX][srcY].piece;
        //TODO account for if enemy piece is on des square
        boolean squareOccupied = board[desX][desY].isOccupied;
        Piece occupyingPiece = board[desX][desY].getPiece();
        //If color of piece occupying destination square is same color, then cannot move there
        if ((targetPiece.getColorInt() == occupyingPiece.getColorInt()) && squareOccupied) {
            return false;
        }
        //If move is possible and square has enemy piece then move piece to des square and account for kill
        if (targetPiece.canMove(board, desX, desY) && squareOccupied)  {
            //TODO account for enemy killed here: remove piece from des square and remove piece from list of pieces
            //Piece killedPiece = getPiece(desX, desY);
            //Remove target piece from original square
            board[srcX][srcY].removePiece();

            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            targetPiece.setCoords(desX, desY);
        }
        //If move is possible and no enemy piece on destination square
        else if (targetPiece.canMove(board, desX, desY) && !squareOccupied) {
            //Move piece to destination square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            //Remove piece from previous square
            board[srcX][srcY].removePiece();
        }
        //Else return false and piece stays in square
        return false;
    }

    public void initalizePieces() {
        //Initalize board squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square();
            }
        }
        //Create array to hold each players' pieces
        //TODO maybe have pieces arrays be class variables
        Piece[] whitePieces = new Piece[16];
        Piece[] blackPieces = new Piece[16];

        //Instantiate pieces for each player
        whitePieces = createPieces(whitePieces, 1);
        blackPieces = createPieces(blackPieces, 2);

        //Print check
        //Add piece from pieces array to square
        //this.board[0][0].addPiece(whitePieces[0]);
        //this.board[0][1].addPiece(blackPieces[0]);
        //Use getName which is implemented by specific piece classes which implement abstract piece class
        //System.out.println(board[0][0].piece.getName());

        //Add pieces to board
        //Match pieces with correct squares on board: black on top white on bottom
        for (int i = 0; i < 8; i++) {
            //Add piece to appropriate starting square
            board[0][i].addPiece(whitePieces[i]);
            //Set piece coordinates
            whitePieces[i].setCoords(0, i);

            //Add piece to appropriate starting square
            board[7][i].addPiece(blackPieces[i]);
            //Set piece coordinates
            blackPieces[i].setCoords(7, i);
        }
        //Place pawns
        for (int i = 0; i < 8; i++) {
            //Add piece to appropriate starting square
            board[1][i].addPiece(whitePieces[i + 8]);
            //Set piece coordinates
            whitePieces[i + 8].setCoords(1, i);

            //Add piece to appropriate starting square
            board[6][i].addPiece(blackPieces[i + 8]);
            //Set piece coordinates
            blackPieces[i + 8].setCoords(6, i);
        }
    }

    public Piece[] createPieces(Piece[] pieces, int color) {
        //Pieces added to array in order of board position
        pieces[0] = new Rook(color);
        pieces[1] = new Knight(color);
        pieces[2] = new Bishop(color);
        pieces [3] = new Queen(color);
        pieces[4] = new King(color);
        pieces[5] = new Bishop(color);
        pieces[6] = new Knight(color);
        pieces[7] = new Rook(color);

        //For loop to add pawns
        for (int i = 8; i < 16; i++) {
            pieces[i] = new Pawn(color);
        }

        return pieces;
    }
}
