/**
 * 
 */
package tecque;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class Tecque {
    
    ArrayDeque<Integer> d;
    ArrayDeque<Integer> d2;
    int totalSize = 0; 
    public static void main(String args[]) throws FileNotFoundException {
        
//        File f = new File("inputz.txt");
//        Scanner sc = new Scanner(f);
        Tecque tc = new Tecque();
        //int numCommands = sc.nextInt();
        
//        while (sc.hasNextLine()) {
//            tc.parse(sc.nextLine());
//        }
        tc.parse("push_front 5");
        tc.parse("push_back 7");
        tc.parse("push_mid 0");
        //System.out.println("d front" + tc.d().getFirst() + " d2 front: " + tc.d2().getFirst());
        tc.parse("get 1");
        
    }
    
    public ArrayDeque<Integer> d() {
        return d;
    }
    
    public ArrayDeque<Integer> d2() {
        return d2;
    }
    public void parse(String line) {
        String[] sr = line.split(" ");
        if (line.contains("push_back")) {
            // we want to push to the back of the array so..
            
            // find imbalance
            // case 1: [] []    [] 
            int n = this.balenciagaFind(); 
            if (n == 1 || n == 0) {
                // if they're equal or if d1 is bigger, just add normally.
                d2.addLast(Integer.valueOf(sr[1]));
                totalSize++;
            }
            else {
                // d2 is bigger
                d.addLast(d2.getFirst());
                d2.removeFirst();
                d2.addLast(Integer.valueOf(sr[1]));
                totalSize++;
            }
        }
        
        if (line.contains("push_front")) {
            int c = this.balenciagaFind();
            
            if (c == 2 || c == 0) {
                // theyre equal or 2 is bigger
                d.addFirst(Integer.valueOf(sr[1]));
                totalSize++;
            }
            else {
                // d is bigger, it would be more imbalanced if we add this
                d2.addFirst(d.getLast());
                d.removeLast();
                d.addFirst(Integer.valueOf(sr[1]));
                totalSize++;
                
                // assert thed ifference is less than 2
            }
        }
        
        if (line.contains("push_middle")) {
            int x = this.balenciagaFind();
            
            if (x == 0 || x == 2) {
                // they're equal, or 2 is bigger
                d.addLast(Integer.valueOf(sr[1]));
                totalSize++;
            }
            else {
                // 1 is bgiger, so..
                d2.addFirst(Integer.valueOf(sr[1]));
                totalSize++;
            }
        }
        if (line.contains("get")) {
            int z = Integer.valueOf(sr[1]);
            Iterator<Integer> coll;
            
            /** if index > d size, then we only need the right half of the array
             *  
             */
            if (z >= d.size()) {
                
                if (z > (d2.size() >> one) ) {
                    //right half of right array, so return backwards 
                    coll = d2.descendingIterator();
                }
                else {
                    coll = d2.iterator();
                }
            }
            else {
                // z is in left deque
                if (z > (d.size() / 2)) {
                    coll = d.descendingIterator();
                }
                else {
                    coll = d.iterator();
                }
            }
            
            // loop through
            Iterator<Integer> done = d.iterator();
            Iterator<Integer> dtwo = d2.iterator();
            
            
            System.out.println(" coll to string is : " + coll.toString());
            for (int i = 0; i < z; i++) {
                Integer c = coll.next();
                System.out.print(" => " + c);
            }
            
            System.out.println(" Entire d1 is : ");
            
        }
    }
    
    public Tecque() {
        d = new ArrayDeque<Integer>();
        d2 = new ArrayDeque<Integer>();
        
        
    }
    
    public int balenciagaFind() {
        if (d2.size() > d.size()) {
            /** problems/debugging: if arrays are all same size by default at initialization*/
            return 2;
        }
        else if (d.size() > d2.size()) {
            return 1;
        }
        else {
            // equal case
            return 0;
        }
    }
    
    public void balenciaga() {
        
    }

}
