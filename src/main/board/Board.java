package main.board;

import main.piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An object representing a Chess board.
 */
public class Board {
    private final ChessPiece[][] grid = new ChessPiece[8][8];

    /**
     * Retrieves the chess piece at the given position, or null if no piece
     * is at the position.
     *
     * @param pos Position on board.
     * @return Chess piece at position, or null if empty square.
     */
    public ChessPiece getPieceAt(Position pos) {
        return grid[pos.rankIndex()][pos.fileIndex()];
    }

    /**
     * Sets a chess piece at a given position.
     *
     * @param pos Position on board to set.
     * @param piece Chess piece, or null to clear the square.
     */
    public void setPieceAt(Position pos, ChessPiece piece) {
        grid[pos.rankIndex()][pos.fileIndex()] = piece;
    }

    /**
     * Moves a piece from one square to another. The origin piece must exist.
     *
     * @param from Position of piece to move.
     * @param to Destination.
     */
    public void movePiece(Position from, Position to) {
        ChessPiece originPiece = getPieceAt(from);
        if (originPiece == null) {
            throw new IllegalArgumentException("No existing piece is at position " + from);
        }

        setPieceAt(from, null);
        setPieceAt(to, originPiece);
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
     * Gets position data of every piece of a specified type. An empty list indicates no pieces matched
     * the input.
     *
     * @param color Piece color.
     * @param pieceType Pieces to identify.
     * @return List of positions being occupied.
     */
    public List<Position> getPositionsOf(PieceColor color, PieceType pieceType) {
        List<Position> positions = new ArrayList<>();

        for (char file = 'a'; file <= 'h'; file++) {
            for (int rank = 1; rank <= 8; rank++) {
                Position pos = new Position(file, rank);
                ChessPiece piece = getPieceAt(pos);

                if (piece != null && piece.getPieceColor() == color && piece.getPieceType() == pieceType) {
                    positions.add(pos);
                }
            }
        }

        return positions;
    }

    /**
     * Gets the material value comparison between white and black. A positive value indicates
     * white has more material, where a negative value states black has more. A value of 0 indicates
     * the board has equal material for both colors.
     * <p/>
     * Examples: 4 = White is up 4 points, -5 = Black is up 5 points.
     *
     * @return Exact material difference.
     */
    public int getMaterialDifference() {
        int difference = 0;

        for (ChessPiece[] row : grid) {
            for (ChessPiece piece : row) {
                if (piece != null) {
                    if (piece.getPieceColor() == PieceColor.WHITE) {
                        difference += piece.getPieceValue();
                    } else {
                        difference -= piece.getPieceValue();
                    }
                }
            }
        }

        return difference;
    }

    /**
     * Converts this board data into a Hash Map, associating positions with the current piece.
     *
     * @return Map of board.
     */
    public Map<Position, ChessPiece> toMap() {
        Map<Position, ChessPiece> boardMap = new HashMap<>();

        for (char file = 'a'; file <= 'h'; file++) {
            for (int rank = 1; rank <= 8; rank++) {
                Position pos = new Position(file, rank);
                ChessPiece piece = getPieceAt(pos);

                if (piece != null) {
                    boardMap.put(pos, piece);
                }
            }
        }

        return boardMap;
    }

    /**
     * Initializes a board using map data.
     *
     * @param boardMap Map data to use.
     * @return Board with populated pieces.
     */
    public static Board fromMap(Map<Position, ChessPiece> boardMap) {
        Board board = new Board();

        for (Map.Entry<Position, ChessPiece> entry : boardMap.entrySet()) {
            board.setPieceAt(entry.getKey(), entry.getValue());
        }

        return board;
    }

    /**
     * Populates the board with the standard Chess starting position.
     */
    public void initialize() {
        setPieceAt(
                new Position('a', 1),
                ChessPiece.rook(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('a', 8),
                ChessPiece.rook(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('b', 1),
                ChessPiece.knight(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('b', 8),
                ChessPiece.knight(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('c', 1),
                ChessPiece.bishop(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('c', 8),
                ChessPiece.bishop(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('d', 1),
                ChessPiece.queen(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('d', 8),
                ChessPiece.queen(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('e', 1),
                ChessPiece.king(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('e', 8),
                ChessPiece.king(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('f', 1),
                ChessPiece.bishop(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('f', 8),
                ChessPiece.bishop(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('g', 1),
                ChessPiece.knight(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('g', 8),
                ChessPiece.knight(PieceColor.BLACK)
        );

        setPieceAt(
                new Position('h', 1),
                ChessPiece.rook(PieceColor.WHITE)
        );
        setPieceAt(
                new Position('h', 8),
                ChessPiece.rook(PieceColor.BLACK)
        );

        // Pawn setup
        for (char file = 'a'; file <= 'h'; file++) {
            setPieceAt(
                    new Position(file, 2),
                    ChessPiece.pawn(PieceColor.WHITE)
            );

            setPieceAt(
                    new Position(file, 7),
                    ChessPiece.pawn(PieceColor.BLACK)
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
     * Prints this board to console.
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

    /**
     * Prints this board to console, with the black side at the bottom.
     */
    public void printFlipped() {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(gridLine());

            StringBuilder strb = new StringBuilder();
            // Rank number
            strb.append(i + 1).append(" ");

            for (int j = grid[i].length - 1; j >= 0; j--) {
                strb.append("| ");

                ChessPiece piece = grid[i][j];

                if (piece != null) {
                    strb.append(piece.getIcon()).append(" ");
                } else {
                    strb.append("  ");
                }

                if (j == 0) strb.append("|");
            }

            System.out.println(strb);
        }

        System.out.println(gridLine());

        // Print files
        StringBuilder filesStrb = new StringBuilder("  ");

        for (char file = 'h'; file >= 'a'; file--) {
            filesStrb.append("  ").append(file).append(" ");
        }
        System.out.println(filesStrb);
    }

    private static String gridLine() {
        return "  " + "+---".repeat(8) + "+";
    }
}
