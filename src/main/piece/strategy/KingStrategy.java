package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.chesspiece.ChessPiece;
import main.piece.PieceColor;

import java.util.List;

import static main.piece.PieceType.KING;

public class KingStrategy implements MoveStrategy {

    private final PieceColor pieceColor;

    public KingStrategy(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        ChessPiece piece = board.getPieceAt(origin);

        if (piece == null || piece.getPieceType() != KING || piece.getPieceColor() != pieceColor) {
            return List.of();
        }

        int[][] offsets = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        return MoveUtils.getLegalOffsetPositions(pieceColor, origin, board, offsets);
    }
}
