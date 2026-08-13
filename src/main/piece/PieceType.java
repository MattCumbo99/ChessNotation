package main.piece;

public enum PieceType {
    PAWN, BISHOP, KNIGHT, ROOK, QUEEN, KING;

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
