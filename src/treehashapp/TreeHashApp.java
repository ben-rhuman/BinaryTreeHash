
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random; //to randomly select values

/**
 *
 * @author Ben Rhuman, Isaac Sotelo, Brendan Tracey
 */
public class TreeHashApp {

    public static void main(String[] args) throws IOException {

        char input = 'y';

        while (input != 'n') {
            HashTable hash = new HashTable();
            System.out.print("Enter size of hash table: ");
            hash.size = getInt();
            System.out.print("Enter initial number of items: ");
            int numIteams = getInt();
            System.out.print("Enter 'r' to randomly generate " + numIteams + " items or 'e' to enter manually: ");
            input = getChar();

            if (input == 'r') {
                //random generation
                Random r = new Random();                
                for(int i = 0; i < numIteams; i++){
                    hash.insert((int)(r.nextInt(100)));
                }
            } else { //manually enter values
                int counter = 0;
                
                while(counter < numIteams){
                    System.out.println("Enter a value: \n");
                    int value = (int)getChar();
                    hash.insert(value);
                    counter++;
                    }
            }

            while (input != 'q') {
                System.out.print("Enter first letter of show, insert, delete, find, or quit: ");
		input = getChar();
                switch (input) {
                    case 's':
                        hash.show();
                        break;
                    case 'i':
                        int value = (int)getChar();
                        hash.insert(value);
                        break;
                    case 'd':
                        hash.delete();
                        break;
                    case 'f':
                        hash.find();
                        break;
                    case 'q':
                        break;
                    default:
                        System.out.print("Invalid entry\n");
                }  // end switch
            }
            System.out.print("Would you like to make another hash table? (y/n): ");
            input = getChar();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);

    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}//End of TreeHashApp Class
////////////////////////////////////////////////////////////////////

class Tree {

    public Node root; //First node in the tree

    public Tree() { //Tree Constructor
        root = null;
    }

    public void insert() { //Inserts additional nodes into the tree

    }

    public void displayTree() { //Displays in an in-order fashion

    }

    public void delete() { //Removes desired node from tree

    }
} //End of Tree Class
////////////////////////////////////////////////////////////////////

class Node {

    //Some data carrying variable
    public Node leftChild;
    public Node rightChild;

}//End of Node Class
////////////////////////////////////////////////////////////////////

class HashTable {

    public int size;
    
    public void show(){
        
    }
    
    public void insert(){
        
    }
    
    public void delete(){
        
    }
    
    public void find(){
        
    }
}
