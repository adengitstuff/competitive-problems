
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author A
 *
 */
public class c {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    
    public static void main(String[] args) {
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        // fill/
        
        hm.put('a', 2);
        hm.put('b', 22);
        hm.put('c', 222);
        hm.put('d', 3);
        hm.put('e', 33);
        hm.put('f', 333);
        hm.put('g', 4);
        hm.put('h', 44);
        hm.put('i', 444);
        hm.put('j', 5);
        hm.put('k', 55);
        hm.put('l', 555);
        hm.put('m', 6);
        hm.put('n', 66);
        hm.put('o', 666);
        hm.put('p', 7);
        hm.put('q', 77);
        hm.put('r', 777);
        hm.put('s', 7777);
        hm.put('t', 8);
        hm.put('u', 88);
        hm.put('v', 888);
        hm.put('w', 9);
        hm.put('x', 99);
        hm.put('y', 999);
        hm.put('z', 9999);
        hm.put(' ', 0);
        // i actually just did that
        
        //File f = new File ("inputss.txt");
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        
        String curr = "x";
        
        for (int i = 0; i < n; i++) {
            // sc.next doesn't work here we need hte next line
            
            String s = sc.nextLine();
            //print Case #:
            System.out.println("Case #" + (i + 1) + ": ");
            char[] charArr = s.toCharArray();
            
            for (int z = 0; z < charArr.length; z++) {
                int num = hm.get(charArr[z]);
                
                //comparison:
                if (String.valueOf(num).contains(curr)) {
                    System.out.print(" ");
                }

                String x = String.valueOf(num);
                x = x.substring(0, 1);
                curr = x;
                
                
                System.out.print(hm.get(charArr[z]));
                
            }
            System.out.println("");
        }
        
        
    }

}
