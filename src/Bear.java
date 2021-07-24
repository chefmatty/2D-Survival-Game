import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Bear extends GameObject {

    GameObject player;
    boolean angry = false;

    public Bear(int x, int y, ID id, GameObject player) {
        super(x, y, id);
        this.player = player;
    }

    public void tick() {
        x += velX;
        y += velY;

        //make the bear go towards the player

        //if the player is not within range, wander

        //if the player is in range, target the player
        if(x > player.getX() + 3) velX = -3;
        else if (x < player.getX() - 3) velX = 3;
        else velX = 0;

        if(y > player.getY() + 3) velY = -3;
        else if(y < player.getY() - 3) velY = 3;
        else velY = 0;

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 60, 40);
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
