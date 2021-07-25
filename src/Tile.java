import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Tile extends GameObject {

    int type; //0 for grass, 1 for sand, 2 for water

    public Tile(int x, int y, ID id, int type) {
        super(x, y, id);
        this.type = type;
    }

    public void tick() {
        
    }

    public void render(Graphics g) {
        if(type == 0){
            g.setColor(Color.green);
            g.fillRect(x, y, 32, 32);
        }
        else if(type == 1){
            g.setColor(Color.yellow);
            g.fillRect(x, y, 32, 32);
        }
        else if(type == 2){
            g.setColor(Color.blue);
            g.fillRect(x, y, 32, 32);
        }
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
