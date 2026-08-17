package main.piece.strategy;

import main.board.Board;
import main.board.Position;

import java.util.List;

/**
 * Interface for instructions on how a Chess piece should move on the board.
 */
public interface MoveStrategy {
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
    List<Position> getValidMoves(Position origin, Board board);
}
