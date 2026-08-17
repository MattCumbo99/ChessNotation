package main.piece.chesspiece;

import main.piece.PieceColor;
import main.piece.strategy.*;

import java.util.List;

import static main.piece.PieceType.*;
import static main.piece.PieceType.BISHOP;
import static main.piece.PieceType.KNIGHT;
import static main.piece.PieceType.PAWN;

public class ChessPieceFactory {
    private ChessPieceFactory() {}

    public static ChessPiece king(PieceColor color) {
        return new ChessPiece(color, KING, 0, new KingStrategy(color));
    }

    public static ChessPiece queen(PieceColor color) {
        return new ChessPiece(color, QUEEN, 9, new QueenStrategy(color));
    }

    public static ChessPiece rook(PieceColor color) {
        return new ChessPiece(color, ROOK, 5, new RookStrategy(color));
    }

    public static ChessPiece bishop(PieceColor color) {
        return new ChessPiece(color, BISHOP, 3, new BishopStrategy(color));
    }

    public static ChessPiece knight(PieceColor color) {
        return new ChessPiece(color, KNIGHT, 3, new KnightStrategy(color));
    }

    public static ChessPiece pawn(PieceColor color) {
        MoveStrategy pawnStrategy = (origin, board) -> {
            // TODO
            return List.of();
        };

        return new ChessPiece(color, PAWN, 1, pawnStrategy);
    }
}
