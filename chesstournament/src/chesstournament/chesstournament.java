/**
 * 
 */
package chesstournament;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class chesstournament {

    /** since there can only be 1 player per
     * number (1, 2, 3), and each number represents
     * a player, an array seems appropriate here?
     * @param args
     */
    int numplayers;
    int nummatches;
    HashMap<Integer, ArrayList<Integer>> win;
    HashMap<Integer, ArrayList<Integer>> equals;
    private boolean canExist = true;
    public static void main(String[] args) throws FileNotFoundException {
       
        chesstournament chess = new chesstournament();

    }
    
    public chesstournament() throws FileNotFoundException {
        File f = new File("inputs2.txt");
        Scanner sc = new Scanner(f);
        
        /** initiailze hashmaps*/       
        numplayers = sc.nextInt();
        nummatches = sc.nextInt();
        win = new HashMap<Integer, ArrayList<Integer>>(numplayers);
        equals = new HashMap<Integer, ArrayList<Integer>>(numplayers);
        System.out.println(" so far, nummatches : " + nummatches +
            "num players : " + numplayers);
             
        for (int i = 0; i < nummatches; i++) {  /** <=== the line loop! */
            int winnr = sc.nextInt();
            String op = sc.next();
            int winnee = sc.nextInt();
            
        }
        this.equalsRun(0, 5);
        this.equalsRun(0, 3);
        this.equalsRun(0, 4);
        
        for (int c : equals.get(4)) {
            System.out.println( " ==> " + c);
        }
        sc.close();
    }

    public boolean canExistAddWin() {
        return true;
    }
    
    public boolean canExistEquals() {
        return true;
    }
    
    /** Just adds 1 thing to the equals table for thing X.
     * 
     * End: X : 1. or X : 0, 4, 1.
     * 
     * @param winnr
     * @param winnee
     * @return
     */
    public boolean addEquals(int winnr, int winnee) {

        if (winnr == winnee) {
            return false;
        }
        if (equals.get(winnr) == null) {
            equals.put(winnr, new ArrayList<Integer>());
        }
        equals.get(winnr).add(winnee); /** <== weird that this works. you can add somethign toar eturned arraylist. cool. so it doesn't return a copy, it returns a thing you can add to. */
        // ArrayList<Integer> arrlist = equals.get(winnr);
        // arrlist.add(winnee);
        // equals.replace(winnr, arrlist);
        //System.out.println(" at index 0, size is is : " + equals.get(winnr).size() + " and 0 index is : " + equals.get(winnr).get(1));
        return true;
    }

    public boolean canAllowWin(int winnr, int winnee) {

        /** this might need to be recursive: i need to trace thru all of my winnee's
         * equal table for me. nevermind, can be not recursive cuz we add every single thing. so first:
         */
        if (equals.get(winnee).contains(winnr)) {  /** might be better to iteraet idk */
            return false;
        }

        /** check my winnee's wni atble, and all of its children for me. this part
         * might need to be recursive
         * 
         */

        return false;
    }

    public boolean recursiveAdd(int winnr, int winnee) {

        /** returns true IF FOUND IT !!!
         * 
         */
        /** starting with an index number as a winner and a number as a wninee, search thru
         * all of the WINNEE'S WIN TABLE, tracing thru all of it, to find me. if i'm not found,
         * return false
         * 
         */

         if (equals.get(winnee) == null) {
             return true;
         }  
         for (int x : equals.get(winnee)) {
             if (x == winnr) {
                 return true;
             }
             return this.recursiveAdd(winnr, x);
         }

    }

    public boolean addWin(int winnr, int winnee) {

        if (winnr == winnee) { 
            System.out.println( " !!!!!!!!!!!!!!!!!!!!! We erached the case wher winner == winnee in umm, in AddWin");
            return false;
        }
        if (win.get(winnr) == null) {
            win.put(winnr, new ArrayList<Integer>());
        }
        win.get(winnr).add(winnee);

        return true;
    }

    public void equalsRun(int winnr, int winnee) {       
        /** This passed the test. So, for me, add 5. THen, for all of my children,
         * add 5.
         * 
         */
        this.addEquals(winnr, winnee);
        this.addEquals(winnee, winnr);

        ArrayList<Integer> c = equals.get(winnr);

        for (int child : c) {
            if (child != winnr) {
            this.addEquals(child, winnee);
            this.addEquals(winnee, child);
            }
        }        
    } /** End equalsRun */

}

/** i thought about this in terms of:
 * a. keep a table
 * b. each table is 1 player
 * c. each table, as information of a match is gathered,
 *      canc ontain a value. it needs to be higher than player y,
 *      for example, if the player beat y. but if the current
 *      player also beat player c, d, e, and f, then we need to
 *      update c, d, e, and f because they are now definitely
 *      also higher than player y
 * d. i think about this as an array where multiple indexes
 * update bc they are "tied" to each other: like an event or a 
 * listener or something.
 * e. there is probably a much more efficient way to think about ti
 */
