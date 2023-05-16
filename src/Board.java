public class Board {
    //int 1 represents white && int 2 represents black
    public Square[][] board = new Square[8][8];

    public Board() {
        //Sets up board with white pieces on one side and black pieces on other side
        initalizePieces();
    }

    public Piece getPiece(int x, int y) {
        return board[x][y].piece;
    }

    public boolean movePiece(int srcX, int srcY, int desX, int desY) {
        //Player decides where to move piece, board checks if move is possible given the specific pieces movement
        //Get target piece from inputted x and y
        Piece targetPiece = board[srcX][srcY].piece;
        //TODO account for if enemy piece is on des square
        boolean squareOccupied = board[desX][desY].isOccupied;
        //If move is possible and square has enemy piece then move piece to des square and account for kill
        if (targetPiece.canMove(desX, desY) && squareOccupied)  {
            //Remove target piece from original square
            board[srcX][srcY].removePiece();
            //TODO account for enemy killed here: remove piece from des square and remove piece from list of pieces


            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            targetPiece.setCoordinates(desX, desY);
        }
        //If move is possible and no enemy piece on destination square
        else if (targetPiece.canMove(desX, desY) && !squareOccupied) {
            //Move piece to destination square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoordinates(desX, desY);
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
        pieces[0] = new King(color);
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
