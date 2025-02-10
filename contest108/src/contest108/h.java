/**
 * 
 */
package contest108;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class h {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        h h = new h();
    }
    
    public h() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] nArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            int curr = sc.nextInt();
            nArray[i] = curr;

            
        }        
        // for the array..

        // go through each item..
        
        // as long as it's not the size - 3
        
        // check this curr date, skip the next, then the return date
        
        // what's the max temperature during these times?
        int minMaxTemp = 500;
        int d = 0;

        for (int i = 0; i < (n - 2); i++) {

            int iHikeUp = nArray[i];
            int iHikeDown = nArray[i + 2];
            
            int currMaxTemp = 0;
            if (iHikeUp < iHikeDown) {
                currMaxTemp = iHikeDown;

            } 
            else if (iHikeDown < iHikeUp) {
                currMaxTemp = iHikeUp;

            }
            else {
                
                currMaxTemp = iHikeUp;
            }
            
            if (currMaxTemp < minMaxTemp) {

                minMaxTemp = currMaxTemp;
                d = i + 1;
                
            }
            
        }
        System.out.println(d + " " + minMaxTemp);
    }

}
