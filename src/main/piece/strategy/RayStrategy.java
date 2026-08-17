package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;

import java.util.List;

public class RayStrategy implements MoveStrategy {
    private final int[][] directions;
    private final PieceColor color;

    public RayStrategy(PieceColor color, int[][] directions) {
        this.color = color;
        this.directions = directions;
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        return MoveUtils.getLegalRayPositions(color, origin, board, directions);
    }
}
