package main.piece.chesspiece;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;
import main.piece.PieceType;
import main.piece.strategy.MoveStrategy;

import java.util.List;

public class ChessPiece {

    private final PieceColor pieceColor;
    private final PieceType pieceType;
    private final int pieceValue;
    private final MoveStrategy moveStrategy;

    private boolean hasMoved = false;

    protected ChessPiece(PieceColor pieceColor, PieceType pieceType, int pieceValue,  MoveStrategy moveStrategy) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.pieceValue = pieceValue;
        this.moveStrategy = moveStrategy;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Gets this piece represented as a displayable icon.
     *
     * @return Piece icon.
     */
    public char getIcon() {
        return pieceType.getIcon(pieceColor);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setMoved() {
        this.hasMoved = true;
    }

    /**
     * Gets a shallow list of possible destinations this piece can move to on the given board at the
     * specified position. A move is considered valid if the correct piece is at the origin and the
     * move target contains either an enemy piece or no piece.
     * <p/>
     * An empty list signifies no legal moves.
     *
     * @param origin Position of this piece.
     * @param board Board to reference.
     * @return List of pseudo moves.
     */
    public List<Position> getPseudoLegalMoves(Position origin, Board board) {
        return moveStrategy.getValidMoves(origin, board);
    }
}
