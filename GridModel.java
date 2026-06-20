public class GridModel {
    private GridCell[][] grid;
    private int rows;
    private int cols;

    public GridModel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new GridCell[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new GridCell("PATH");
            }
        }
    }

    public GridCell getCell(int r, int c) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            return grid[r][c];
        }
        return null;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
}