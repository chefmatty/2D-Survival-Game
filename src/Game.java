import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    //the constructor for the Game object
    public Game(){
        new Window(800, 800, "Survival Game", this);
    }

    //the run method
    public void run(){
        
    }

    //the main method
    public static void main(String[] args) throws Exception {
        
        //create an instance of the Game object
        Game game = new Game();

    }
}
