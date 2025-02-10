/**
 * 
 */
package contest108;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class e {

    /**
     * @param args
     */
    int ultrapointer = -1;
    int arrayEnd = 0;
    boolean a = true;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        e e = new e();
    }
    
    public e() {
        Scanner sc = new Scanner(System.in);
        
        String earlyPhrase = sc.nextLine();
        String[] phr = earlyPhrase.split(" ");
        int phraselength = phr.length;
        int nInt = sc.nextInt();
        arrayEnd = nInt - 1;
        String[] nArray = new String[nInt];
        
        // 
        for (int i = 0; i < nInt; i++) {
            String s = sc.next();
            nArray[i] = s;
        }
        
        // while loop to : " while combined sizes of arraylists
        // are less than num of students
        
        // loops are just for i = 0, i = (num words in phrase) call next that many times..
        
        // at each selection:
        
            // if team a boolean flag is true, put kid in a.

            // if false, put kid in b
            // set flag to not flag?
            
            // set array's current pointer to null..
        ArrayList<String> aTeam = new ArrayList<String>();
        ArrayList<String> bTeam = new ArrayList<String>();
        
        while (aTeam.size() + bTeam.size() != nInt) {
                   
                   for (int i = 0; i < phraselength; i++) {
                       this.nextarr(nArray);
                   }
                   
                   // ultrapointer now set at righit place..
                   if (a) { 
                       aTeam.add(nArray[ultrapointer]);
                       nArray[ultrapointer] = null;
                       a = false;
                   } else {
                       bTeam.add(nArray[ultrapointer]);
                       nArray[ultrapointer] = null;
                       a = true;
                   }
        }
        
        this.print(aTeam, bTeam);
        
    }
    
    public String nextarr(String[] nArr) {
        
        // case where at end
        if (ultrapointer == arrayEnd) {
            ultrapointer = 0;
            
            if (nArr[ultrapointer] == null) {
                // iterate ultrapointer <=== DON'T!
                // call this again?
            } else {
                return nArr[ultrapointer];
            }
        }
        // case where empty or null thing
        // look for next thing
        ultrapointer++;
        
        if (nArr[ultrapointer] == null) {
          this.nextarr(nArr);  
        } else {
            return nArr[ultrapointer];
        }
        

        return nArr[ultrapointer];
    }
    
    public void print(ArrayList<String> aArray, ArrayList<String> bArray) {
        System.out.println(aArray.size());
        
        for (String k : aArray) {
            System.out.println(k);
        }
        
        System.out.println(bArray.size());
        
        for (String x : bArray) { 
            System.out.println(x);
        }
        
    }

}
