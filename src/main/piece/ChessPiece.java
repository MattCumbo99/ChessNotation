package main.piece;

import main.board.Board;
import main.board.Position;

import java.util.ArrayList;
import java.util.List;

import static main.piece.PieceType.*;

public class ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType;
    private final int pieceValue;
    private final MoveStrategy moveStrategy;

    private boolean hasMoved = false;

    private ChessPiece(PieceColor pieceColor, PieceType pieceType, int pieceValue,  MoveStrategy moveStrategy) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.pieceValue = pieceValue;
        this.moveStrategy = moveStrategy;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Gets this piece represented as a displayable icon.
     *
     * @return Piece icon.
     */
    public char getIcon() {
        return pieceType.getIcon(pieceColor);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }

    /**
     * Gets a shallow list of possible destinations this piece can move to on the given board at the
     * specified position. A move is considered valid if the correct piece is at the origin and the
     * move target contains either an enemy piece or no piece.
     * <p/>
     * An empty list signifies no legal moves.
     *
     * @param origin Position of this piece.
     * @param board Board to reference.
     * @return List of pseudo moves.
     */
    public List<Position> getPseudoLegalMoves(Position origin, Board board) {
        return moveStrategy.calculate(origin, board);
    }

    public static ChessPiece king(PieceColor color) {
        MoveStrategy kingStrategy = (origin, board) -> {
            ChessPiece piece = board.getPieceAt(origin);
            if (piece == null || piece.getPieceType() != KING || piece.getPieceColor() != color) {
                return List.of();
            }

            int[][] offsets = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    { 0, -1},          { 0, 1},
                    { 1, -1}, { 1, 0}, { 1, 1}
            };

            return getLegalOffsetPositions(color, origin, board, offsets);
        };

        return new ChessPiece(color, KING, 0, kingStrategy);
    }

    public static ChessPiece queen(PieceColor color) {
        MoveStrategy queenStrategy = (origin, board) -> {
            // TODO
            return List.of();
        };

        return new ChessPiece(color, QUEEN, 9, queenStrategy);
    }

    public static ChessPiece rook(PieceColor color) {
        MoveStrategy rookStrategy = (origin, board) -> {
            // TODO
            return List.of();
        };

        return new ChessPiece(color, ROOK, 5, rookStrategy);
    }

    public static ChessPiece bishop(PieceColor color) {
        MoveStrategy bishopStrategy = (origin, board) -> {
            // TODO
            return List.of();
        };

        return new ChessPiece(color, BISHOP, 3, bishopStrategy);
    }

    public static ChessPiece knight(PieceColor color) {
        MoveStrategy knightStrategy = (origin, board) -> {
            ChessPiece piece = board.getPieceAt(origin);
            if (piece == null || piece.getPieceType() != KNIGHT || piece.getPieceColor() != color) {
                return List.of();
            }

            int[][] offsets = {
                    {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                    {1, -2}, {1, 2}, {2, -1}, {2, 1}
            };

            return getLegalOffsetPositions(color, origin, board, offsets);
        };

        return new ChessPiece(color, KNIGHT, 3, knightStrategy);
    }

    public static ChessPiece pawn(PieceColor color) {
        MoveStrategy pawnStrategy = (origin, board) -> {
            // TODO
            return List.of();
        };

        return new ChessPiece(color, PAWN, 1, pawnStrategy);
    }

    private static List<Position> getLegalOffsetPositions(PieceColor color, Position origin, Board board, int[][] offsets) {
        List<Position> moves = new ArrayList<>();

        for (int[] offset : offsets) {
            origin.add(offset[0], offset[1]).ifPresent(target -> {
                ChessPiece otherPiece = board.getPieceAt(target);
                if (otherPiece == null || otherPiece.getPieceColor() != color) {
                    moves.add(target);
                }
            });
        }

        return moves;
    }
}
