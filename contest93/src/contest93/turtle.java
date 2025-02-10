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
public class turtle {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    String currDirection;
    int[] pointer = new int[2];
    char[][] map = new char[8][8];
    String instructions;
    private boolean alive = true;
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        
        
        turtle turtle = new turtle();
        turtle.read();
        //turtle.printMap();
        turtle.parse();
    }
    
    public void read() throws FileNotFoundException {
        //File f = new File("inputz.txt");
        Scanner sc = new Scanner(System.in);
        this.currDirection = "RIGHT";
        pointer[0] = 7;
        pointer[1] = 0;
        
        for (int i = 0; i < 8; i++) {
            String s = sc.nextLine();
            //System.out.println(s);
            char[] c = s.toCharArray();
            for (int z = 0; z < 8; z++) {
                map[i][z] = c[z];
            }
        }
        instructions = sc.nextLine();
        
                
    }
    
    public void parse() {
        char[] instruct = instructions.toCharArray();
        
        for (int i = 0; i < instruct.length; i++) {
            //System.out.println("Parsing the instruction : " + instruct[i]);
            if (instruct[i] == 'F' && alive) {
                this.fore();
                this.check();
            }
            if (instruct[i] == 'L' && alive) {
                //System.out.println("Current direction : " + currDirection);
                if (this.currDirection == "DOWN") {
                    currDirection = "RIGHT";
                }
                else if (this.currDirection == "LEFT") {
                    currDirection = "DOWN";
                }
                else if (this.currDirection == "RIGHT") {
                    currDirection = "UP";
                }
                else if (this.currDirection == "UP") {
                    currDirection = "LEFT";
                }
                //System.out.println("Current direction : " + currDirection);
            }
            if (instruct[i] == 'R' && alive) {
                if (this.currDirection == "DOWN") {
                    currDirection = "LEFT";
                }
                else if (this.currDirection == "LEFT") {
                    currDirection = "UP";
                }
                else if (this.currDirection == "RIGHT") {
                    currDirection = "DOWN";
                }
                else if (this.currDirection == "UP") {
                    currDirection = "RIGHT";
                }
            }
            if (instruct[i] == 'X' && alive) {
                this.laser();
                this.check();
            }
        }
            // If after parsing all instructions, we're on a Diamond
        if (map[pointer[0]][pointer[1]] == 'D') {
            System.out.println("Diamond!");
        }
    }
    
    public void printMap() {
        System.out.println(" ************** ");
        for (int i = 0; i < 8; i++) {
            for (int z = 0; z < 8; z++) {
                System.out.print(map[i][z]);
                System.out.print("(" + i + ", " + z + ")");
            }
            System.out.println();
        }
        System.out.println(" ************** ");
    }
    
    public void check() {
        char c = map[pointer[0]][pointer[1]];
        if (! alive) {
            System.out.println("Bug!");
            System.exit(0);
        }
        if (c == 'I' || c == 'C') {
            System.out.println("Bug!");
            alive = false;
            System.exit(0);
        }
    }
    public void fore() {
        
        int currI = pointer[0];
        int currX = pointer[1];

        if (currDirection == "RIGHT") {
            if (currX == 7) {
                System.out.println("Bug!");
                System.exit(0);
            } else {
            pointer[1] = (pointer[1] + 1);
            }

        }
        // move [i][x], x + 1. 
        
        //if curr direction is up:
        else if (currDirection == "UP") {
            if (currI == 0) {
             System.out.println("Bug!");
             System.exit(0);
            } else {
            pointer[0] = (pointer[0] - 1);
            }
        }
        // move [i][x], i - 1;?
        else if (currDirection == "LEFT") {
            if (currX == 0) {
                System.out.println("Bug!");
                System.exit(0);
            } else {
            pointer[1] = (pointer[1] - 1);
            }
        }
        // if curr direction is left: 
        
        // move [i][x], [x - 1]
        
        // if curr is down:
        else if (currDirection == "DOWN") {
            if (currI == 7) {
                System.out.println("Bug!");
                System.exit(0);
            } else {
            pointer[0] = (pointer[0] + 1);
            }
        }
        
        // move [i][x], [i + 1]
        this.check();
    }
    
    public void laser() {
        // above rules, then map [i][x] is .
        int i = pointer[0];
        int x = pointer[1];
        if (currDirection == "RIGHT") { 
            // is this a valid square. is it outside the board
            
            if ((i < 8 && x < 7)) {
                if (map[i][x + 1] == 'I') {
                    map[i][x + 1] = '.';
                }
                else {
                    alive = false;
                }
            }
            else {
                // out of bounds?
                alive = false;
            }
        }
        
        else if (currDirection == "LEFT") {
            if ((x > 0)) {
                if (map[i][x - 1] == 'I') {
                    map[i][x - 1] = '.';
                }
                else {
                    alive = false;
                }
            }
            else {
                // out of bounds?
                alive = false;
            }
        }
        
        else if (currDirection == "UP") {
            if ((i > 0)) {
                if (map[i - 1][x] == 'I') {
                    map[i - 1][x] = '.';
                }
                else {
                    alive = false;
                }
            }
            else {
                // out of bounds?
                alive = false;
            }
        }
        
        else if (currDirection == "DOWN") {
            if ((i < 7)) {
                if (map[i + 1][x] == 'I') {
                    map[i + 1][x] = '.';
                }
                else {
                    alive = false;
                }
            }
            else {
                // out of bounds?
                alive = false;
            }
        }
        
        this.check();
    }

}
