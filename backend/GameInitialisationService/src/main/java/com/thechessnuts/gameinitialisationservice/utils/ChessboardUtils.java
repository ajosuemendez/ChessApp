package com.thechessnuts.gameinitialisationservice.utils;

import com.thechessnuts.gameinitialisationservice.models.SquareForSending;

import java.util.ArrayList;
import java.util.List;

public class ChessboardUtils {

    public static List<SquareForSending> getDefaultChessboardState() {
        List<SquareForSending> defaultBoardState = new ArrayList<>();

        // Left Quadrant White
        defaultBoardState.add(new SquareForSending("h12", "white-rook", false, false));
        defaultBoardState.add(new SquareForSending("h11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("h10", "", false, false));
        defaultBoardState.add(new SquareForSending("h9", "", false, false));

        defaultBoardState.add(new SquareForSending("g12", "white-knight", false, false));
        defaultBoardState.add(new SquareForSending("g11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("g10", "", false, false));
        defaultBoardState.add(new SquareForSending("g9", "", false, false));

        defaultBoardState.add(new SquareForSending("f12", "white-bishop", false, false));
        defaultBoardState.add(new SquareForSending("f11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("f10", "", false, false));
        defaultBoardState.add(new SquareForSending("f9", "", false, false));

        defaultBoardState.add(new SquareForSending("e12", "white-queen", false, false));
        defaultBoardState.add(new SquareForSending("e11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("e10", "", false, false));
        defaultBoardState.add(new SquareForSending("e9", "", false, false));

        // Right Quadrant White
        defaultBoardState.add(new SquareForSending("i12", "white-king", false, false));
        defaultBoardState.add(new SquareForSending("i11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("i10", "", false, false));
        defaultBoardState.add(new SquareForSending("i9", "", false, false));

        defaultBoardState.add(new SquareForSending("j12", "white-bishop", false, false));
        defaultBoardState.add(new SquareForSending("j11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("j10", "", false, false));
        defaultBoardState.add(new SquareForSending("j9", "", false, false));

        defaultBoardState.add(new SquareForSending("k12", "white-knight", false, false));
        defaultBoardState.add(new SquareForSending("k11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("k10", "", false, false));
        defaultBoardState.add(new SquareForSending("k9", "", false, false));

        defaultBoardState.add(new SquareForSending("l12", "white-rook", false, false));
        defaultBoardState.add(new SquareForSending("l11", "white-pawn", false, false));
        defaultBoardState.add(new SquareForSending("l10", "", false, false));
        defaultBoardState.add(new SquareForSending("l9", "", false, false));

        // Left Quadrant Yellow
        defaultBoardState.add(new SquareForSending("l8", "yellow-rook", false, false));
        defaultBoardState.add(new SquareForSending("l7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("l6", "", false, false));
        defaultBoardState.add(new SquareForSending("l5", "", false, false));

        defaultBoardState.add(new SquareForSending("k8", "yellow-knight", false, false));
        defaultBoardState.add(new SquareForSending("k7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("k6", "", false, false));
        defaultBoardState.add(new SquareForSending("k5", "", false, false));

        defaultBoardState.add(new SquareForSending("j8", "yellow-bishop", false, false));
        defaultBoardState.add(new SquareForSending("j7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("j6", "", false, false));
        defaultBoardState.add(new SquareForSending("j5", "", false, false));

        defaultBoardState.add(new SquareForSending("i8", "yellow-queen", false, false));
        defaultBoardState.add(new SquareForSending("i7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("i6", "", false, false));
        defaultBoardState.add(new SquareForSending("i5", "", false, false));

        // Right Quadrant Yellow
        defaultBoardState.add(new SquareForSending("d8", "yellow-king", false, false));
        defaultBoardState.add(new SquareForSending("d7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("d6", "", false, false));
        defaultBoardState.add(new SquareForSending("d5", "", false, false));

        defaultBoardState.add(new SquareForSending("c8", "yellow-bishop", false, false));
        defaultBoardState.add(new SquareForSending("c7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("c6", "", false, false));
        defaultBoardState.add(new SquareForSending("c5", "", false, false));

        defaultBoardState.add(new SquareForSending("b8", "yellow-knight", false, false));
        defaultBoardState.add(new SquareForSending("b7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("b6", "", false, false));
        defaultBoardState.add(new SquareForSending("b5", "", false, false));

        defaultBoardState.add(new SquareForSending("a8", "yellow-rook", false, false));
        defaultBoardState.add(new SquareForSending("a7", "yellow-pawn", false, false));
        defaultBoardState.add(new SquareForSending("a6", "", false, false));
        defaultBoardState.add(new SquareForSending("a5", "", false, false));

        // Left Quadrant Red
        defaultBoardState.add(new SquareForSending("a4", "", false, false));
        defaultBoardState.add(new SquareForSending("a3", "", false, false));
        defaultBoardState.add(new SquareForSending("a2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("a1", "black-rook", false, false));

        defaultBoardState.add(new SquareForSending("b4", "", false, false));
        defaultBoardState.add(new SquareForSending("b3", "", false, false));
        defaultBoardState.add(new SquareForSending("b2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("b1", "black-knight", false, false));

        defaultBoardState.add(new SquareForSending("c4", "", false, false));
        defaultBoardState.add(new SquareForSending("c3", "", false, false));
        defaultBoardState.add(new SquareForSending("c2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("c1", "black-bishop", false, false));

        defaultBoardState.add(new SquareForSending("d4", "", false, false));
        defaultBoardState.add(new SquareForSending("d3", "", false, false));
        defaultBoardState.add(new SquareForSending("d2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("d1", "black-queen", false, false));

        // Right Quadrant Red
        defaultBoardState.add(new SquareForSending("e4", "", false, false));
        defaultBoardState.add(new SquareForSending("e3", "", false, false));
        defaultBoardState.add(new SquareForSending("e2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("e1", "black-king", false, false));

        defaultBoardState.add(new SquareForSending("f4", "", false, false));
        defaultBoardState.add(new SquareForSending("f3", "", false, false));
        defaultBoardState.add(new SquareForSending("f2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("f1", "black-bishop", false, false));

        defaultBoardState.add(new SquareForSending("g4", "", false, false));
        defaultBoardState.add(new SquareForSending("g3", "", false, false));
        defaultBoardState.add(new SquareForSending("g2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("g1", "black-knight", false, false));

        defaultBoardState.add(new SquareForSending("h4", "", false, false));
        defaultBoardState.add(new SquareForSending("h3", "", false, false));
        defaultBoardState.add(new SquareForSending("h2", "black-pawn", false, false));
        defaultBoardState.add(new SquareForSending("h1", "black-rook", false, false));

        return defaultBoardState;
    }
}
