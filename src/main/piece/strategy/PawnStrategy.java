package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;
import main.piece.chesspiece.ChessPiece;

import static main.piece.PieceColor.WHITE;
import static main.piece.PieceType.PAWN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PawnStrategy implements MoveStrategy {
    private final PieceColor color;

    public PawnStrategy(PieceColor color) {
        this.color = color;
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        ChessPiece piece = board.getPieceAt(origin);
        if (piece == null || piece.getPieceType() != PAWN) {
            return List.of();
        }

        List<Position> validMoves = new ArrayList<>();

        int direction = (color == WHITE) ? 1 : -1;

        Optional<Position> forwardOneOptional = origin.offset(0, direction);

        if (forwardOneOptional.isPresent()) {
            Position forwardOne = forwardOneOptional.get();

            if (board.getPieceAt(forwardOne) == null) {
                validMoves.add(forwardOne);

                if (!piece.hasMoved()) {
                    Optional<Position> forwardTwoOptional = origin.offset(0, 2 * direction);

                    if (forwardTwoOptional.isPresent()) {
                        Position forwardTwo = forwardTwoOptional.get();

                        if (board.getPieceAt(forwardTwo) == null) {
                            validMoves.add(forwardTwo);
                        }
                    }
                }
            }
        }

        int[] captureFiles = {-1, 1};

        for (int fileOffset : captureFiles) {
            origin.offset(fileOffset, direction).ifPresent(diagonal -> {
                ChessPiece targetPiece = board.getPieceAt(diagonal);

                if (targetPiece != null && targetPiece.getPieceColor() != color) {
                    validMoves.add(diagonal);
                }
            });
        }

        return validMoves;
    }
}
