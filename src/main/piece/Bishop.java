package main.piece;

public class Bishop implements ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType = PieceType.BISHOP;

    private boolean hasMoved;

    public Bishop(PieceColor color) {
        pieceColor = color;
        hasMoved = false;
    }

    public Bishop(PieceColor color, boolean hasMoved) {
        pieceColor = color;
        this.hasMoved = hasMoved;
    }

    @Override
    public PieceColor getColor() {
        return pieceColor;
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public boolean hasMoved() {
        return hasMoved;
    }

    @Override
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    @Override
    public String getNotationSymbol() {
        return "B";
    }

    @Override
    public char getIcon() {
        if (pieceColor == PieceColor.BLACK) {
            return '♝';
        }

        return '♗';
    }

    @Override
    public int getPieceValue() {
        return 3;
    }
}
