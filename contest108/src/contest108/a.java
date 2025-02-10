/**
 * 
 */
package contest108;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class a {

    /**
     * @param args
     */
    HashMap<String, ArrayList<String>> ht = new HashMap<String, ArrayList<String>>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        a a = new a();
    }

    public a() {
        Scanner sc = new Scanner(System.in);
        
        String lastWord = sc.next();
        String letterToFind = lastWord.substring(lastWord.length() - 1);
        //System.out.println(lastWord);
        
        int nInt = sc.nextInt();
        //System.out.println(nInt);
        
        for (int i = 0; i < nInt; i++) {
            String word = sc.next();
            
            String firstletter = word.substring(0, 1);
            
            String lastletter = word.substring(word.length() - 1);
            
            if (ht.get(firstletter) == null) {
                ArrayList<String> arrlist = new ArrayList<String>();
                arrlist.add(word);
                ht.put(firstletter, arrlist);
            } else {
                ht.get(firstletter).add(word);
            }
        }
        
        // find operation
        if (ht.get(letterToFind) == null) {
            System.out.println("?");
        }
        else {
            // go thru to find an elimination point
            for (String k : ht.get(letterToFind)) {
                // check if eliminates next player
                String ll = k.substring(k.length() - 1);
                if (ht.get(ll) == null || ht.get(ll).size() == 1 && ht.get(ll).contains(k)) {
                    //works!
                    System.out.println(k + "!");
                    System.exit(0);
                }
            }
            
            // then we've iterated thru each one and can't find an elimination thing
            
            System.out.println(ht.get(letterToFind).get(0));
        }
        
        
       
        
    }
}
