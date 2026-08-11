package game;

import board.Board;
import piece.PieceColor;

public class NotationParser {
    private NotationParser() {}

    public static void process(String input, Board board, PieceColor player) throws InvalidNotationException {
        if (!isValidFormat(input)) {
            throw new InvalidNotationException("Notation is not valid: " + input);
        }

        // TODO
    }

    /**
     * Checks if the input is valid chess notation. Does not validate if the notation
     * is correct.
     *
     * @param input Chess notation entry.
     * @return true if the input is valid chess notation.
     */
    private static boolean isValidFormat(String input) {
        return input.matches("^(O-O(-O)?|0-0(-0)?|([NBKRQ]?[a-h]?[1-8]?x?[a-h][1-8](=[NBQR])?))[+#]?$");
    }
}
