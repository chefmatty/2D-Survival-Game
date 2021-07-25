public class Camera {
    
    private float x, y;

    //the constructor
    public Camera(float x, float y){
        this.x = x;
        this.y = y;
    }

    //tick
    public void tick(GameObject object){
        
        //the 800's are the length and width of the window
        x+= ((object.getX() - x - 800/2));
        y+= ((object.getY() - y - 800/2));

        if(x <= 0) x = 0;
        if(x >= 800) x = 800;
        if(y <= 0) y = 0;
        if(y >= 800) y = 800;

    }

    //getters and setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
