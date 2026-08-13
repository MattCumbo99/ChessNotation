package main.game;

import main.board.Board;

public class ChessGame {
    private final Board board;

    public ChessGame() {
        board = new Board();
        board.initialize();
    }

    public Board getBoard() {
        return board;
    }
}
