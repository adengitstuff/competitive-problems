/**
 * 
 */
//package addingWords;

/**
 * @author A
 *
 */


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/** Fixed extra space causing wrong answer
 * 
 *  * fixed printing "calc" in calc answers
 * @author aden p
 *
 */
public class addingWords {

    /**
     * @param args
     */
    HashMap<String, Integer> hm;
    private boolean add = true;
    public static void main(String[] args) throws FileNotFoundException{
       
        Scanner s = new Scanner(System.in);
        addingWords add = new addingWords();
        while (s.hasNextLine()) {
            String str = s.nextLine();
            System.out.println("working on : " + s);
            add.read(str);
        }
       
        s.close();
       
    }
   
    public addingWords() {
        hm = new HashMap<String, Integer>();
    }
   
    public String calc(String[] strArr) {
       
        int c = 0;
        int thisNum = 0;
       
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].contentEquals("+")) {
                add = true;
            }
            else if (strArr[i].contentEquals("-")) {
                add = false;
            }
            else if (strArr[i].contentEquals("=")) {
                
            }
            else {
                // we are at a word, like "bar" or "code"
                if (hm.containsKey(strArr[i])) {
                    thisNum = hm.get(strArr[i]);
                    //System.out.println(" for thisnum, in the hash map look up, we get: " + thisNum);
                    if (add) {          // changed from if (add) for the vibe
                        //System.out.println("C right now is... " + c);
                        c = c + thisNum;
                    }
                    else if (!add){
                        //System.out.println(" in add == false ( i shouldn't be here");
                        c = c - thisNum;
                    }
                }
                else {                   
                    return "unknown";
                }
                // should be a switch statement but w/e
                
            }
           
        }
            /** Odd but i think that's the entire loop?*/
        if (hm.containsValue(c)) {
            for (String s : hm.keySet()) {
                if (hm.get(s).equals(c)) {
                    return s;
                }
            }
        }
        return "unknown";
    }

    public void read(String line)  {
        /** This might be bad practice in case
         * we ever want to define def, but i will assume
         * it's not allowed
         */
        if (line.contains("def")) {
            String[] spl = line.split(" ");
            //System.out.println("about to put into hashmap : " + spl[1] + " to " + spl[2]);
            if (hm.containsKey(spl[1])) {
                hm.remove(spl[1]);
            }
            hm.put(spl[1], Integer.parseInt(spl[2]));
            //System.out.println(" test parseInt calc: " + spl[2] + " and " + spl[2] + " so now in ints we can add: " + (c + c) + "and c * c: " + ( c * c));
        }
        /** again bad practice, should definitely read the first
         * word and determine it from there but this is faster rn
         */
        else if (line.contains("calc")) {
            String[] spl = line.split(" ");
            for (int i = 1; i < spl.length; i++) {
                System.out.print(spl[i] + " ");
            }
            System.out.print(this.calc(spl));
            System.out.println("");
            //System.out.flush();
        }
        else if (line.contains("clear")) {
            hm.clear();
        }
        else {
            
        }
    }
}