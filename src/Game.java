import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    //private data
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    //the start method, which starts a thread
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //the stop method, which stops a thread
    private void stop(){
        isRunning = false;
        try{
            thread.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //the constructor for the Game object
    public Game(){
        new Window(800, 800, "Survival Game", this);
        start();
        handler = new Handler();
        handler.addObject(new Box(100, 100));
    }

    //the run method, which houses the game loop
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    //calls the tick method of each GameObject
    public void tick(){
        handler.tick();
    }

    public void render(){
        //this block is pre-loading 2 frames in
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ///////////////////////////
        //Draw things below here!

        g.setColor(Color.red);
        g.fillRect(0, 0, 500, 500);

        //render all the objects
        handler.render(g);

        //Draw things above here!
        ///////////////////////////
        g.dispose();
        bs.show();
    }

    //the main method
    public static void main(String[] args) throws Exception {
        
        //create an instance of the Game object
        Game game = new Game();

    }
}
