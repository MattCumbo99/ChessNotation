package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.chesspiece.ChessPiece;
import main.piece.PieceColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MoveUtils {
    private MoveUtils() {}

    public static List<Position> getLegalOffsetPositions(PieceColor color, Position origin, Board board, int[][] offsets) {
        List<Position> moves = new ArrayList<>();

        for (int[] offset : offsets) {
            origin.offset(offset[0], offset[1]).ifPresent(target -> {
                ChessPiece otherPiece = board.getPieceAt(target);
                if (otherPiece == null || otherPiece.getPieceColor() != color) {
                    moves.add(target);
                }
            });
        }

        return moves;
    }

    public static List<Position> getLegalRayPositions(
            PieceColor color,
            Position origin,
            Board board,
            int[][] directions
    ) {
        List<Position> legalPositions = new ArrayList<>();

        for (int[] dir : directions) {
            int dx = dir[0];
            int dy = dir[1];

            Optional<Position> currentPos = origin.offset(dx, dy);

            while (currentPos.isPresent()) {
                Position current = currentPos.get();
                ChessPiece targetPiece = board.getPieceAt(current);

                if (targetPiece == null) {
                    legalPositions.add(current);
                    currentPos = origin.offset(dx, dy);
                } else {
                    if (targetPiece.getPieceColor() != color) {
                        legalPositions.add(current);
                    }
                    break;
                }
            }
        }

        return legalPositions;
    }
}
