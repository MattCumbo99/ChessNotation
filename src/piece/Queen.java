package piece;

public class Queen implements ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType = PieceType.QUEEN;

    private boolean hasMoved;

    public Queen(PieceColor color) {
        pieceColor = color;
        hasMoved = false;
    }

    public Queen(PieceColor color, boolean hasMoved) {
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
        return "Q";
    }

    @Override
    public char getIcon() {
        if (pieceColor == PieceColor.BLACK) {
            return '♛';
        }

        return '♕';
    }
}
