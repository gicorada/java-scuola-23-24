package libro.cap12.altri.otto_regine;

public class Queen {
    private int row;
    private int col;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean attacca(Queen q) {
        return row == q.row || col == q.col || Math.abs(row - q.row) == Math.abs(col - q.col);
    }

    public String toString() {
        return "abcdefgh".charAt(col) + "" + (row+1);
    }
}
