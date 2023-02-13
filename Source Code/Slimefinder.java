package core;
import java.util.Random;

public class Slimefinder {
    long seed;
    public final int[][] chunksWeights = {
    {0,0,0,0,0,0,0,0,12,12,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,71,173,238,256,256,238,173,71,0,0,0,0,0},
    {0,0,0,20,181,256,256,256,25,256,256,256,256,181,20,0,0,0},
    {0,0,20,214,256,256,256,256,256,256,256,256,256,256,214,20,0,0},
    {0,0,181,256,256,256,256,256,256,256,256,256,256,256,256,181,0,0},
    {0,71,256,256,256,256,256,256,256,256,256,256,256,256,256,256,71,0},
    {0,173,256,256,256,256,256,256,256,256,256,256,256,256,256,256,173,0},
    {0,238,256,256,256,256,256,253,156,156,253,256,256,256,256,256,238,0},
    {12,256,256,256,256,256,256,156,0,0,156,256,256,256,256,256,256,12},
    {12,256,256,256,256,256,256,156,0,0,156,256,256,256,256,256,256,12},
    {0,238,256,256,256,256,256,253,156,156,253,256,256,256,256,256,238,0},
    {0,173,256,256,256,256,256,256,256,256,256,256,256,256,256,256,173,0},
    {0,71,256,256,256,256,256,256,256,256,256,256,256,256,256,256,71,0},
    {0,0,181,256,256,256,256,256,256,256,256,256,256,256,256,181,0,0},
    {0,0,20,214,256,256,256,256,256,256,256,256,256,256,214,20,0,0},
    {0,0,0,20,181,256,256,256,256,256,256,256,256,181,20,0,0,0},
    {0,0,0,0,0,71,173,238,256,256,238,173,71,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,12,12,0,0,0,0,0,0,0,0}
    };
    Slimefinder(){}
    public void search(long seed,int searchR,int minChunks){
        this.seed = seed;
        for(int chunkX = -searchR;chunkX < searchR;chunkX++){
            for (int chunkY = -searchR;chunkY < searchR;chunkY++){
                float[] a = calcPos(chunkX,chunkY,seed);
                float nchunks = a[0];
                if(nchunks > minChunks){
                    System.out.println("Find a position with "+nchunks+" chunks "+"using "+a[1]+" partial chunks in chunk position x= "+chunkX+", y= "+chunkY+"   ");
                    
                }
            }
        }
    }
    public float searchBest(long seed,int searchR){
        float best = 0,b = 0;
        this.seed = seed;
        int x = 0,y = 0;
        for(int chunkX = -searchR;chunkX < searchR;chunkX++){
            for (int chunkY = -searchR;chunkY < searchR;chunkY++){
                float[] a = calcPos(chunkX,chunkY,seed);
                float nchunks = a[0];
                if(nchunks > best){
                    best = nchunks;
                    y = chunkY;
                    x = chunkX;
                    b = a[1];
                }
            }
        }
        System.out.println("Found a position with "+best+" chunks using "+b+" partial chunks in chunk position x= "+x+", y= "+y);
        return best;
    }
    void searchUntil(long seed,double min){
        this.seed = seed;
        int x = 0;
        int y = 0;
        int r = 5;
        char dir = 'd';
        boolean searching = true;
        while (searching){
            switch(dir){
                case 'd':
                    x++;
                    break;
                case 's':
                    y--;
                    break;
                case 'a':
                    x--;
                    break;
                case 'w':
                    y++;
                    break;
                }
            if(x==r&&dir=='d'){dir = 'w';}
            else if(x==(-r)&&dir=='a'){dir = 's';}
        else if(y==r&&dir=='w'){dir = 'a';}
            else if(y<=(-r)&&dir=='s'){dir = 'd';r++;}
            if(calcPos(x,y,seed)[0]>=min){
                System.out.println("Found a point with "+calcPos(x,y,seed)[0]+"absolute chunks using "+calcPos(x,y,seed)[1]+"partial chunks in x: "+x+" and y: "+y);
                searching = false;
            }
        }
        }
    public float[] calcPos(int chunkX,int chunkY,long seed){
        this.seed = seed;
        float count = 0.0f;
        float countc = 0.0f;
        for(int i = -9;i<9;i++){
            for(int j = -9;j<9;j++){
                if(isSlimeChunk(this.seed,chunkX+i,chunkY+j)){
                    if(chunksWeights[i+9][j+9]!=0)countc += 1;
                    count+=chunksWeights[i+9][j+9];
                }
            }
        }
        count /= 256;
        float[] a = {count,countc};
        return a;
    }
    public boolean isSlimeChunk(long seed, int chunkX, int chunkZ) {
        Random r= new Random();
        r.setSeed(seed + (long) (chunkX * chunkX * 4987142) + (long) (chunkX * 5947611) + (long) (chunkZ * chunkZ) * 4392871L + (long) (chunkZ * 389711) ^ 987234911L);
        return r.nextInt(10) == 0;
    }
}
