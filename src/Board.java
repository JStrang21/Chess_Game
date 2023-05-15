public class Board {
    //int 1 represents white && int 2 represents black
    public Square[][] board = new Square[8][8];

    public Board() {
        //Sets up board with white pieces on one side and black pieces on other side
        initalizePieces();
    }

    public Piece getPiece(int x, int y) {
        return board[x][y].removePiece();
    }

    public boolean movePiece(int srcX, int srcY, int desX, int desY) {
        //Player decides where to move piece, board checks if move is possible given the specific pieces movement
        //Get target square from inputted x and y
        Square curSquare = board[srcX][srcY];
        //Get piece on the square
        Piece curPiece = curSquare.piece;
        //TODO account for if enemy piece is on des square
        boolean squareOccupied = board[desX][desY].isOccupied;
        //If move is possible and square has enemy piece then move piece to des square and account for kill
        if (curPiece.canMove(desX, desY) && squareOccupied)  {
            //board[desX][desY] =
        }
        else if (curPiece.canMove(desX, desY) && !squareOccupied) {
            board[desX][desY].piece = curPiece;
            curPiece.curX = desX;
            curPiece.curY = desY;
        }
        //Else return false and piece stays in square
        return false;
    }

    public void initalizePieces() {
        //Create array to hold each players' pieces
        Piece[] whitePieces = new Piece[16];
        Piece[] blackPieces = new Piece[16];
        //Instantiate pieces for each player
        whitePieces = createPieces(whitePieces, 1);
        blackPieces = createPieces(blackPieces, 2);
        //Add pieces to board
        board[0][0].addPiece(whitePieces[0]);
        //Match pieces with correct squares on board: black on top white on bottom
        for (int i = 0; i < 8; i++) {
            //Place rooks
            if (i == 0 || i == 7) {
                //board[0][i] = blackPieces[i];
                //board[7][i] = whitePieces[i];
            }
            //Place knights
            else if (i == 1 || i == 6) {
                //board[0][i] = blackPieces[i];
                //board[7][i] = whitePieces[i];
            }
            //Place bishops
            else if (i == 2 || i == 5) {
                //board[0][i] = blackPieces[i];
                //board[7][i] = whitePieces[i];
            }
            //Place king and queen
            else {
                //board[0][i] = blackPieces[i];
                //board[7][i] = whitePieces[i];
            }
        }
        //Place pawns
        for (int i = 0; i < 8; i++) {
            //board[1][i] = blackPieces[i + 8];
            //board[6][i] = whitePieces[i + 8];
        }




    }


    public Piece[] createPieces(Piece[] pieces, int color) {
        pieces[0] = new King();

        /*
        pieces[0] = new Rook();
        pieces[7] = new Rook();
        pieces[1] = new Knight();
        pieces[6] = new Knight();
        pieces[2] = new Bishop();
        pieces[5] = new Bishop();
        pieces [3] = new Queen();
        pieces[4] = new King();
        for (int i = 8; i < 16; i++) {
            pieces[i] = new Pawn();
        }
        */


        return pieces;
    }
}
