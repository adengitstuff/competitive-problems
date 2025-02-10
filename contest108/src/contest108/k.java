/**
 * 
 */
package contest108;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class k {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        k k = new k();
    }

    public k() {
        Scanner sc = new Scanner(System.in);
        
        int newBottles = sc.nextInt();
        
        int students = sc.nextInt();
        
        int slots = sc.nextInt();
        
        int d = sc.nextInt();
        System.out.println("D:  " + d);
        int[] sodas = new int[slots];
        
        int[] reverseSodas = new int[slots];
        int totalCold = 0;
        for (int i = 0; i < slots; i++) {
            sodas[i] = sc.nextInt();
            // total
            totalCold = totalCold + sodas[i];
        }
        
        // decrement, each time putting as many in the
        // ..
        if (totalCold < students) {
            System.out.println("impossible");
            System.exit(0);
        }
        // if num cold bottles..
        
        
    }
}
