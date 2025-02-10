/**
 * 
 */
package contest1015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class e {

    /**
     * @param args
     */
    HashMap<String, Integer> t = new HashMap<String, Integer>();
    HashMap<Integer, String> t2 = new HashMap<Integer, String>();
    int[][] narr;
    ArrayList<ArrayList<Integer>> arrlist;
    int totalN;
    int numphr;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        e e = new e();
    }
    
    public e() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       
        totalN = n;
        narr = new int[n][n];
        
        // index part:
        for (int i = 0; i < n; i++) {
            for (int z = 0; z < n; z++) {               
                int curr = sc.nextInt();              
                narr[i][z] = curr;              
            }
        }
        sc.nextLine(); // need this.. eyeroll
        String phr = sc.nextLine();
        numphr = phr.length();
        this.printIndex();
        this.tFill();
        int[] numphrase = new int[phr.length()];
        
        for (int i = 0; i < phr.length(); i++) {
            char c = phr.charAt(i);
            String cstring = String.valueOf(c);            
            numphrase[i] = t.get(cstring);
           
        }
        
        int nvectors = 0;
        
        if ( (numphrase.length % n) == 0) {
            // we have a perfectly even num of 
                nvectors = numphrase.length / n;
        } else {
            nvectors = (numphrase.length / n) + 1;
        }
        
        arrlist = new ArrayList<ArrayList<Integer>>();
        
        int indx = 0;
        for (int i = 0; i < nvectors; i++) {
            ArrayList<Integer> ncurr = new ArrayList<Integer>();
            
            for (int z = 0; z < n; z++) {
                if (indx < numphrase.length) {
                    ncurr.add(numphrase[indx]);  // ???
                    //System.out.println("Added " + numphrase[indx] + "to group " + i);
                    indx++;
                    
                }
                else {
                    ncurr.add(36);
                    //System.out.println("Added a space of padding to group " + i);
                }
                
                
            }
            arrlist.add(ncurr);
            
        }
        this.transform();
         
    }
    
    public void transform() {
        // each row of the nmatrix is multiplied by each value of the group.
        
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        
        // for each grouping, multiply each number in it by the right
        // row in the array. replace the values in the grouping with the new values
        
        for (ArrayList<Integer> arrie : arrlist) {
            int nrow = 0;
            
            // the right reasoning is: for the rows in the array, lol
            
            for (int i = 0; i < totalN; i++) {
                
                // for the rows in the array, multiply across by each number in 
                    // the current arraylist.
                int rowtotal = 0;
                
                for (int z = 0; z < totalN; z++) {
                    //multiply by arrie.get(z)?
                    
                    int currn = narr[i][z] * arrie.get(z);
                    rowtotal = rowtotal + currn;
                    
                }
                
                //row total is the new number
                arrie.add(rowtotal % 37); // lmaooo
            }
        }
        
        // now return:
        ArrayList<Integer> newphrase = new ArrayList<Integer>();
        for (ArrayList<Integer> arrie : arrlist) {
            for (int i = totalN; i < arrie.size(); i++) {
                newphrase.add(arrie.get(i));
            }
        }
        
        for (int c : newphrase) {
            System.out.print(t2.get(c));
        }
    }
    
    
    
    public void tFill() {
        t.put("A", 0);
        t.put("B", 1);
        t.put("C", 2);
        t.put("D", 3);
        t.put("E", 4);
        t.put("F", 5);
        t.put("G", 6);
        t.put("H", 7);
        t.put("I", 8);
        t.put("J", 9);
        t.put("K", 10);
        t.put("L", 11);
        t.put("M", 12);
        t.put("N", 13);
        t.put("O", 14);
        t.put("P", 15);
        t.put("Q", 16);
        t.put("R", 17);
        t.put("S", 18);
        t.put("T", 19);
        t.put("U", 20);
        t.put("V", 21);
        t.put("W", 22);
        t.put("X", 23);
        t.put("Y", 24);
        t.put("Z", 25);
        t.put("0", 26);
        t.put("1", 27);
        t.put("2", 28);
        t.put("3", 29);
        t.put("4", 30);
        t.put("5", 31);
        t.put("6", 32);
        t.put("7", 33);
        t.put("8", 34);
        t.put("9", 35);
        t.put(" ", 36);
        
        t2.put(0, "A");
        t2.put(1, "B");
        t2.put(2, "C");
        t2.put(3, "D");
        t2.put(4, "E");
        t2.put(5, "F");
        t2.put(6, "G");
        t2.put(7, "H");
        t2.put(8, "I");
        t2.put(9, "J");
        t2.put(10, "K");
        t2.put(11, "L");
        t2.put(12, "M");
        t2.put(13, "N");
        t2.put(14, "O");
        t2.put(15, "P");
        t2.put(16, "Q");
        t2.put(17, "R");
        t2.put(18, "S");
        t2.put(19, "T");
        t2.put(20, "U");
        t2.put(21, "V");
        t2.put(22, "W");
        t2.put(23, "X");
        t2.put(24, "Y");
        t2.put(25, "Z");
        t2.put(26, "0");
        t2.put(27, "1");
        t2.put(28, "2");
        t2.put(29, "3");
        t2.put(30, "4");
        t2.put(31, "5");
        t2.put(32, "6");
        t2.put(33, "7");
        t2.put(34, "8");
        t2.put(35, "9");
        t2.put(36, " ");
    }
    
    
    
    public void printIndex() {
        for (int i = 0; i < narr.length; i++) {
            for (int z = 0; z < narr.length; z++) {
                //System.out.print("[" + i + ", " + z + "]: " + narr[i][z] + "    ");
            }
            
            //System.out.println();
        }
    }

}
