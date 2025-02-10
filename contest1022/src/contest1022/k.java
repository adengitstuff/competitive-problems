/**
 * 
 */
package contest1022;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author A
 *
 */
public class k {

    /**
     * @param args
     */
    int[][] train;
    ArrayList<Integer> testie = new ArrayList<Integer>();
    int trainMax;
    int maxDistance = 0;
    int maxCount = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        k k = new k();
    }
    
    public k() {
        Scanner sc = new Scanner(System.in);
        
        int nCars = sc.nextInt();
        int carlength = sc.nextInt();
        int nPassengers = sc.nextInt();
        
        train = new int[2][nCars]; // model of the train
        int currtrainvalue = (carlength / 2);
        for (int i = 0; i < nCars; i++ ) {
            train[0][i] = currtrainvalue + 3;
            currtrainvalue = currtrainvalue + carlength;
            train[1][i] = 0;
        }
        trainMax = (carlength * nCars) - (carlength / 2); // last door of train;
        // passenger loop, no pun intended
        
        for (int i = 0; i < nPassengers; i++) {
            int currentP = sc.nextInt();
            
            // find the closest car..
            int closestcar = Math.floorDiv(currentP, carlength); // this gets a numer like 42 or something
            
            int doorlengthcars = (closestcar * carlength) - (carlength / 2); // this equals out the first car
                 // door being 1/2 the distance of a car, and basically starts iterating car doors
            
            /** WE don't need to store anything, just count repeat values.*/
            
            // check 3 values starting from closestcar? hmm......
            int currMinDistance = 999;
            int currentDoor = doorlengthcars;
            int bestDoor = currentDoor;
            for (int x = 0; x < 3; x++) {
                int distance = Math.abs(currentP - currentDoor);
                //System.out.println("Passenger" + currentP + " On door: " + currentDoor + ", Distance ==> " + distance);
                if (currentDoor <= trainMax && (distance <= currMinDistance)) {   /** <=== <= is really important!*/
                    currMinDistance = (Math.abs(currentP - currentDoor));
                    bestDoor = currentDoor;
                }
                /** EQUALS CASE?*/
                // if equals just take higher one so we're chilling
                
                currentDoor = currentDoor + (carlength); // find the next door and check
            }
            
            //System.out.println("For this passenger, the best door is : " + bestDoor + " with distance " + currMinDistance);
            /** After this loop, in theory, we found the closest door for the passenger. So put that in our thingie*/
            
            //System.out.println("Does our array contain that door? Let's check : " + train[0][bestDoor / carlength]);
            
            // put into
            
            testie.add(bestDoor);
       
            /** We see how many passengers are in later. Take the distance from the door to the person, abs, and then compare with
             * max distance, since we only need 1
             */
            
            if (currMinDistance > maxDistance) { 
                maxDistance = currMinDistance;
            }
       
        }
        
        // now print:
        
        System.out.println(maxDistance);
        
        int maxcountie = 1;
        for (int cc : testie) {
            int count = 0;
            for (int nn : testie) {
                if (cc == nn) {
                    count++;
                }
            }
            if (count > maxcountie) {
                maxcountie = count;
            }
        }
        System.out.println(maxcountie);
    }

}
