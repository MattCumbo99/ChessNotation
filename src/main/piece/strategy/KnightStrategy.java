package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.chesspiece.ChessPiece;
import main.piece.PieceColor;

import java.util.List;

import static main.piece.PieceType.KNIGHT;

public class KnightStrategy implements MoveStrategy {

    private final PieceColor pieceColor;

    public KnightStrategy(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        ChessPiece piece = board.getPieceAt(origin);

        if (piece == null || piece.getPieceType() != KNIGHT || piece.getPieceColor() != pieceColor) {
            return List.of();
        }

        int[][] offsets = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        return MoveUtils.getLegalOffsetPositions(pieceColor, origin, board, offsets);
    }
}
