import java.util.ArrayList;
import java.awt.Graphics;

public class Handler {
    
    ArrayList<GameObject> object = new ArrayList<GameObject>();

    //loops through every GameObject and calls each GameObject's tick() method
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject temp){
        object.add(temp);
    }

    public void removeObject(GameObject temp){
        object.remove(temp);
    }
}
