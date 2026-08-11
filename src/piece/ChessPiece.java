package piece;

public interface ChessPiece {
    PieceColor getColor();

    PieceType getPieceType();

    boolean hasMoved();

    void setHasMoved(boolean hasMoved);

    String getNotationSymbol();

    char getIcon();
}
