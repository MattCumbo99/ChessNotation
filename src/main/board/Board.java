package main.board;

import main.piece.*;

public class Board {
    private final ChessPiece[][] grid = new ChessPiece[8][8];

    /**
     * Retrieves the chess main.piece at the given position, or null if no main.piece
     * is at the position.
     *
     * @param pos Position on main.board.
     * @return Chess main.piece at position, or null if empty square.
     */
    public ChessPiece getPieceAt(Position pos) {
        return grid[pos.rankIndex()][pos.fileIndex()];
    }

    /**
     * Sets a chess main.piece at a given position.
     *
     * @param pos Position on main.board to set.
     * @param piece Chess main.piece, or null to clear the square.
     */
    public void setPieceAt(Position pos, ChessPiece piece) {
        grid[pos.rankIndex()][pos.fileIndex()] = piece;
    }

    public ChessPiece[] getPiecesOnFile(char file) {
        if (file < 'a' || file > 'h') {
            throw new IllegalArgumentException("Invalid file: " + file);
        }

        ChessPiece[] pieces = new ChessPiece[grid.length];

        for (int i = 0; i < grid.length; i++) {
            pieces[i] = getPieceAt(new Position(file, i + 1));
        }

        return pieces;
    }

    /**
     * Populates the main.board with the standard Chess starting position.
     */
    public void initialize() {
        setPieceAt(
                new Position('a', 1),
                new Rook(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('a', 8),
                new Rook(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('b', 1),
                new Knight(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('b', 8),
                new Knight(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('c', 1),
                new Bishop(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('c', 8),
                new Bishop(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('d', 1),
                new Queen(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('d', 8),
                new Queen(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('e', 1),
                new King(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('e', 8),
                new King(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('f', 1),
                new Bishop(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('f', 8),
                new Bishop(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('g', 1),
                new Knight(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('g', 8),
                new Knight(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('h', 1),
                new Rook(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('h', 8),
                new Rook(PieceColor.BLACK)
        );

        // Pawn setup
        for (char file = 'a'; file <= 'h'; file++) {
            setPieceAt(
                    new Position(file, 2),
                    new Pawn(PieceColor.WHITE)
            );

            setPieceAt(
                    new Position(file, 7),
                    new Pawn(PieceColor.BLACK)
            );
        }

        // Set empty squares
        for (int rank = 3; rank <= 6; rank++) {
            for (char file = 'a'; file <= 'h'; file++) {
                setPieceAt(
                        new Position(file, rank),
                        null
                );
            }
        }
    }

    /**
     * Prints this main.board to console.
     */
    public void print() {
        for (int i = grid.length - 1; i >= 0; i--) {
            System.out.println(gridLine());

            StringBuilder strb = new StringBuilder();
            // Rank number
            strb.append(i + 1).append(" ");

            for (int j = 0; j < grid[i].length; j++) {
                strb.append("| ");

                ChessPiece piece = grid[i][j];

                if (piece != null) {
                    strb.append(piece.getIcon()).append(" ");
                } else {
                    strb.append("  ");
                }

                if (j == grid[i].length - 1) strb.append("|");
            }

            System.out.println(strb);
        }

        System.out.println(gridLine());

        // Print files
        StringBuilder filesStrb = new StringBuilder("  ");

        for (char file = 'a'; file <= 'h'; file++) {
            filesStrb.append("  ").append(file).append(" ");
        }
        System.out.println(filesStrb);
    }

    private static String gridLine() {
        return "  " + "+---".repeat(8) + "+";
    }
}
