import java.util.Arrays;
import java.util.Scanner;

public class dicecup {

    int numfaces1;
    int numfaces2;
    public static void main(String[] args) {
        dicecup cup = new dicecup();
    }
    
    public dicecup() {
        Scanner sc = new Scanner(System.in);
        numfaces1 = sc.nextInt();
        numfaces2 = sc.nextInt();
        int[] totalsums = new int[numfaces1 + numfaces2 + 2];       
        Arrays.fill(totalsums, 0);
        int highestnumber = 0;
        for (int i = 1; i <= numfaces1; i++) {
            for (int z = 1; z <= numfaces2; z++) {
                int cc = totalsums[z + i] + 1;
                totalsums[z + i] = cc;
                if (cc > highestnumber) {
                    highestnumber = cc;
                }
            }
        }
        for (int c = 0; c < totalsums.length; c++) {
              if (totalsums[c] == highestnumber) {
                  System.out.println(c);
              }
        }               
    }
}
