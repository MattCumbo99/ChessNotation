package main.game;

import main.board.Position;
import main.piece.PieceType;

/**
 * A record holding specific information about a move requested from notation.
 *
 * @param moveType The type of move.
 * @param pieceType Piece to move.
 * @param destination Desired location of piece.
 * @param fileHint Optional file specification of piece.
 * @param rankHint Optional rank specification of piece.
 * @param isCapture If this move is indicating a capture.
 * @param promotion Desired promotion piece, if the move is indicating promotion.
 */
public record ParsedMove(
        MoveType moveType,
        PieceType pieceType,
        Position destination,
        Character fileHint,
        Integer rankHint,
        boolean isCapture,
        PieceType promotion
) {
    public ParsedMove {
        if (pieceType != PieceType.PAWN && promotion != null) {
            throw new IllegalArgumentException("Promotions only apply to pawns (was " + pieceType + ").");
        }

        boolean isInvalidFileHint = fileHint != null && (fileHint < 'a' || fileHint > 'h');
        if (isInvalidFileHint) {
            throw new IllegalArgumentException("File hints must be between 'a' and 'h' (was " +  fileHint + ").");
        }

        boolean isInvalidRankHint = rankHint != null && (rankHint < 1 || rankHint > 8);
        if (isInvalidRankHint) {
            throw new IllegalArgumentException("Rank hints must be between 1 and 8 (was " +  rankHint + ").");
        }

        if (pieceType != PieceType.KING && (moveType == MoveType.KINGSIDE_CASTLE || moveType == MoveType.QUEENSIDE_CASTLE)) {
            throw new IllegalArgumentException("Castling is only allowed for King pieces (was " + pieceType + ").");
        }
    }

    /**
     * Constructs a new ParsedMove from the given chess notation.
     *
     * @param notation Move notation.
     * @return ParsedMove data from the notation.
     * @throws InvalidNotationException If the notation is not valid.
     */
    public static ParsedMove parse(String notation) throws InvalidNotationException {
        if (!isValidFormat(notation)) {
            throw new InvalidNotationException("Invalid notation: " + notation);
        }

        if (notation.equals("O-O")) {
            return ParsedMove.castle(true);
        } else if (notation.equals("O-O-O")) {
            return ParsedMove.castle(false);
        }

        // Step 1: Get main.piece type
        char first = notation.charAt(0);

        PieceType pieceType = PieceType.fromChar(first);

        String cleaned = notation.replaceFirst("[#+]", "");
        String noPromo = cleaned.replaceFirst("=[NBQR]", "");

        String lastPos = noPromo.substring(noPromo.length() - 2);
        Position destination = new Position(lastPos.charAt(0), lastPos.charAt(1) - '0');

        boolean isCapture = cleaned.contains("x");

        PieceType promotion = null;
        // Promotion
        if (cleaned.contains("=")) {
            char promoPieceId = cleaned.charAt(cleaned.length() - 1);

            promotion = PieceType.fromChar(promoPieceId);
        }

        return new ParsedMove(
                MoveType.NORMAL, pieceType, destination, null, null, isCapture, promotion
        );
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

    /**
     * Pre-defined ParsedMove identifying a castling move.
     *
     * @param isKingside If the notation is O-O to castle kingside.
     * @return ParsedMove with castling data.
     */
    public static ParsedMove castle(boolean isKingside) {
        return new ParsedMove(
                isKingside ? MoveType.KINGSIDE_CASTLE : MoveType.QUEENSIDE_CASTLE,
                PieceType.KING,
                null, null, null, false, null
        );
    }
}
