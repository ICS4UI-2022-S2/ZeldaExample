import java.io.File;
import java.util.Scanner;
import java.awt.image.BufferedImage;

public class Map {
    private Scene[] scenes;
    private int currentRow;
    private int currentCol;
    private Scene currentScene;

    public Map(String filename){
        // create a Scanner to read the file
        Scanner input = null;
        try{
            input = new Scanner(new File(filename));
        }catch(Exception e){
            e.printStackTrace();
        }

        // scan in the map size
        int numRows = input.nextInt();
        // drop to next line
        input.nextLine();
        int numCols = input.nextInt();
        input.nextLine();

        // scan in starting position
        this.currentRow = input.nextInt();
        input.nextLine();
        this.currentCol = input.nextInt();
        input.nextLine();

        // start building the scenes
        int numScenes = numRows * numCols;
        this.scenes = new Scene[numScenes];
        // start loading in the scenes
        for(int i = 0; i < numScenes; i++){
            String imageFilename = input.next();
            boolean moveNorth = input.nextBoolean();
            boolean moveEast = input.nextBoolean();
            boolean moveSouth = input.nextBoolean();
            boolean moveWest = input.nextBoolean();
            // scan in anything left over and move down
            String description = input.nextLine();

            // recover the scene row and column
            // remove file extension
            String removeExtension = imageFilename.replace(".png","");
            String[] data = removeExtension.split("-");
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[3]);

            // put the scene into the array
            this.scenes[i] = new Scene(row, col, imageFilename, 
                                moveNorth, moveEast, moveSouth, 
                                moveWest, description);
        }

        // find the starting scene
        this.currentScene = this.findScene(this.currentRow, this.currentCol);

    }

    public Scene findScene(int row, int col){
        for(int i = 0; i < this.scenes.length; i++){
            Scene tempScene = this.scenes[i];
            // does the scene match the row and col we are looking for
            if(tempScene.getRow() == row && tempScene.getCol() == col){
                return tempScene;
            }
        }
        // if we went through all scenes, no match found
        return null;
    }

    public void moveNorth(){
        // can we move up?
        if(this.currentScene.canMoveNorth()){
            this.currentRow--;
            this.currentScene = this.findScene(this.currentRow, this.currentCol);
        }
    }

    public void moveEast(){
        // can we move right?
        if(this.currentScene.canMoveEast()){
            this.currentCol++;
            this.currentScene = this.findScene(this.currentRow, this.currentCol);
        }
    }

    public void moveSouth(){
        // can we move down?
        if(this.currentScene.canMoveSouth()){
            this.currentRow++;
            this.currentScene = this.findScene(this.currentRow, this.currentCol);
        }
    }

    public void moveWest(){
        // can we move left?
        if(this.currentScene.canMoveWest()){
            this.currentCol--;
            this.currentScene = this.findScene(this.currentRow, this.currentCol);
        }
    }

    public BufferedImage getImage(){
        return this.currentScene.getImage();
    }

    public String getDescription(){
        return this.currentScene.getDescription();
    }

}
