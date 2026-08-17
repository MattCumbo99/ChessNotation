package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;

import java.util.List;

public class QueenStrategy implements MoveStrategy {
    private static final int[][] QUEEN_DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    private final RayStrategy rayStrategy;

    public QueenStrategy(PieceColor color) {
        this.rayStrategy = new RayStrategy(color, QUEEN_DIRECTIONS);
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        return rayStrategy.getValidMoves(origin, board);
    }
}
