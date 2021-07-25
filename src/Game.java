import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    //private data
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private int[][] tileArray;

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
        camera = new Camera(0,0);
        tileArray = new int[][]{{0, 0, 0, 0, 0}, 
                                {0, 1, 1, 1, 0},
                                {0, 1, 2, 1, 0},
                                {0, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0}};
        this.addKeyListener(new KeyInput(handler));

        generateWorld();
        Player player = new Player(100, 100, ID.Player, handler);
        handler.addObject(player);
        handler.addObject(new Bear(600, 600, ID.Bear, player));
        handler.addObject(new Deer(400, 400, ID.Deer, player));
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

    //tick calls the tick method of each GameObject
    public void tick(){
        camera.tick(handler.object.get(0));
        handler.tick();
    }

    //render places items onto the screen
    public void render(){
        //this block is pre-loading 2 frames in
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        ///////////////////////////
        //Draw things below here!
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);

        g2d.translate(-camera.getX(), -camera.getY());

        g.setColor(Color.gray);
        g.fillRect(0, 0, 500, 500);
        //render all the objects
        handler.render(g);

        g2d.translate(camera.getX(), camera.getY());
        //Draw things above here!
        ///////////////////////////
        g.dispose();
        bs.show();
    }

    //generates the world based on the given tileArray
    public void generateWorld(){
        int tileX = 0;
        int tileY = 0;
        for(int i = 0; i < tileArray.length; i++){
            tileX = i*32;
            for(int z = 0; z < tileArray[0].length; z++){
                tileY = z*32;
                Tile newTile = new Tile(tileX, tileY, ID.Tile, tileArray[i][z]);
                handler.object.add(newTile);
            }
        }
    }

    //the main method
    public static void main(String[] args) throws Exception {
        
        //create an instance of the Game object
        Game game = new Game();

    }
}
