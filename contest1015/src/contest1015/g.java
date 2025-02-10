/**
 * 
 */
package contest1015;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class g {

    /**
     * @param args
     */
    ArrayList<Integer> totalarr;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        g g = new g();
    }

    public g() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int m = sc.nextInt();
        
        totalarr = new ArrayList<Integer>();
        
        // fill the rankings total array with initial rankings,
        // to check index
        
        for (int i = 1; i < (n + 1); i++) {
            totalarr.add(i);
        }
        
        // now go thru matches
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String sline = sc.nextLine();
            // get the ints
            String[] teamarr = sline.split(" ");
            int win = Integer.valueOf(teamarr[0].substring(1));
            int lost = Integer.valueOf(teamarr[1].substring(1));
            
            if (totalarr.indexOf(win) > totalarr.indexOf(lost)) {
                // if index is greater, then the team that won
                // is lower in ranking. so something needs to change
                
                this.reorder(win, lost);
            }
        }
        
        this.print();
    }
    
    public void reorder(int wins, int lost) {
         ArrayList<Integer> newarr = new ArrayList<Integer>();
         
         for (int n : totalarr) {
             if (n == wins) {
                newarr.add(n);
                newarr.add(lost);
             }
             else if (n == lost) {
                 
             } else {
                newarr.add(n);
             }
         }
         
         totalarr = newarr;
         
    }
    
    public void print() {
        for (int n : totalarr) {
            System.out.print("T" + n + " ");
        }
    }
}
