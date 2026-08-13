package test;

import main.board.Position;
import main.game.MoveType;
import main.game.ParsedMove;
import main.piece.PieceType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParsedMoveTest {
    @Test
    void notationProducesParsedMoves() {
        ParsedMove expected1 = ParsedMove.castle(false);
        ParsedMove expected2 = ParsedMove.castle(true);
        ParsedMove expected3 =
                new ParsedMove(
                        MoveType.NORMAL,
                        PieceType.PAWN,
                        new Position('e', 4),
                        null, null,
                        false,
                        null
                );

        ParsedMove expected4 =
                new ParsedMove(
                        MoveType.NORMAL,
                        PieceType.ROOK,
                        new Position('a', 6),
                        null, null,
                        true,
                        null
                );

        ParsedMove expected5 =
                new ParsedMove(
                        MoveType.NORMAL,
                        PieceType.PAWN,
                        new Position('c', 1),
                        null, null,
                        true,
                        PieceType.QUEEN
                );

        ParsedMove actual1 = ParsedMove.parse("O-O-O");
        ParsedMove actual2 = ParsedMove.parse("O-O");
        ParsedMove actual3 = ParsedMove.parse("e4");
        ParsedMove actual4 = ParsedMove.parse("Rxa6");
        ParsedMove actual5 = ParsedMove.parse("dxc1=Q");

        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
        assertEquals(actual5, expected5);
    }

}
