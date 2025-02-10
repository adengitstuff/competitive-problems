package contest917;

import java.util.Scanner;

public class b {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        b dominion = new b();
    }
    
    public b() {
        Scanner sc = new Scanner(System.in);
        
        int gold = sc.nextInt();
        
        int silver = sc.nextInt();
        
        int copper = sc.nextInt();
        
        int totalMoney = 0;
        
        
        totalMoney = gold * 3;
        totalMoney = totalMoney + (silver * 2);
        totalMoney = totalMoney + copper;
        
        if (totalMoney >= 8) {
            System.out.println("Province or Gold");
        }
        else if (totalMoney < 8 && totalMoney >= 5) {
            if (totalMoney >= 6) {
                System.out.println("Duchy or Gold");
            } else {
                System.out.println("Duchy or Silver");
            }
        }
        else if (totalMoney < 5 && totalMoney >= 3) {
            System.out.println("Estate or Silver");
        }
        else if (totalMoney < 3 && totalMoney >= 2) {
            System.out.println("Estate or Copper");
        }
        else {
            System.out.println("Copper");
        }
        
    }

}
