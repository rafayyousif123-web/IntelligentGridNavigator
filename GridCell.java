public class GridCell {
    
    private boolean isWall;
    private boolean isVisited;
    private String cellType; 

    public GridCell(String cellType) {
        this.cellType = cellType;
        this.isWall = cellType.equals("WALL");
        this.isVisited = false;
    }

    public boolean isWall() { return isWall; }
    public void setWall(boolean wall) { 
        this.isWall = wall; 
        this.cellType = wall ? "WALL" : "PATH";
    }

    public boolean isVisited() { return isVisited; }
    public void setVisited(boolean visited) { this.isVisited = visited; }

    public String getCellType() { return cellType; }
    public void setCellType(String cellType) { this.cellType = cellType; }
}