package main.piece;

public interface ChessPiece {
    PieceColor getColor();

    PieceType getPieceType();

    boolean hasMoved();

    void setHasMoved(boolean hasMoved);

    String getNotationSymbol();

    /**
     * Gets the icon associated with this piece.
     *
     * @return Unicode character.
     */
    char getIcon();

    /**
     * Gets the material value of this piece. Kings are worth 0.
     *
     * @return Material value.
     */
    int getPieceValue();
}
