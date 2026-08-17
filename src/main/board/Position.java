package main.board;

import java.util.Optional;

/**
 * Contains file and rank information about a square on a main.board.
 *
 * @param file X-axis identifier (a-h)
 * @param rank Y-axis identifier (1-8)
 */
public record Position(char file, int rank) {
    public Position {
        if (isInvalid(file, rank)) {
            throw new IllegalArgumentException(
                    String.format("Invalid chess square: %c%d", file, rank)
            );
        }
    }

    /**
     * Gets the array index of this position's file (ex: a=0, h=7).
     *
     * @return Index of file.
     */
    public int fileIndex() {
        return file - 'a';
    }

    /**
     * Gets the array index of this position's rank. A main.piece on the 8th rank would return
     * an index of 7, and a main.piece on the 1st rank would return 0.
     *
     * @return Row index of main.board.
     */
    public int rankIndex() {
        return rank - 1;
    }

    /**
     * Retrieves a destination position from this origin.
     *
     * @param deltaFile File offset.
     * @param deltaRank Rank offset.
     * @return Optional position, populated if within bounds of standard board.
     */
    public Optional<Position> offset(int deltaFile, int deltaRank) {
        char newFile = (char) (this.file + deltaFile);
        int newRank = this.rank + deltaRank;

        if (isInvalid(newFile, newRank)) {
            return Optional.empty();
        }

        return Optional.of(new Position(newFile, newRank));
    }

    private boolean isInvalid(char file, int rank) {
        return file < 'a' || file > 'h' || rank < 1 || rank > 8;
    }

    @Override
    public String toString() {
        return "" + file + rank;
    }
}
