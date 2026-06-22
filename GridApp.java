public class GridApp {
    public static void main(String[] args) {
        int rows = 11; 
        int cols = 11;
        
        System.out.println("Initializing Intelligent Grid Navigator...");
        GridModel model = new GridModel(rows, cols);
        
        System.out.println("Generating Random Maze Structure...");
        MazeGenerator generator = new MazeGenerator(model);
        generator.generate();
        
        System.out.println("\n--- Generated Maze Preview ---");
        System.out.println("S = Start, E = Exit, # = Wall, . = Open Path");
        printGrid(model);
    }
    
    private static void printGrid(GridModel model) {
        for (int r = 0; r < model.getRows(); r++) {
            for (int c = 0; c < model.getCols(); c++) {
                GridCell cell = model.getCell(r, c);
                if (cell.getCellType().equals("START")) {
                    System.out.print("S ");
                } else if (cell.getCellType().equals("EXIT")) {
                    System.out.print("E ");
                } else if (cell.isWall()) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}