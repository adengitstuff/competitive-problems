/**
 * 
 */
package addmeup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class addmeup {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    HashMap<Integer, Integer> hm;
    HashMap<Integer, Integer> eachnum;
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        
        addmeup add = new addmeup();
    }
    
    public addmeup() throws FileNotFoundException {
        //File f = new File("input.txt");
        Scanner sc = new Scanner(System.in);     
        int numcards = sc.nextInt();
        int sum = sc.nextInt();
        hm = new HashMap<Integer, Integer>();
        eachnum = new HashMap<Integer, Integer>();
        this.sethm();
        
        for (int i = 0; i < numcards; i++) {
            int rn = sc.nextInt();
            String str = String.valueOf(rn);
            if (str.contains("3") || str.contains("4") || str.contains("7")) {
                this.puts(rn);
            }
            else {
                /** it's a flippable number, so add this and its reverse into a hashtable*/
                int flipped = this.flip(rn);
                
                if (flipped != rn) {
                    // check if it' already in
                    //System.out.println("putting : " + flipped);
                   this.puts(flipped);
                }
                //System.out.println("putting : " + rn);
                this.puts(rn);                
            }
         
        } /** end for */
        
        // check?
        sc.close();
        this.check(sum);
        
    }
    
    /** add to hashtable, with value as the # of times it is
     * given. e.g. 15 15 15 would have 15 mapped to 3?
     * @param n
     */
    public void puts(int n) {
        if (eachnum.get(n) == null) {
            eachnum.put(n, 1);
            //System.out.println("putting : " + n + " and now =>" + eachnum.get(n));
        }
        else {
            int c = hm.get(n) + 1;
            //eachnum.replace(n, c, (c+1));
            eachnum.remove(n);
            eachnum.put(n, c);
        }
    }

    /** go thru keyset. to keep constant, find the remainder
     * we would need and check if it's present
     * 
     * this fails the case where sum = 66, and nums are: 15, 21, 22.
     * this is bc 15 and 51 are both technically in the map - so 15 + 51.
     * so to avoid that i put a count for each number; only if 15 is in the
     * nums more than 1 time should it count
     * 
     * @param sumx
     * @return
     */
    public void check(int sumx) {
       
        for (int n : eachnum.keySet()) {
            int remainder = sumx - n;
            if (eachnum.get(remainder) == null) { // O(1) baby
                // remainders not in there at all, flipped or regular
            }
            else {
                int fl = this.flip(n);
                if (fl == remainder) {
                    // ignore first one
                    int count = eachnum.get(fl);
                    if (count > 1) {
                        System.out.println("YES");
                        System.exit(0);
                    }
                    else {
                        
                    }
                }
                else {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");
        System.exit(0);
    }

    public int flip(int f) {
        
        int num = f;
        int newnum = 0;
        while (num > 0) {
            int rem = num % 10;            
            newnum = (newnum * 10) + hm.get(rem);           
            num = num / 10;
        }
        return newnum;
    }
    
    public void sethm() {
        // assumed all cases
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(2, 2);
        hm.put(5, 5);
        hm.put(6, 9);
        hm.put(8, 8);
        hm.put(9, 6);
       
    }
    

}
