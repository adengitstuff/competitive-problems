/**
 * 
 */
package integerDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class integerDivision {

    /**
     * @param args
     */
    int totalNum;
    int division;
    //HashMap<Integer, ArrayList<Integer>> ht;
    int[] totalArray;
    int highestnum = 0;
    public static void main(String[] args) throws FileNotFoundException {
        integerDivision in = new integerDivision();
    }
    
    public integerDivision() throws FileNotFoundException {
           // ht = new HashMap<Integer, ArrayList<Integer>>();
            
            //File f = new File("inputsyo.txt");
             Scanner sx = new Scanner(System.in);
            totalNum = sx.nextInt();
            division = sx.nextInt();
            
            totalArray = new int[200001];
            int totalCountX = 0;
            for (int z = 0; z < 200001; z++) {
                totalArray[z] = 0;
            }
            for (int i = 0; i < totalNum; i++) {
                int cnum = sx.nextInt();
                if (cnum > highestnum) {
                    highestnum = cnum;
                }
                // totalArray[cnum] = totalArray[cnum] + 1;
                int ctotal = totalArray[cnum];
                totalArray[cnum] = ctotal + 1;
                
            }
           
            int localTotal = 0;
            for (int i = 0; i < 200001; i = i + division) {
                if (i + division > 200000) {
                    // we're at the last possible division step, right?
                    int finalbucket = 0;
                    for (int z = i; z < 200001; z++) {
                        int xy = totalArray[z];
                        finalbucket = finalbucket + xy;
                        int finalncr = this.smartFactorial(finalbucket);
                        totalCountX = totalCountX + finalncr;
                        System.out.println(totalCountX);
                    }
                    
                    
                }
                
                for (int z = 0; z < division; z++) {
                    int c = totalArray[i + z];
                    localTotal = localTotal + c;                    
                }
                int totalCx = this.smartFactorial(localTotal);
                totalCountX = totalCountX + totalCx;
            }
            sx.close();
            //System.out.println(totalCountX);
            
            /**
             * 
             */
            
//            // go thru input and divide, each new divisor is a new entry in the hash table?
//            for (int i = 0; i < totalNum; i++) {
//                /*  !!! just declaring everything as a variable for easier debugging*/
//                int cnum = sx.nextInt();
//
//                int rightNum = Math.floorDiv(cnum, division);
//                                
//                if (ht.get(rightNum) == null) {
//                    ArrayList<Integer> arr = new ArrayList<Integer>();
//                    arr.add(cnum);
//                    ht.put(rightNum, arr);
//                }
//                else {
//                    // we have a divisor! so just push
//                    this.push(rightNum, cnum);
//                }
//            }
//           
//            System.out.println(this.finalTotal());
            
    } 
    
    public int smartFactorial(int n) {
        return ( (n * (n-1)) / 2);
    }
    
//    public int finalTotal() {
//        int totalCount = 0;
//        for (int divisor : ht.keySet()) {
//            // get the total number of objects in the arraylist?
//            int sz = ht.get(divisor).size(); // might be + or - 1?
//            totalCount = totalCount + this.smartFactorial(sz);
//        }
//        return totalCount;
//    }
//    
//    public void push(int htindex, int c) { 
//        if (ht.get(htindex) == null) {
//            ArrayList<Integer> arrc = new ArrayList<Integer>();
//            arrc.add(c);
//            ht.put(htindex, arrc);
//        }        
//        else {
//        ArrayList<Integer> arrx = ht.get(htindex);
//        arrx.add(c);
//        }
//    }
    
//    public int cDivide(int c, int divisor) {
//        return Math.floorDiv(c, divisor);
//    }
//    

}