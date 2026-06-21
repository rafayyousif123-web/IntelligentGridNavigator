import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class MazeGenerator {
    private GridModel model;

    public MazeGenerator(GridModel model) {
        this.model = model;
    }

    public void generate() {
        for (int r = 0; r < model.getRows(); r++) {
            for (int c = 0; c < model.getCols(); c++) {
                model.getCell(r, c).setWall(true);
            }
        }
        carvePath(0, 0);
  
        model.getCell(0, 0).setCellType("START");
        model.getCell(0, 0).setWall(false);
        model.getCell(model.getRows() - 1, model.getCols() - 1).setCellType("EXIT");
        model.getCell(model.getRows() - 1, model.getCols() - 1).setWall(false);
    }

    private void carvePath(int r, int c) {
        GridCell current = model.getCell(r, c);
        if (current == null || current.isVisited()) return;

        current.setVisited(true);
        current.setWall(false);

        Integer[] dirs = {0, 1, 2, 3};
        List<Integer> dirList = Arrays.asList(dirs);
        Collections.shuffle(dirList); 

        for (int dir : dirList) {
            int nextR = r, nextC = c;
            int wallR = r, wallC = c;

            if (dir == 0) { nextR = r + 2; wallR = r + 1; } 
            else if (dir == 1) { nextR = r - 2; wallR = r - 1; } 
            else if (dir == 2) { nextC = c + 2; wallC = c + 1; } 
            else if (dir == 3) { nextC = c - 2; wallC = c - 1; } 

            GridCell targetCell = model.getCell(nextR, nextC);
            if (targetCell != null && !targetCell.isVisited()) {
                model.getCell(wallR, wallC).setWall(false);
                carvePath(nextR, nextC); 
            }
        }
    }
}