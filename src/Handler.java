import java.util.ArrayList;
import java.awt.Graphics;

public class Handler {

    //private data for key presses
    private boolean up = false, down = false, left = false, right = false;

    //ArrayList of all the GameObjects
    ArrayList<GameObject> object = new ArrayList<GameObject>();

    //tick loops through every GameObject and calls each GameObject's tick() method
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }
    
    //render loops through every GameObject and calls each GameObject's render() method
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    //addObject adds a GameObject to the ArrayList
    public void addObject(GameObject temp){
        object.add(temp);
    }

    //removeObject removes a GameObject from the ArrayList
    public void removeObject(GameObject temp){
        object.remove(temp);
    }

    //getters and setters for key presses
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
