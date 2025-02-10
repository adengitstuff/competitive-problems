/**
 * 
 */
package contest1022;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class a {

    /**
     * @param args
     */
    private boolean stopwatchOn;
    private int stopwatch = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        a a = new a();
    }
    
    public a() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if ((n % 2) != 0) {
            System.out.println("still running");
            System.exit(0);
        } else {
            // get values in pairs
            // just add the difference to the stopwatch
            
            for (int i = 0; i < (n / 2); i++) {
                // let's see if this works...
                int nstart = sc.nextInt();
                int nend = sc.nextInt();
                
                stopwatch = stopwatch + (nend - nstart);
            }
            
            System.out.println(stopwatch);
        }
    }

}
