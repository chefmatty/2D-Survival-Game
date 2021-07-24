import java.awt.Graphics;

public abstract class GameObject {
    
    //x and y coordinates of the object
    protected int x, y;

    //x and y velocity of the object
    protected float velX = 0, velY = 0;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    //abstract methods (each object that inherits this abstract class must implement these)
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

}
