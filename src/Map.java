public class Map {
  
    private int [][]tileArray = new int[][]{{0, 0, 0, 0, 0}, 
                                {0, 1, 1, 1, 0},
                                {0, 1, 2, 1, 0},
                                {0, 1, 1, 1, 0},
                                {0, 0, 0, 0, 0}};

    Handler handler;

    public Map(Handler handler){
        this.handler = handler;
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

}
