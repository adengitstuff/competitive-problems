/**
 * 
 */
package foosball;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class foosball {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    //PriorityQueue<String> prq;
    ArrayDeque<String> prq;
    int longeststreak;
    HashMap<String, Integer> hm;
    String[] white;
    String[] black;
    int whitecurrdynasty = 0;
    int blackcurrdynasty = 0;
    String winstringline;
    String whitelongest;
    String blacklongest;
    private boolean equal;
    int point = 0;
    public static void main(String[] args) throws FileNotFoundException {
        foosball fs = new foosball();
        // hmm...
    }
    
    public foosball() throws FileNotFoundException {
        //File f = new File("inputs.txt");
        Scanner sc = new Scanner(System.in);
        //prq = new PriorityQueue<String>(10);
        prq = new ArrayDeque<String>();
        hm = new HashMap<String, Integer>();
        longeststreak = 0;
        white = new String[2];
        black = new String[2];
        int nplayers = sc.nextInt();
        int c = 0; 
        white[0] = "*" + sc.next();
        black[0] = "*" + sc.next();
        white[1] = sc.next();
        black[1] = sc.next();
        prq.add(sc.next());
        prq.add(sc.next());
        // advance past newline character
        winstringline = sc.next();
//        System.out.println(winstringline);
//        System.out.println("White offense: " + white[0] + "White defense: " + white[1] +
//            "Black offense: " + black[0] + "Black defense ==> " + black[1]);

        char[] chararr = winstringline.toCharArray();
        
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i] == 'W') {
                this.whitepoint();
            }
            else if (chararr[i] == 'B') {
                this.blackpoint();
            }
            else {
                System.out.println("We reached else case in input, should"
                    + "never happen");
                System.exit(0);
            }
        }
        
        ArrayList<String> backwards = new ArrayList<String>();
        if (equal == true) {
            // print everything from the hashmap
            for (String s : hm.keySet()) {
                //System.out.println(s);
                backwards.add(s);
            }
            for (int i = backwards.size() - 1; i >= 0; i--) {
                String[] spl = backwards.get(i).split(" ");
                String first = "";
                String second = "";
                for (int z = 0; z < 2; z++) {
                    if (spl[z].startsWith("*")) {
                        first = spl[z];
                    }
                    else {
                        second = spl[z];
                    }
                }
                System.out.println(first.substring(1) + " " + second);
            }
        }
        else {
            // in theory the hm size should be 1
            for (String s : hm.keySet()) {
                String[] spl = s.split(" ");
                String first = "";
                String second = "";
                for (int z = 0; z < 2; z++) {
                    if (spl[z].startsWith("*")) {
                        first = spl[z];
                    }
                    else {
                        second = spl[z];
                    }
                }
                System.out.println(first.substring(1) + " " + second);
            }
        }
        
    }
    public void whitepoint() {
        //System.out.println("[Point " + point + "]");
        // a W means:
        
        // White stays the same
        // this dynasty number is incremented by +1
        whitecurrdynasty++;
        // this dynasty number is compared with the current longest
        if (whitecurrdynasty > longeststreak) {
            // this is the new biggest dnasty!
            whitelongest = white[0] + " " + white[1];
            //System.out.println("white curr dynasty is : " + whitecurrdynasty + " new white longest: " + whitelongest);
            equal = false;
            //System.out.println("hm before clearing, size: " + hm.size());
            //i forgot to do this:
            longeststreak = whitecurrdynasty;
            // clear everything frmo hashmah
            hm.clear();
            hm.put(whitelongest, whitecurrdynasty);
        }
        else if (whitecurrdynasty == longeststreak) {
            // if equal, they should remember it
            equal = true;
            // now put this also in the hashmap
            String whitestr = white[0] + " " + white[1];
            hm.put(whitestr, whitecurrdynasty);
        }
        else {
            
        }
        // case for if they're equal, and it's a different team: 
        
        
        // if it's equal or greater, than this is the new biggest dynasty
        // put that into the hashmap as a nwe ongest streak w their names
        
        // white offense becomes white defense ,and so on
        String temp = white[1];
        white[1] = white[0];
        white[0] = temp;
        // black is reshufled:
        
        // black defense joins the queue
                // remove * if it appears - this persno can never be first to the table or beat the next player
        String black1 = black[1];
        if (black1.startsWith("*")) {
            //System.out.println("Old black1: " + black1);
            black1 = black1.substring(1);
            //System.out.println("@@@@@@ new black1: " + black1);
        }
        prq.add(black1);
        // blac koffense is now black defense
        
            // re-edited later: but add the *, he is now first to table
            String newblack0;
            if (! (black[0].startsWith("*"))) {
                newblack0 = "*" + black[0];
            }
            else {
                newblack0 = black[0];
            }
        black[1] = newblack0;
        // black's offense becomes prq
        //System.out.println("let's peek =>" + prq.peek());
        black[0] = prq.poll();
        
        // we never reset other etam's dynasty
        blackcurrdynasty = 0;
        point++;
    }
    
    public void blackpoint() {
        //System.out.println("[Point " + point + "]");
        blackcurrdynasty++;
        
        if (blackcurrdynasty > longeststreak) {
            blacklongest = black[0] + " " + black[1];
            //System.out.println("new black longest: " + blacklongest);
            
            // forgot:
            longeststreak = blackcurrdynasty;
            // hashmap
            hm.clear();
            hm.put(blacklongest, blackcurrdynasty);
            equal = false;
        }
        else if (blackcurrdynasty == longeststreak) {            
            String blackstr = black[0] + " " + black[1];
            equal = true;
            hm.put(blackstr, whitecurrdynasty);
        }
        else {
            
        }
        String temp = black[1];
        black[1] = black[0];
        black[0] = temp;
        
        // white is reshuffled:
        
        //white defense joins the queue:
        
            // re-edited: remove the leading star
        String white1 = white[1];
        if (white1.startsWith("*")) { 
            white1 = white1.substring(1);
        }
        prq.add(white1);
        // white defense is now white offense
            String newwhite0;
            if (! (white[0].startsWith("*"))) {
                newwhite0 = "*" + white[0];
            }else {
                newwhite0 = white[0];
            }
        white[1] = newwhite0;
        // white offnese is pulled from queue
        white[0] = prq.poll();
        
        whitecurrdynasty = 0;
        
        point++;
    }
}
