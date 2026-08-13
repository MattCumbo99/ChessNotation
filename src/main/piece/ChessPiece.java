package main.piece;

import static main.piece.PieceColor.WHITE;
import static main.piece.PieceType.*;

public class ChessPiece {

    private final PieceColor color;
    private final PieceType type;

    private final int pieceValue;

    private boolean hasMoved = false;

    private ChessPiece(PieceColor color, PieceType type, int pieceValue) {
        this.type = type;
        this.color = color;
        this.pieceValue = pieceValue;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public PieceColor getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return type;
    }

    /**
     * Gets this piece represented as a displayable icon.
     *
     * @return Piece icon.
     */
    public char getIcon() {
        if (color == WHITE) {
            return switch (type) {
                case KING -> '♔';
                case QUEEN -> '♕';
                case ROOK -> '♖';
                case BISHOP -> '♗';
                case KNIGHT -> '♘';
                case PAWN -> '♙';
            };
        } else {
            return switch (type) {
                case KING -> '♚';
                case QUEEN -> '♛';
                case ROOK -> '♜';
                case BISHOP -> '♝';
                case KNIGHT -> '♞';
                case PAWN -> '♟';
            };
        }
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }

    public static ChessPiece king(PieceColor color) {
        return new ChessPiece(color, KING, 0);
    }

    public static ChessPiece queen(PieceColor color) {
        return new ChessPiece(color, QUEEN, 9);
    }

    public static ChessPiece rook(PieceColor color) {
        return new ChessPiece(color, ROOK, 5);
    }

    public static ChessPiece bishop(PieceColor color) {
        return new ChessPiece(color, BISHOP, 3);
    }

    public static ChessPiece knight(PieceColor color) {
        return new ChessPiece(color, KNIGHT, 3);
    }

    public static ChessPiece pawn(PieceColor color) {
        return new ChessPiece(color, PAWN, 1);
    }
}
