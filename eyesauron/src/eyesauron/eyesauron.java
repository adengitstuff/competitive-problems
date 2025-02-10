package eyesauron;

import java.util.Scanner;

public class eyesauron {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        eyesauron es = new eyesauron();
    }

    public eyesauron() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        char[] chararr = s.toCharArray();
        
        int linen = 0;
        int count = 0;
        int tempi = 0;
        
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i] == '(') {
                linen = count;
                tempi = i + 1;
                break;
            }
            else {
                count++;
            }
        }
        
        int count2 = 0;
        for (int z = tempi; z < chararr.length; z++) {
            if (chararr[z] == '|') {
                count2++;
            }
            else if (chararr[z] == ')') {
            }
        }
        
        if (count == count2) {
            System.out.println("correct");
        }
        else {
            System.out.println("fix");
        }
        
    }
}
