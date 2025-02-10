package tenkinds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tenkinds {
    
    int[][] totalArray;
    int rStart = 0;
    int cStart = 0;
    int rTotal;
    int cTotal;
    private int startInt;
    public static void main(String[] args) throws FileNotFoundException {
        tenkinds t = new tenkinds();
    }
    
    public tenkinds() throws FileNotFoundException {
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        
        rTotal = sc.nextInt();
        cTotal = sc.nextInt();
        totalArray = new int[rTotal][cTotal];
        
        /** fill **/
        for (int i = 0; i < rTotal; i++) {
            String line = sc.next();
            char[] chrs = line.toCharArray();
            for (int z = 0; z < cTotal; z++) {
                totalArray[i][z] = Character.getNumericValue(chrs[z]);
                System.out.print(chrs[z]);
            }
            System.out.println("");
        }
        
//        System.out.println("recursive for 4, 2 and 4, 16 is : " + 
          //this.recursiveFillZero(4, 2, 4, 15);

    }
    
    public void clearRecursiveFill() {
        /** clear recursive fill:
         * 
         */
        
        /*  start at a given coordinate. check if it's 0 or 1*/
        // let's say it's 0:
        
        /** 1. check if it's a 1. if it's a 1, return 
         *     
         *       --> it's not a 1, so keep going
         *       
         *  2. check if we're at the goal. if we are, call this on this current 
         *     coordinate. --> if we are at the goal, check if 0. if 0, return yes. 
         *     if not 0, return neither.
         *     
         *  3. if any of these are illegal accesses in the array, then just ignore them:
         *  
         *     call this on my left neighbor
         *     call this on my right neighbor
         *     call this on my up neighbor
         *     call this on my down neighbor
         *     
         *     
         * 
         */
    }
    
    public void startRecursiveFill(int r1, int c1, int rGoal, int cGoal) {
        startInt = totalArray[r1][c1];
    }
    public int recursiveFillZero(int r1, int c1, int rGoal, int cGoal) {
        System.out.println(" At " + r1 + ", " + c1 + " which is a " + totalArray[r1][c1]);
        
      
        if (r1 == rGoal && c1 == cGoal) {
            System.out.println(" reached this statement" + r1 + " " + c1);
            if (totalArray[r1][c1] == 0) {             
             return 1;
            }
            else {
             return 0;
            }
        }
        
        else {
            
            if (totalArray[r1][c1] == 1){
                System.out.println("Reached a 1!!! I'm at : " + r1 + ", " + c1);
                return 0;
            } 
            System.out.println("I'm executing");
            int rmin = r1;
            int cmin = c1;
            int rmax = r1;
            int cmax = c1;
            if (r1 - 1 >= 0) {
                rmin = r1 - 1;
            }
            if (r1 + 1 <= rTotal) {
                rmax = r1 + 1;
            }
            if (c1 - 1 >= 0) {
                cmin = c1 - 1;
            }
            if (c1 + 1 <= cTotal) {
                cmax = c1 + 1;
            }
            
            // recursive checks lol so sloppy
            /** call up if rmin isn't the same; otherwise, we call
             * it on itself
             */
            int up = 0;
            int left = 0; 
            int down = 0;
            int right = 0;
            
            if (rmin != r1) {
                up = this.recursiveFillZero(rmin, c1, rGoal, cGoal);
            }
            // left. if cmin == c, the nwe call it on r, c, itself
            if (cmin != c1) {
                left = this.recursiveFillZero(r1, cmin, rGoal, cGoal);
            }
            if (rmax != r1) {
                down = this.recursiveFillZero(rmax, c1, rGoal, cGoal);
            }
            if (cmax != c1) { 
                right = this.recursiveFillZero(r1, cmax, rGoal, cGoal);
            }
            

        }
        System.out.println(" reached end - we never found it? @@@@@@@@@@@@@@@@@@@@@@@@");
        return cGoal;
    }
    
    
    
    

}
