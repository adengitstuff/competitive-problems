/**
 * 
 */
package contest1022;

import java.util.Scanner;

/**
 * @author A
 *
 */
public class i {

    /**
     * @param args
     */
    private double controltotal = 0;
    private double vaccinetotal = 0;
    private double controlA = 0;
    private double controlB = 0;
    private double controlC = 0;
    private double vaccineA = 0;
    private double vaccineB = 0;
    private double vaccineC = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        i i = new i();
    }
    
    public i() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            this.parser(line);
        }

        this.efficacy();
    }
    
    public void print() {
        System.out.println("Control: " + controltotal + " A: " + controlA + " B: " + controlB + " C: " + controlC);
        System.out.println("===");
        System.out.println("Vaccine: " + vaccinetotal + " A: " + vaccineA + " B: " + vaccineB + " C: " + vaccineC);
    }
    
    public void efficacy() {
        /** For Vaccine A: */
        // infection rate of vaccinated group:
        double infvac = vaccineA / vaccinetotal;
        double contvac = controlA / controltotal;
        double totA = 1 - (infvac / contvac);
        if (contvac > infvac) {
            System.out.println(String.format("%.6f", (totA * 100.00)));
        }
        else {
            System.out.println("Not effective");
        }
        
        /** B : */
        double infvacb = vaccineB / vaccinetotal;
        double contvacb = controlB / controltotal;
        double totB = 1 - (infvacb / contvacb);
        if (contvacb > infvacb) {
            System.out.println(String.format("%.6f", (totB * 100.00)));
            }
            else {
                System.out.println("Not effective");
            }
        
        /** C:  */
        
        double infvacc = vaccineC / vaccinetotal;
        double contvacc = controlC / controltotal;
        double totC = 1 - (infvacc / contvacc);
        if (contvacc > infvacc) {
            System.out.println(String.format("%.6f", (totC * 100.00)));
            }
            else {
                System.out.println("Not effective");
            }
        
        
    }
   
    public void parser(String nstring) {
        
        char[] prs = nstring.toCharArray();
        
        if (prs[0] == 'N') {
            // N Means not given the real vaccine, so control gorup
            controltotal++;
            
            // now parse individually
            if (prs[1] == 'Y') {
                controlA++;
            }
            if (prs[2] == 'Y') {
                controlB++;
            }
            if (prs[3] == 'Y') {
                controlC++;
            }
           
        } else {
            vaccinetotal++;
            if (prs[1] == 'Y') {
                vaccineA++;
            }
            if (prs[2] == 'Y') {
                vaccineB++;
            }
            if (prs[3] == 'Y') {
                vaccineC++;
            }
        }

    }
    
    

}
