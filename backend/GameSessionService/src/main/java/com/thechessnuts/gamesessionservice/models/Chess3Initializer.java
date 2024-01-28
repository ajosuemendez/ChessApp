package com.thechessnuts.gamesessionservice.models;

class Chess3Initializer{

    Chess3Board board;

    Chess3Initializer(Chess3Board board) {
        this.board = board;
        
    }

    static void initialize(Chess3Board board, Chess3Settings settings){

        for(int playerNumber = 1; playerNumber <4; playerNumber++){

            Player player;

            switch (playerNumber) {
                case 1:
                    player = settings.playerBlack;
                    break;

                case 2:
                    player = settings.playerWhite;
                    break;
            
                case 3:
                    player = settings.playerYellow;
                    break;
            
                default:
                    player = settings.playerWhite;
                    break;
            }
            

            int queenSide = 2*(playerNumber-1);                                   /*Queen's Side*/
            int kingSide = queenSide+1;                                          /*King's  Side*/
            
            //PAWNS
            PieceFactory pawnFactory = new PieceFactory(player, new Pawn3Behaviour());

            for(int i = 0; i<4;i++){
                pawnFactory.createPiece(board, board.sections[queenSide].squares[i][2].label);
                pawnFactory.createPiece(board, board.sections[kingSide].squares[2][i].label);
            }

            //ROOKS
            PieceFactory rookFactory = new PieceFactory(player, new RookBehaviour());

            rookFactory.createPiece(board, board.sections[queenSide].squares[3][3].label);
            rookFactory.createPiece(board, board.sections[kingSide].squares[3][3].label);

            //KNIGHTS
            PieceFactory knightFactory = new PieceFactory(player, new KnightBehaviour());

            knightFactory.createPiece(board, board.sections[queenSide].squares[2][3].label);
            knightFactory.createPiece(board, board.sections[kingSide].squares[3][2].label);

            //BISHOPS
            PieceFactory bishopFactory = new PieceFactory(player, new BishopBehaviour());

            bishopFactory.createPiece(board, board.sections[queenSide].squares[1][3].label);
            bishopFactory.createPiece(board, board.sections[kingSide].squares[3][1].label);

            //QUEEN
            PieceFactory queenFactory = new PieceFactory(player, new QueenBehaviour());
            queenFactory.createPiece(board, board.sections[queenSide].squares[0][3].label);

            //KING
            PieceFactory kingFactory = new PieceFactory(player, new KingBehaviour());
            kingFactory.createPiece(board, board.sections[kingSide].squares[3][0].label);
        }
    }
}





