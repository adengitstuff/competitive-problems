/**
 * 
 */
package kingsin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class kingsin {

    /**
     * @param args
     */
    int columns;
    int rows;
    char[][] rowarr;
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        kingsin kings = new kingsin();
    }

    public kingsin() throws FileNotFoundException {
        File f = new File("inputs.txt");
        Scanner sc = new Scanner(f);
        columns = sc.nextInt();
        rows = sc.nextInt();
        System.out.println(" rows is : " + rows + " columns: " + columns);
        rowarr = new char[rows][columns];
        
        for (int i = 0; i < rows; i++) { // what, <=?
            String line = sc.nextLine();
            if (line.length() == 0) {
                if (sc.hasNextLine()) {
                    line = sc.nextLine();
                }
            }
            char[] chrsx = new char[line.length()];
            chrsx = line.toCharArray();
            for (int z = 0; z < columns; z++) {
                rowarr[i][z] = chrsx[z];
                System.out.print(rowarr[i][z]);
            }
            System.out.println("");
        }
        
        this.recursiveTraverse(0, 0, 0, 0);
    }
    
    public int recursiveTraverse(int startrow, int startc, int lastrow, int lastc) {
        // start with an a, go to all its neighbors. if it's a B, return a 1; 
        
        // increment each path by that number that is returned (not summed or anything). 
        char x = rowarr[startrow][startc];
        System.out.println("start " + startrow + " , " + startc);
        if (x == 'B') {
            return 1;
        }
        else {
       
        // go right: columns + 1. 
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        
        if (startc + 1 < columns && (startc + 1 != lastc)) {
            a = this.recursiveTraverse(startrow, startc + 1, startrow, startc);
        }
        // go left: columns - 1;
        if (startc - 1 >= 0 && (startc - 1 != lastc)) {
            b = this.recursiveTraverse(startrow, startc - 1, startrow, startc);
        }
        // go up: row - 1?
        if (startrow - 1 >= 0 && (startrow - 1 != lastrow)) {
            c = this.recursiveTraverse(startrow - 1, startc, startrow, startc);
        }
        // go down: row + 1?
        if (startrow + 1 < rows && (startrow + 1 != lastrow)) {
            d = this.recursiveTraverse(startrow + 1, startc, startrow, startc);
        }
        
        System.out.println("I'm at " + startrow + ", " + startc +
            "changing rn value: " + rowarr[startrow][startc] + " to ==>" 
            + (a + b + c + d));
        rowarr[startrow][startc] = (char)(a + b + c + d);
      } /** end else*/
        /** we only reach here at the end of top left so*/
        System.out.println("I should only print once. Reached end"
            + "recursive at ====> " + startrow + ", & ==>" + startc);
        return 5;
    } /** end function*/
    
    public void printVibes() {
        
//        for (int i = 0; i < columns; i++) {
//            for (int z = 0; z < rows; z++) {
//                System.out.print(rowarr[i][z]);
//            }
//            System.out.println("");
//        }
    }
}
