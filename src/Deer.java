import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Deer extends GameObject{
    
    GameObject player;
    boolean scared = false;

    public Deer(int x, int y, ID id, GameObject player) {
        super(x, y, id);
        this.player = player;
    }

    public void tick() {
        x += velX;
        y += velY;

        //make the deer run away the player

        //if the player is not within range, wander

        //if the player is in range, run from the player
        double distance = Math.sqrt(Math.pow((x - player.getX()), 2) + Math.pow((y - player.getY()), 2));

        if(distance < 300) scared = true;
        else scared = false;

        if(scared == true){

            if(x >= player.getX()) velX = 3;
            else if (x < player.getX()) velX = -3;
            //else velX = 0;

            if(y >= player.getY()) velY = 3;
            else if(y < player.getY()) velY = -3;
            //else velY = 0;

        }

        else{
            velX = 0;
            velY = 0;
        }

    }

    public void render(Graphics g) {
        if(scared == false) g.setColor(Color.green);
        else g.setColor(Color.ORANGE);

        g.fillRect(x, y, 60, 40);
    }

    public Rectangle getBounds() {
        return null;
    }

}
