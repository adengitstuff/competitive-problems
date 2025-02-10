/**
 * 
 */
package contest108;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class a2 {

    /**
     * @param args
     */
    HashMap<String, HashMap<String, String>> ht = new HashMap<String, HashMap<String, String>>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        a2 a = new a2();
    }
    
    public a2() {
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
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put(lastletter, word);
                ht.put(firstletter, hm);
            }
            else {
                ht.get(firstletter).put(lastletter, word);
            }
        }
        
        // maintain a list of letters that don't.. or idk
        
        if (ht.get(letterToFind) == null) {
            System.out.println("?");
        } else {
            
            // iterate thru the keyset. 
            // if you find "t" index in hm, 
                // and that index in ht is null, then that's the winner
            
            for (String k : ht.get(letterToFind).keySet()) {
                if (ht.get(k) == null) {
                    // we have a winner
                    System.out.println(ht.get(letterToFind).get(k) + "!");
                }
            }
            // if we reached here, we didn't find a null entry. so pick the first one
            
            
        }
    }

}
