package main.piece.strategy;

import main.board.Board;
import main.board.Position;

import java.util.List;

public interface MoveStrategy {
    List<Position> getValidMoves(Position origin, Board board);
}
