package main.piece.strategy;

import main.board.Board;
import main.board.Position;
import main.piece.PieceColor;

import java.util.List;

public class RookStrategy implements MoveStrategy {
    private static final int[][] ROOK_DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private final RayStrategy rayStrategy;

    public RookStrategy(PieceColor color) {
        this.rayStrategy = new RayStrategy(color, ROOK_DIRECTIONS);
    }

    @Override
    public List<Position> getValidMoves(Position origin, Board board) {
        return rayStrategy.getValidMoves(origin, board);
    }
}
