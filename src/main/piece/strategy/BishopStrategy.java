package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;

import java.util.List;

public class BishopStrategy implements MoveStrategy {
    private static final int[][] BISHOP_DIRECTIONS = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private final RayStrategy rayStrategy;

    public BishopStrategy(PieceColor color) {
        this.rayStrategy = new RayStrategy(color, BISHOP_DIRECTIONS);
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        return rayStrategy.getValidMoves(origin, board);
    }
}
