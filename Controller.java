import java.awt.image.BufferedImage;

public class Controller {
    
    private MainScreen screen;
    private Map map;

    public Controller(MainScreen screen, String mapFilename){
        this.screen = screen;
        this.map = new Map(mapFilename);
    }

    public void moveNorth(){
        this.map.moveNorth();
    }

    public void moveEast(){
        this.map.moveEast();
    }

    public void moveSouth(){
        this.map.moveSouth();
    }

    public void moveWest(){
        this.map.moveWest();
    }

    public BufferedImage getImage(){
        return this.map.getImage();
    }

    public String getDescription(){
        return this.map.getDescription();
    }
}
