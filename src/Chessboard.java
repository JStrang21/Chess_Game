import java.util.LinkedList;

public class Chessboard {
    //8x8 Board of squares/chessboard
    public Square[][] board = new Square[8][8];
    public LinkedList<Piece> removedPieces = new LinkedList<Piece>();
    //Ensure correct turns
    boolean whiteTurn = true;
    boolean blackTurn = false;
    Player white;
    Player black;


    public Chessboard(Player w, Player b) {
        white = w;
        black = b;
        //Sets up board with white pieces on one side and black pieces on other side
        initalizePieces();
    }

    public Piece getPiece(int x, int y) {
        //TODO: maybe make a new "empty square" piece so it doesnt return null
        if (board[x][y].piece == null) {
            Piece empty = new Empty();
            return empty;
        }
        return board[x][y].piece;
    }

    //TODO: determine if this method needs to be boolean or void
    public boolean movePiece(String src, String des) {
        //String src = srcX and srcY while String des = desX and desY
        int[] convertedCoords = convert(src, des);
        int srcX = convertedCoords[0];
        int srcY = convertedCoords[1];
        int desX = convertedCoords[2];
        int desY = convertedCoords[3];
        //TODO create converter fn to convert string input coords into array access (Ex: A1 == 0, 0)
        //Player decides where to move piece, board checks if move is possible given the specific pieces movement
        //Get target piece from inputted x and y
        Piece targetPiece = board[srcX][srcY].piece;
        //Check if turn is out of order
        if (white.isTurn() && targetPiece.getColorInt() != white.color) {
            System.out.println("Not black player's turn");
            return false;
        }
        if (black.isTurn() && targetPiece.getColorInt() != black.color) {
            System.out.println("Not white player's turn");
            return false;
        }


        //TODO account for if enemy piece is on des square

        boolean squareOccupied = board[desX][desY].isOccupied;
        Piece occupyingPiece = board[desX][desY].getPiece();
        if (occupyingPiece ==  null && targetPiece.canMove(board, desX, desY)) {
            //Remove target piece from original square
            board[srcX][srcY].removePiece();
            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            changeTurn();
            return true;
        }
        else if (occupyingPiece == null && !targetPiece.canMove(board, desX, desY)) {
            System.out.println("Illegal move");
            return false;
        }
        //If color of piece occupying destination square is same color, then cannot move there
        //Might not need second condition (&& squareOccupied) because first condition would satisfy: test
        if ((targetPiece.getColorInt() == occupyingPiece.getColorInt()) && squareOccupied) {
            System.out.println("Cannot move to square occupied by allied piece");
            return false;
        }

        //If move is possible and square has enemy piece then move piece to des square and account for kill
        if (targetPiece.canMove(board, desX, desY) && squareOccupied)  {
            //TODO account for enemy killed here: remove piece from des square and place on list of player's dead pieces
            //Add killed piece to list of removed pieces
            removedPieces.add(occupyingPiece);
            //Remove piece from board
            board[desX][desY].removePiece();
            //Update its coords
            occupyingPiece.setCoords(10, 10);

            //Remove target piece from original square
            board[srcX][srcY].removePiece();
            //Move target piece to dest square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            changeTurn();
            return true;
        }
        //If move is possible and no enemy piece on destination square
        else if (targetPiece.canMove(board, desX, desY) && !squareOccupied) {
            //Move piece to destination square
            board[desX][desY].addPiece(targetPiece);
            //Updated piece coords
            targetPiece.setCoords(desX, desY);
            //Remove piece from previous square
            board[srcX][srcY].removePiece();
            changeTurn();
            return true;
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
        //TODO check if initalized board correctly
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
        /*pieces[0] = new Rook(color);
        pieces[1] = new Knight(color);
        pieces[2] = new Bishop(color);
        pieces [3] = new Queen(color);
        pieces[4] = new King(color);
        pieces[5] = new Bishop(color);
        pieces[6] = new Knight(color);
        pieces[7] = new Rook(color);*/

        //TODO test to make sure combined for loop works
        for (int i = 0; i < 16; i++) {
            if (i == 0 || i == 7) {
                pieces[i] = new Rook(color);
            }
            else if (i == 1 || i == 6) {
                pieces[i] = new Knight(color);
            }
            else if (i == 2 || i == 5) {
                pieces[i] = new Bishop(color);
            }
            else if (i == 3) {
                pieces[i] = new Queen(color);
            }
            else if (i == 4) {
                pieces[i] = new King(color);
            }
            else {
                pieces[i] = new Pawn(color);
            }
        }

        //For loop to add pawns
        for (int i = 8; i < 16; i++) {
            pieces[i] = new Pawn(color);
        }

        return pieces;
    }

    public int[] convert(String src, String des) {
        //Ex: src's char(1st) == coords[1] && src's int(2nd) == coords[0]
        int[] coords = new int[4];

        //Find what first digit/y is
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        int j = 0;
        for (char i : letters) {
            if (src.charAt(0) == i) {
                coords[1] = j;
            }
            if (des.charAt(0) == i) {
                coords[3] = j;
            }
            j++;
        }

        //Find what int/x is
        int[] ints = {99, 7, 6, 5, 4, 3, 2, 1, 0};
        char srcIntChar = src.charAt(1);
        int srcInt = Character.getNumericValue(srcIntChar);
        char desIntChar = des.charAt(1);
        int desInt = Character.getNumericValue(desIntChar);

        coords[0] = ints[srcInt];
        coords[2] = ints[desInt];
        /*for (int i : ints) {
            if (srcInt == i) {
                coords[0] = i;
            }
            if (desInt == i) {
                coords[2] = i;
            }
        }*/
        return coords;
    }

    public void printBoard() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        System.out.print("    a");
        for (int k = 1; k < 8; k++) {
            System.out.print("   " + letters[k]);
        }
        System.out.println();

        System.out.print("   __");
        for (int i = 0; i < 15; i++) {
            System.out.print("__");
        }
        System.out.println();

        for (int i = 0, k = 8; i < 8; i++) {
            System.out.print(k + " |");
            k--;
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j].getPiece();
                if (p == null) {
                    System.out.print("    ");
                    continue;
                }
                System.out.print(" ");
                p.printOnBoard();
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print("   __");
        for (int i = 0; i < 15; i++) {
            System.out.print("__");
        }
        System.out.println();
    }

    public void changeTurn() {
        //Change player turn
        if (white.isTurn()) {
            white.turn = false;
            black.turn = true;
        }
        else {
            black.turn = false;
            white.turn = true;
        }
    }
}

