/**
 * 
 */
//package freeFood;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class freeFood {

    /** ICPC kattis problem from ICPC Singapore
     * @param args
     */
    Scanner sc;
    int[] year = new int[366]; // is this constant??
    public static void main(String[] args) throws FileNotFoundException {
        freeFood fd = new freeFood();

    }
    
    public freeFood() throws FileNotFoundException {

        sc = new Scanner(System.in);
        
        int total = sc.nextInt();
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            this.parse(a, b);
        }           
        this.count();
    }
    
    public void parse(int x, int y) {
        for (int i = x; i <= y; i++) {
            year[i] = 1;
        }
       
    }
    
    public void count() {
        int count = 0;
        for (int z = 0; z < year.length; z++) {
            if (year[z] == 1) {
                count++;
            }
        }     
        System.out.println(count);
    }

}
