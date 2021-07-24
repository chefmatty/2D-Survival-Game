import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    //x and y coordinates of the object
    protected int x, y;

    //x and y velocity of the object
    protected float velX = 0, velY = 0;

    //the ID of the GameObject
    protected ID id;

    //the constructor
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    //abstract methods (each object that inherits this abstract class must implement these)
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public ID getID() {
        return id;
    }

    public void setID(ID id) {
        this.id = id;
    }

    

}
