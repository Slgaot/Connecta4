public class Board {
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private String[][] grid;

    public Board() {
        grid = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = "⬜";
            }
        }
    }
    public boolean checkWin(String symbol) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (checkDirection(i, j, 1, 0, symbol) ||
                        checkDirection(i, j, 0, 1, symbol) ||
                        checkDirection(i, j, 1, 1, symbol) ||
                        checkDirection(i, j, 1, -1, symbol)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dropToken(int column, String symbol) {
        if (column < 0 || column >= COLUMNS || !grid[0][column].equals("⬜")) {
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column].equals("⬜")) {
                grid[i][column] = symbol;
                return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol, String symbol) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + i * dRow;
            int c = col + i * dCol;
            if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS && grid[r][c].equals(symbol)) {
                count++;
            } else {
                break;
            }
        }
        return count == 4;
    }
}
