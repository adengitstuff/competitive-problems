/**
 * 
 */
package alienints;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class alienints {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    HashMap<Integer, Boolean> forbidden = new HashMap<Integer, Boolean>();
    public static void main(String[] args) throws FileNotFoundException {

        alienints alien = new alienints();
    }
    
    public alienints() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int length = String.valueOf(n).length();
        
        long ncopy = n;
        
        while (ncopy > 0) {
            int split = (int)(ncopy % 10);
            forbidden.put(split, true);
            ncopy = ncopy / 10;
        }
        
        // we now have a list of forbdiden numbers!
        
        // if the hashmap's size is 10, return "impossible".
        if (forbidden.size() == 10) {
            System.out.println("Impossible");     
            System.exit(0);
        }
        int trycopy = (int)(n - 2);
        boolean tf = this.isClear(trycopy);
        
        // trying a loop

        long min = this.minima(n);
        long difference = n - min;
       
        long newint = n + difference;
        
        if (this.isClear(newint)) {
            while (this.isClear(newint - 1)) {
                newint--;                
            }
        }
        else {
            newint = 99999;
        }
        
        if (difference < (newint - n)) {
            System.out.println(min);
        }
        else if (difference > (newint - n)) {
            System.out.println(newint);
        }
        else {
            System.out.println(min + " " + newint);
        }
        
    }
    
    public long minima(long n) {
        long nxcopy = n;
        while (this.isClear(nxcopy) == false) {
            nxcopy--;
        }
        return nxcopy;
    }
    
    public long maxima(long n) {
        long nxcopypos = n;
        
        while (this.isClear(nxcopypos) == false) {
            nxcopypos++;
        }
        return nxcopypos;
    }
    
    public boolean isClear(long x) {
        // an int x is clear if it contains no forbidden numbers
        
        long xcopy = x;
        
        while (xcopy > 0) {
            int split = (int)(xcopy % 10);
            
            if (forbidden.get(split) == null) {
                // the split number isn't in the hashmap. this split number is claer
            }
            else {
                return false;
            }
            
            xcopy = xcopy / 10;
        }
        return true;
    }

}
