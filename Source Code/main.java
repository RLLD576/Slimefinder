package core;
import java.util.Scanner;

public class main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long seed = Long.parseLong(args[0]);
        int searchR, minChunks;
        int chunkX,chunkY;
        Slimefinder finder = new Slimefinder();
        switch(args[1]){
            case "-b":
            System.out.println("Search radius: ");
            searchR = sc.nextInt();
            finder.searchBest(seed, searchR);
            break;
            case "-s":
                System.out.println("Search radius: ");
                searchR = sc.nextInt();
                System.out.println("Minimun chunks: ");
                minChunks = sc.nextInt();
                finder.search(seed,searchR,minChunks);
                break;
            case "-o":
                chunkX = sc.nextInt();
                chunkY = sc.nextInt();
                if(finder.isSlimeChunk(seed,chunkX,chunkY)){
                    System.out.println("Chunk x: "+chunkX+" y: "+chunkY+" is a slime chunk");
                } else {
                    System.out.println("Chunk x: "+chunkX+" y: "+chunkY+" isn't a slime chunk");
                }
                break;
            case "-m":
                System.out.println("Insert minimum chunks: ");
                int min = sc.nextInt();
                finder.searchUntil(seed,min);
                break;
            case "-z":
                System.out.println("Insert x: ");
                int x = sc.nextInt();
                System.out.println("Insert y: ");
                int y = sc.nextInt();
                float[] point = finder.calcPos(x,y);
                System.out.println(point[0]);
                System.out.println(point[1]);
                System.out.println("The afk point has "+point[0]+" absolute chunks and "+point[1]+" partial chunks.");
                break;
            case "-h":
                System.out.println("-h : Show this message");
                System.out.println("-s : Search per zone");
                System.out.println("-o : Know if a chunk is slimechunk");
                System.out.println("-z : know how many absolute chunks and partial chunks has an afk point");
                System.out.println("-m : Search until a minimum of chunks");
                System.out.println("-b : Search the best afk point in the given radius search");
                break;
        }
    }
/*     public static boolean isSlimeChunk(long seed, int chunkX, int chunkZ) {
        Random r= new Random();
        r.setSeed(seed + (long) (chunkX * chunkX * 4987142) + (long) (chunkX * 5947611) + (long) (chunkZ * chunkZ) * 4392871L + (long) (chunkZ * 389711) ^ 987234911L);
        return r.nextInt(10) == 0;
    }
*/
}
