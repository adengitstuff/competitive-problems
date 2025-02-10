/**
 * 
 */
package stampies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class stampies {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        stampies stampies = new stampies();
    }
    
    public stampies() throws FileNotFoundException {
        //File f = new File("input.txt");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int queries = sc.nextInt();
        sc.nextLine(); // hope this doesn't suck
        String lin = sc.nextLine();
        int[] intarr = new int[num];
        int tot = 0;
        
        String[] spl = lin.split(" ");
        for (int i = 0; i < num; i++) {
            // wrong loop - thank God! thought the program was bad
            intarr[i] = Integer.valueOf(spl[i]);
            //System.out.println(intarr[i] + "*");
            tot = tot + intarr[i];
            //System.out.println("thet otal max is : " + tot);
        }
        
        // go forward, adding every number to each otehr
        
        int total = 0 ;
        int numadded = 0;
        int[] plusbranch = new int[intarr.length];
        for (int i = 0; i < intarr.length; i++) {
            //System.out.println("on intarr[" + i + "] == " + intarr[i]);
            //System.out.println("Total is " + total);
            int toadd = intarr[i] + total; // starts with 2 + 0
            numadded++;
            // need to add if less thant otal max
            this.tableput(toadd, numadded);  // <== changed from just table.put(toadd, true);
            total = toadd; 
            //System.out.println("Added ==> " + toadd + " to table!" );
            
            plusbranch[i] = toadd;
        }
        
        int[] negbranch = new int[intarr.length];
        int negtotal = 0;
        int negadded = 0;
        for (int z = num - 1; z >= 0; z--) { // z > 0?
            //System.out.println("intarr[z] for " + z + " is ==> " + intarr[z]);

            int toadd = intarr[z] + negtotal;
            //System.out.println("to add is now.. " + toadd);
            negadded++;
            this.tableput(toadd, negadded);
            negtotal = toadd;
            //System.out.println("From negative branch, added ==> " + toadd);
            negbranch[z] = toadd;
        }
        
        /** none of these numbers can be greater than 17, the total.
         * now add all of them from each branch together, ignoring values that are > the total max
         */
        /** Double-check values of plus branch..*/
        
//        for (int i = 0; i < plusbranch.length; i++) {
//            System.out.println("+ " + plusbranch[i]);
//        }
//        
        //
        
        // plus and neg check
        
        for (int i = 0; i < plusbranch.length; i++) {
            for (int z = 0; z < negbranch.length; z++) {
                int toadd = plusbranch[i] + negbranch[z];
                if (toadd <= tot) {
                    // get queries
                    //System.out.println("Looking for pos " + plusbranch[i] + " and neg " + negbranch[z]);
                    int plusq = table.get(plusbranch[i]);
                    int negq = table.get(negbranch[z]);
                    if (table.get(toadd) == null) {
                        table.put(toadd, (plusq + negq));
                    } else {
//                        System.out.println("Repeated value in branch"
//                            + "merging...");
                        // in this case you can keep he lower one
                    }
                }
            }
        }
        
        
        // now line scan part
        // for each cluster..
        
        // 2 8 1 3 3
        
        // 2 = 2
            // 2 + 3 = 5
            // 2  + 3 + 3 = 8
            // 2 + 3 + 3 + 1 + 9
            // 2 + 3 + 3 + 1 + 8 = 17
        // 2 + 8 = 10
            // 10 + 3 = 13
            // 10 + 3 + 3 = 16
            // 10 + 3 + 3 + 1 = 17
        // 2 + 8 + 1 = 11
            // 11 + 3 = 14
            // 11 + 3 + 3 = 17
        
        /* now line scan part.. */
        
        for (int i = 0; i < queries; i++) {
            int toCheck = sc.nextInt();

            if (toCheck == 0) {
                System.out.println("No");
            } else {
                if (table.get(toCheck) == null || toCheck > tot) {
                    System.out.println("No");
                } else if (table.get(toCheck) != null || toCheck == 0) {
                    // it's in, so check if it's within queries
                    System.out.println("Yes");
    
                }
            }
        }
        
        this.printkeys();
    }
    
    public void printkeys() {
        for (int c : table.keySet()) {
            System.out.println("key => " + c);
        }
    }
    public void tableput(int n, int q) {
        if (table.get(n) == null) {
            table.put(n, q);
        }
    }

}
