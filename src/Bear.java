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
        double distance = Math.sqrt(Math.pow((x - player.getX()), 2) + Math.pow((y - player.getY()), 2));

        if(distance < 300) angry = true;
        else angry = false;

        if(angry == true){

            if(x > player.getX() + 3) velX = -3;
            else if (x < player.getX() - 3) velX = 3;
            else velX = 0;

            if(y > player.getY() + 3) velY = -3;
            else if(y < player.getY() - 3) velY = 3;
            else velY = 0;

        }

        else{
            velX = 0;
            velY = 0;
        }

    }

    public void render(Graphics g) {
        if(angry == false) g.setColor(Color.black);
        else g.setColor(Color.red);

        g.fillRect(x, y, 60, 40);
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
