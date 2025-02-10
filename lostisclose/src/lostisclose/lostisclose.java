/**
 * 
 */
package lostisclose;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author A
 *
 */
public class lostisclose {

    private HashMap<Integer, String> totalswords;
    private HashMap<Character, Integer> chartable;
    private HashMap<Integer, ArrayList<Integer>> totalsinput;
    public static void main(String[] args) throws FileNotFoundException {
        lostisclose lost = new lostisclose();

    }
    
    public lostisclose() throws FileNotFoundException {
        File f = new File("inputs.txt");
        Scanner sc = new Scanner(f);
        chartable = new HashMap<Character, Integer>();
        totalswords = new HashMap<Integer, String>();
        totalsinput = new HashMap<Integer, ArrayList<Integer>>();
        this.fillCharTable();
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.contentEquals("***")) {
                sc.close();
                break;
            }
            this.parseNext(s);
        }
        
        // all words parsed, try delete check
        this.deleteCheck();       
        this.replaceCheck();
    }
    
    public void replaceCheck() {
        for (int totals : totalsinput.keySet()) { /** !!!!---- change to iterate over valeus ---*/
            // replace each letter with another letter and try to get it from the totals table
            ArrayList<Integer> arr = totalsinput.get(totals);
            
            for (int alpha : arr) {
                int total = totals - alpha;
                for (int i = 1; i < 27; i++) {
                     int totalcheck = total + i;
                     
                     if (totalswords.get(totalcheck) == null) {
                         // good, null acse
                     }
                     else {
                         String main = totalswords.get(totals);
                         String replc = totalswords.get(totalcheck);
                         if (replc.contentEquals(main) || replc.length() != main.length() ||( (main.charAt(0) != replc.charAt(0) || main.charAt(main.length() - 1) != replc.charAt(replc.length() - 1)))) {
                             System.out.println("lmao");
                             break;
                         }
                         else if (main.charAt(0) == replc.charAt(0) || main.charAt(main.length() - 1) == replc.charAt(replc.length() - 1));
                         System.out.println(" !!!!!!!!!!!!!!!!!!! ********************************* !!!!");
                         System.out.println(" Found a replacement! Wow");
                         System.out.println(" ====================================================");
                         System.out.println(" Main word is ====> " + totalswords.get(totals));
                         System.out.println(" Replacement character word is : " + totalswords.get(totalcheck));
                     }
                }
            }
        }
    }

    public void deleteCheck() {
        for (int key : totalsinput.keySet()) {
            // if deleting a character equals any other word in this input, store that
            // if this total - any of its summing totals is a number that is not null when retrieved from totals
            int total = key;
            ArrayList<Integer> vals = totalsinput.get(key);
            for (int i = 0; i < vals.size(); i++) {
                if (totalswords.get(total - vals.get(i)) == null) {
                }
                else {
                    // the totals match but they can be, like, "strike" and "clock"
                    //if (totalswords.get(total - vals.get(i)).length() == totalswords.get(total).length() - 1) {
                    String tot = totalswords.get(total);
                    String comp = totalswords.get(total - vals.get(i));
                    // either last index or first index have to be the same.. 
                    if (tot.charAt(0) == comp.charAt(0) || tot.charAt(tot.length() - 1) == comp.charAt(comp.length() - 1)) {
                    System.out.println("@@@@@@@@ deletnig a character here can equal another word!!");
                    System.out.println("Main word is : " + totalswords.get(total));
                    System.out.println("taht word is : ");
                    System.out.println(" ==> " + totalswords.get(total - vals.get(i)) + "<===");
                    }
                }
            }
        }
    }
    
    public void parseNext(String line) {
        // take each line
        // extract each word (remove "", ?, ., ,, ;", etc.)
                        // maybe use regex of alphabet?
        // lowercase, core etc
        String str = line.replaceAll("[^a-zA-Z]", ""); // ***** changed from [^a-zA-Z0-9], somehow ignores null cases idk
        str = str.toLowerCase();
        System.out.println(str + " : ");
        char[] chr = str.toCharArray();
        int total = 0;
        
        // total part
        
        // arraylist part
        
        ArrayList<Integer> totalsum = new ArrayList<Integer>();
        
        for (int i = 0; i < chr.length; i++) {
            int charint = chartable.get(chr[i]);
            total = total + charint; // yes
            totalsum.add(charint);            
        }
        totalswords.put(total, str);
        totalsinput.put(total, totalsum);
        System.out.println(str + " ===> " + total);
        
    }
//    
//    public void insertCheck() {
//        for (int key : totalswords.keySet()) {
//           for (int i = 1; i < 27; i++) {
//               // 27 * # keys check. so.. hm
//               if (totalswords.get(key + i) == null) {
//                   // we didn't get anything
//               }
//               else {
//                   // checks for front and back index, 1 of them must be the same
//                   String cs = totalswords.get(key);
//                   String x = totalswords.get(key + i);
//                   System.out.println(" cs: " + cs + " x : " + x);
////                   if (cs.charAt(0) == x.charAt(0) || cs.charAt(cs.length() - 1) == x.charAt(x.length() - 1)) {
////                       System.out.println(" ===+!!!!!!!!!!!!!!!!!!!!!!!=== found one!!!!!!" + cs + "   ====> " + x);
////                       System.out.println("wait, isn't this the same thing as delete...???");
////                   }
//               }
//           }
//        }
//    }
    
    
    public void fillCharTable() {
        chartable.put('a', 1 );
        chartable.put('b', 2);
        chartable.put('c', 3);
        chartable.put('d', 4);
        chartable.put('e', 5);
        chartable.put('f', 6);
        chartable.put('g', 7);
        chartable.put('h', 8);
        chartable.put('i', 9);
        chartable.put('j', 10);
        chartable.put('k', 11);
        chartable.put('l', 12);
        chartable.put('m', 13);
        chartable.put('n', 14);
        chartable.put('o', 15);
        chartable.put('p', 16);
        chartable.put('q', 17);
        chartable.put('r', 18);
        chartable.put('s', 19);
        chartable.put('t', 20);
        chartable.put('u', 21);
        chartable.put('v', 22);
        chartable.put('w', 23);
        chartable.put('x', 24);
        chartable.put('y', 25);
        chartable.put('z', 26);        
    }
    
    

}
