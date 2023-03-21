import java.io.File;
import java.util.Scanner;

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

    }

}
