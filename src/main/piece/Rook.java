package main.piece;

public class Rook implements ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType = PieceType.ROOK;

    private boolean hasMoved;

    public Rook(PieceColor color) {
        pieceColor = color;
        hasMoved = false;
    }

    public Rook(PieceColor color, boolean hasMoved) {
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
        return "R";
    }

    @Override
    public char getIcon() {
        if (pieceColor == PieceColor.BLACK) {
            return '♜';
        }

        return '♖';
    }

    @Override
    public int getPieceValue() {
        return 5;
    }
}
