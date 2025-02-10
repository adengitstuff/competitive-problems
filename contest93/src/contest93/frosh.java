/**
 * 
 */
package contest93;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class frosh {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        ///test bbuble sort
        
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        int[] intArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            //System.out.println(" I got =>" + a);
            intArr[i] = a;
        }
        //sort:
        
        frosh fr = new frosh();
        fr.bubbleSort(intArr);
        

    }
    
    public void bubbleSort(int arr[]) {
        
        int n = arr.length;
        int steps = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int x = 0; x < n - i - 1; x++) {
                if (arr[x] > arr[x + 1]) {
                    // swap
                    int temp = arr[x];
                    steps++;
                    
                    arr[x] = arr[x + 1];
                    arr[x + 1] = temp;
                }
            }
        }
        
        System.out.println(steps);        
    }
    
    public void printyo(int arr[], int nSteps) {
        int n = arr.length;
        
        System.out.println(" Done in " + nSteps + " steps");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
        
    }

}
