import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {

        x += velX;
        y += velY;

        //handling movement with keys
        if(handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY = 0;

        if(handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY = 0;

        if(handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX = 0;

        if(handler.isRight()) velX = 5;
        else if(!handler.isLeft()) velX = 0;

        //will also have to handle other button presses here, like inventory, attack, etc...
        
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 40);
    }

    public Rectangle getBounds() {
        return null; //this will be a Rectangle bounding box
    }
    
}
