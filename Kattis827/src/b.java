import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author A
 *
 */
public class b {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //File f = new File("inputb.txt");
        Scanner sc = new Scanner(System.in);
        int nrows = sc.nextInt();
        int ncolumns = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[nrows + 1][ncolumns + 1];
        
        for (int i = 0; i < ncolumns; i++) {
            if (sc.hasNextLine()) {
            String s = sc.nextLine();
            //System.out.println("S is => " + s);
            char[] yes = s.toCharArray();
            
            grid[i] = yes;
            }
            
        }
//        
//        // print out char array for tests:
//        
//        for (int i = 0; i < 3; i++) {
//            for (int z = 0; z < 3; z++) {
//                System.out.print(grid[i][z] + "(" + "i:" + i + ", z: " + z + ")");
//            }
//            System.out.println();
//            
//        }
        
        // for each column, go thru and find the first obstacle. count how many
        //   'a's are in that column above it
        
                /** Start the write : */
        
        // start at the top of a row.
        
        for (int col = 0; col < ncolumns; col++) {
            int currAppleCount = 0;
            int lastObstacle = 0;
            for (int x = 0; x < nrows; x++) {
                
                // start at the top of a column. move "down", so x + 1
                // "end case": 
                //System.out.println("I'm now at : " + x + ", " + col + "==> " + grid[x][col]);
                if (x == nrows - 1  && grid[x][col] != '#' ) {
                    // if this is a ".", we're done. start putting all a's here
                    // if this is a "# or an a", put all a's 1 above this
                    //System.out.println("I've reached the end of this column! Onto the next one.");
                    if (grid[x][col] == 'a') {
                        currAppleCount++;
                    }
                    if (currAppleCount > 0) {
 
                        for (int currx = x; currx >= lastObstacle; currx--) {
                            // okay
                            
                           
                                if (currAppleCount > 0) {
                                    grid[currx][col] = 'a';
                                    currAppleCount--;
                                    
                                }
                                else {
                                    grid[currx][col] = '.';
                                    
                                }
                            
                        }
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    currAppleCount = 0;
                    lastObstacle = 0;
                }
                // does this still execute?
                if (grid[x][col] == 'a') {
                    //System.out.println(" Found an A at: " + x + ", " + col);
                    currAppleCount++;
                    //System.out.println("Current appleCount is : " + currAppleCount);
                }
                else if (grid[x][col] == '#') {
                    //System.out.println("# at : " + x + ", " + col);
                    //
                    // move all 'a's above this, so to this grid but [x - 1][col]
                    
                    // to do that, go back up this column, adding a's, then empty spaces
                    
                        // Move up 1 square
                            // If the apple count is 0, turn it into a .
                            // If the apple count is greater than 0, turn it into an apple
                            // Decrement the apple count
                            // If you reach a #, then stop?
                       
                    // ^^ loop that top until you reach x = 0?
                    
                        /** let's try writing it. also i'm sure there's a smarter way bc ppl solved this in 17 minutes:*/
                    
                        if (currAppleCount > 0) {
                            // if the current apple count is > 0.. hten start the loop, which will always move all the way up the column
     /**!!!!!!!!!!!!! THIS BREAKS IF TOP ROW IS AN OBSTACLE */                       
                            for (int currx = x - 1; currx >= lastObstacle; currx--) {
                                //System.out.println(" ==> STarting for loop. Current applecount is : " + currAppleCount);
                                // try: 
                                //System.out.println("Running till the lastobstacle, which is: " + lastObstacle);                               
                                if (currAppleCount > 0) { 
                                    grid[currx][col] = 'a';
                                    currAppleCount--;
                                }
                                else {
                                    //System.out.println("!!!!!!!!!!!!!!!!!!");
                                    grid[currx][col] = '.';
                                }
                                
                            }
                        }
                        lastObstacle = x;
                        
                }
                else {
                    
                }
                
                
            }
        }
        

        // print out char array for tests:
        
        for (int i = 0; i < nrows; i++) {
            for (int z = 0; z < ncolumns; z++) {
                System.out.print(grid[i][z]);
            }
            System.out.println();
            
        }
        
    }

}
