package piece;

public class Pawn implements ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType = PieceType.PAWN;

    private boolean hasMoved;

    Pawn(PieceColor color) {
        pieceColor = color;
        hasMoved = false;
    }

    Pawn(PieceColor color, boolean hasMoved) {
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
        return "";
    }

    @Override
    public char getIcon() {
        if (pieceColor == PieceColor.BLACK) {
            return '♟';
        }

        return '♙';
    }
}
