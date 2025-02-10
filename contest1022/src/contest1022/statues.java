/**
 * 
 */
package contest1022;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class statues {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        statues stats = new statues();
    }
    
    public statues() {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = Integer.parseInt(s);
        
        if (n % 2 == 0) {
            System.out.println(n / 2);
        }
        else {
            System.out.println(n - 1);
        }
    }

}
