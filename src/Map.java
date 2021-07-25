public class Map {
  
    private int [][]tileArray = new int[200][200];

    Handler handler;
    Noise perlin;

    public Map(Handler handler){
        this.handler = handler;
        perlin = new Noise();
    }

    //generates the tileArray using perlin noise
    public void generateMap(){

        for(int x = 0; x < tileArray.length; x++){
            for(int y = 0; y < tileArray[0].length; y++){
                double coord = Noise.noise(x+0.5, y+0.5);
                //System.out.println(coord);
                if(coord > -0.3) tileArray[x][y] = 0;
                else if(coord > -0.6) tileArray[x][y] = 1;
                else tileArray[x][y] = 2;
            }
        }
    }

    //draws the world based on the given tileArray
    public void drawWorld(){
        int tileX = 0;
        int tileY = 0;
        for(int i = 0; i < tileArray.length; i++){
            tileX = i*4;
            for(int z = 0; z < tileArray[0].length; z++){
                tileY = z*4;
                Tile newTile = new Tile(tileX, tileY, ID.Tile, tileArray[i][z]);
                handler.object.add(newTile);
            }
        }
    }

}
