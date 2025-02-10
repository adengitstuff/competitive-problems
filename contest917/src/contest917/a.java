/**
 * 
 */
package contest917;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class a {

    /**
     * @param args
     */
    public static void main(String[] args) {
        a ayo = new a();
    }
    
    public a() {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (a < b && a < c) {
            if (b < c) {
                
            } else {
                int temp = b;
                b = c;
                c = temp;
            }
        }
        else if (b < a && b < c) {
            if (a < c) {
                int temp = a;
                a = b;
                b = temp;
            } else {
                int temp = a;
                a = b;
                b = c;
                c = temp;
            }
        }
        else if (c < a && c < b){
            if (a < b) {
                int temp = a;
                int tempb = b;
                a = c;
                c = b;
                b = temp;
                //c = tempb;
            }
            else {
                int temp = a;
                a = c;
                c = temp;
            }
        }
        
        sc.nextLine();
        String s = sc.nextLine();
        char[] chrs = s.toCharArray();
        
        for (int i = 0; i < 3; i++) {
            if (i == 1 || i == 2) {
                System.out.print(" ");
            }
            if (chrs[i] == 'A') {
                System.out.print(a);
            }
            else if (chrs[i] == 'B') {
                System.out.print(b);
            }
            else if (chrs[i] == 'C') {
                System.out.print(c);
            }
        }
        
    }

}
