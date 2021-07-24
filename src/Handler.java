import java.util.ArrayList;
import java.awt.Graphics;

public class Handler {
    
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
}
