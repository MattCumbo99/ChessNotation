package board;

public record Position(char file, int rank) {
    public Position {
        if (file < 'a' || file > 'h' || rank < 1 || rank > 8) {
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
     * Gets the array index of this position's rank.
     *
     * @return Rank - 1.
     */
    public int rankIndex() {
        return rank - 1;
    }

    @Override
    public String toString() {
        return "" + file + rank;
    }
}
