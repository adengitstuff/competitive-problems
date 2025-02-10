/**
 * 
 */
package contest917;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class c {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        c cheats = new c();
    }
    
    public c() {
        Scanner sc = new Scanner(System.in);
        
        int currNum = 11;
        
        int lowerBound = 0;
        int upperBound = 11;
        while (currNum != 0) {
            currNum = sc.nextInt();
            String response = sc.nextLine();
            if (response.contentEquals("too high")) {
                upperBound = currNum;
            }
            else if (response.contentEquals("too low")) {
                
            }
            else if (response.contentEquals("right on")) {
                
            }
        }
    }

}
