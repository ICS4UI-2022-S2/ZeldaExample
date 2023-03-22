import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Scene {
    private int row;
    private int col;
    private BufferedImage image;
    private boolean moveNorth;
    private boolean moveEast;
    private boolean moveSouth;
    private boolean moveWest;
    private String description;

    public Scene(int row, int col, 
        String filename, 
        boolean north, boolean east, 
        boolean south, boolean west, 
        String description){
            this.row = row;
            this.col = col;
            this.moveNorth = north;
            this.moveEast = east;
            this.moveSouth = south;
            this.moveWest = west;
            this.description = description;

            // load in the image from the filename
            this.image = null;
            try{
                this.image = ImageIO.read(new File("images//" + filename));
            }catch(Exception e){
                e.printStackTrace();
            }
    }


    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public BufferedImage getImage(){
        return this.image;
    }

    public boolean canMoveNorth(){
        return this.moveNorth;
    }

    public boolean canMoveEast(){
        return this.moveEast;
    }

    public boolean canMoveSouth(){
        return this.moveSouth;
    }

    public boolean canMoveWest(){
        return this.moveWest;
    }

    public String getDescription(){
        return this.description;
    }
}
