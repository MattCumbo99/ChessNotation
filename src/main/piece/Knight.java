package main.piece;

public class Knight implements ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType = PieceType.KNIGHT;

    private boolean hasMoved;

    public Knight(PieceColor color) {
        pieceColor = color;
        hasMoved = false;
    }

    public Knight(PieceColor color, boolean hasMoved) {
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
        return "N";
    }

    @Override
    public char getIcon() {
        if (pieceColor == PieceColor.BLACK) {
            return '♞';
        }

        return '♘';
    }
}
