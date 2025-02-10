//package guessNum;
import java.util.Scanner;

public class guessNum {

    /** Simple binary search kattis problem
     * @param args
     */
    Scanner sc;
    public static void main(String[] args) {
        guessNum gn = new guessNum();
      
    }
    
    public guessNum() {
        sc = new Scanner(System.in);
        this.binarySearch(0, 1001);
    }
    public void binarySearch(int lowerBound, int upperBound) {
        
        // if the number is higher than the guess, then search
        int c = ((upperBound + lowerBound) / 2);
        System.out.flush();
        System.out.println(c);        
        String s = "";
        if (sc.hasNext()) {
        s = sc.next();
        
        if (s.equals("correct")) {
            //base case
            sc.close();
            System.exit(1);
        }
        else if (s.equals("higher")) {
            //this.binarySearch((upperBound / 2), upperBound, c);
            this.binarySearch(c, upperBound);
        }
        else if (s.equals("lower")) {
            this.binarySearch(lowerBound, c);
        }
       
     }
    }

}