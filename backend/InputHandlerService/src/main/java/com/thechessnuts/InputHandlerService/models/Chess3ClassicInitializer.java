package com.thechessnuts.InputHandlerService.models;

public class Chess3ClassicInitializer extends AbstractChess3Initializer{

    Chess3ClassicInitializer(Chess3Board board) {
        super(board);
    }

    @Override
    public void initialize(Chess3Settings settings){

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
            PawnFactory pawnFactory = new PawnFactory(board, player);

            for(int i = 0; i<4;i++){
                pawnFactory.createPiece(board.sections[queenSide].squares[i][2].label);
                pawnFactory.createPiece(board.sections[kingSide].squares[2][i].label);
            }

            //ROOKS
            RookFactory rookFactory = new RookFactory(board, player);

            rookFactory.createPiece(board.sections[queenSide].squares[3][3].label);
            rookFactory.createPiece(board.sections[kingSide].squares[3][3].label);

            //KNIGHTS
            KnightFactory knightFactory = new KnightFactory(board, player);

            knightFactory.createPiece(board.sections[queenSide].squares[2][3].label);
            knightFactory.createPiece(board.sections[kingSide].squares[3][2].label);

            //BISHOPS
            BishopFactory bishopFactory = new BishopFactory(board, player);

            bishopFactory.createPiece(board.sections[queenSide].squares[1][3].label);
            bishopFactory.createPiece(board.sections[kingSide].squares[3][1].label);

            //QUEEN
            QueenFactory queenFactory = new QueenFactory(board, player);
            queenFactory.createPiece(board.sections[queenSide].squares[0][3].label);

            //KING
            KingFactory kingFactory = new KingFactory(board, player);
            kingFactory.createPiece(board.sections[kingSide].squares[3][0].label);
        }
    }
}





