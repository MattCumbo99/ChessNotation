package main.piece;

import main.board.Board;
import main.board.Position;

import java.util.List;

@FunctionalInterface
public interface MoveStrategy {
    List<Position> calculate(Position origin, Board board);
}
