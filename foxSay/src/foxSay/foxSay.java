/**
 * 
 */
package foxSay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * rip just realized it's smarter to go thru the first
 * string and just remove stuff
 * 
 * @author A
 *
 */
public class foxSay {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    HashMap<String, String> mp;
    String mainline;
    int numCases;
    public static void main(String[] args) throws FileNotFoundException {
        
        foxSay fox = new foxSay();
    }
    
    public foxSay() throws FileNotFoundException {
        File file = new File("ee.txt");
        Scanner sc = new Scanner(file);
        
        if (sc.hasNextInt()) {
        this.numCases = sc.nextInt();
        }
        if (sc.hasNextLine()) {
        sc.nextLine();  // ahhhh the newline character counts as a whole line like
                        // professor said. who  designed his
        }
        
        // if numcases 0?
        mp = new HashMap<String, String>();
        if (sc.hasNextLine()) {
        mainline = sc.nextLine();       
        }
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.contains("what")) {
               this.retString();                 
               sc.next();
               sc.next();
               sc.next();
               sc.next();
               if (sc.hasNextLine()) {
                   String ss = sc.next();
                   mainline = ss + sc.nextLine();
                   if (sc.hasNext()) {  // \n character
                   sc.next();
                   }
               }
               mp.clear();
               
            }
            // else?
            if (sc.hasNext()) {
                sc.next();
            }
            if (sc.hasNext()) {
                // map it here, we are at "woof" for example
                mp.put(sc.next(), "1");

            }
            
        }
        sc.close();
    }
    
    public void retString() {
        Scanner xs = new Scanner(mainline);
        while (xs.hasNext()) {
            String cc = xs.next();
            if (mp.get(cc) == null) {
                System.out.print(cc + " ");
            }

        }
        System.out.println("");
        xs.close();
        
    }
    
    public void showTable() {
        for (String k : mp.keySet()) {
            System.out.println(k);
        }
    }
    
    

}
