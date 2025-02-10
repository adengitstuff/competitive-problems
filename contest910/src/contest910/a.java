/**
 * 
 */
package contest910;

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
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        
        int inp1 = sc.nextInt();
        int inp2 = sc.nextInt();
        if (inp1 == inp2) {
            System.out.println("0");
            System.exit(0);
        }
        
        int num1 = inp1;
        int currentC = num1;
        int num2 = inp2;
        
        int clockwiseCount = 0;
        int counterCount = 0;
        boolean usePositive = true;
                        /** Try new block: */
        
            if (inp1 < 180 && (inp2 > inp1 && inp2 < 360 && (inp2 - inp1 <= 180))) {
                System.out.println(inp2 - inp1);
            }
            else if (inp1 >= 180 && (inp2 > 180 && inp2 < 360)) {
                // use positive
                System.out.println(inp2 - inp1);
            }
            else if (inp1 >= 180 && ( (inp1 + 180 - 360) > inp2) ) {
                System.out.println( (360 - inp1) + inp2);
            } else {
                if (inp1 > 180) {
                    if ( (inp1 - inp2 == 180) ) {
                        System.out.println("180");
                        System.exit(0);
                    }
                    System.out.println("-" + (inp1 - inp2));
                }
                else {
                    if (inp1 > inp2) {
                        //inp1 is greater than inp2 if inp1 is like 90 and inp2 is like 35. but if inp2 is 
                                //275 this isn't true
                        if ( (inp1 - inp2 == 180) ) {
                            System.out.println("180");
                            System.exit(0);
                        }
                        System.out.println("-" + (inp1 - inp2));
                    }
                    else {
                        // so here inp1 is less than or equal to 180, and inp2 is greater?? this could be
                                // 20, and inp2 could be 355 idk.this must cross 0. 
                        if ( (inp1 - inp2 == 180) ) {
                            System.out.println("180");
                            System.exit(0);
                        }
                        System.out.println("-" + ((inp1) + (360 - inp2)));
                    }
                }
            }
        
        // just run 2 while loops and return 
        // the lower value. if equal, return positive
        // (i think this only happens if 180)
        
        /** Clockwise loop:*/
//        while (currentC != num2) {
//            clockwiseCount++;
//            currentC++;
//            if (currentC == 360 && inp2 != 0) {
//                currentC = 0;
//            }
//            
//        }
            //System.out.println("Clockwise loop returns => " + clockwiseCount);
            
            /** Try new block:*/
//            if (clockwiseCount > 180) {
//                System.out.println("-" + ((num1) + (360 - inp2)));
//            }
//            else {
//                System.out.print(clockwiseCount);
//            }
            
//        currentC = inp1;
//        if (inp1 == 0) {
//            currentC = 360;
//        }
//        while (currentC != num2) {
//            counterCount++;
//            currentC--;
//            
//            System.out.print("==> " + currentC);
//            if (currentC == 0 && inp2 != 0) {
//                currentC = 360;
//            }
//        }
        
            //System.out.println("Counterclockwise loop returns => " + counterCount);
        
//        if (clockwiseCount <= counterCount) {
//            System.out.println(clockwiseCount);
//        } else {
//            System.out.println("-" + counterCount);
//        }
    }

}
