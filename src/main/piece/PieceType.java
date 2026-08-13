package main.piece;

import static main.piece.PieceColor.WHITE;

public enum PieceType {
    PAWN('♙', '♟'),
    BISHOP('♗', '♝'),
    KNIGHT('♘', '♞'),
    ROOK('♖', '♜'),
    QUEEN('♕', '♛'),
    KING('♔', '♚');

    private final char whiteIcon;
    private final char blackIcon;

    PieceType(char whiteIcon, char blackIcon) {
        this.whiteIcon = whiteIcon;
        this.blackIcon = blackIcon;
    }

    /**
     * Gets the displayable icon of this piece type.
     *
     * @param color Color of icon.
     * @return Character icon.
     */
    public char getIcon(PieceColor color) {
        if (color == WHITE) return whiteIcon;

        return blackIcon;
    }

    /**
     * Retrieves a PieceType associated with a character ID. For example, "a" through "h"
     * is a PAWN, or "N" is a KNIGHT. An invalid pieceId returns null.
     *
     * @param pieceId PieceType ID.
     * @return PieceType association.
     */
    public static PieceType fromChar(char pieceId) {
        if (pieceId >= 'a' && pieceId <= 'h') {
            return PAWN;
        }

        return switch (pieceId) {
            case 'N' -> KNIGHT;
            case 'B' -> BISHOP;
            case 'R' -> ROOK;
            case 'Q' -> QUEEN;
            case 'K' -> KING;
            default -> null;
        };
    }
}
