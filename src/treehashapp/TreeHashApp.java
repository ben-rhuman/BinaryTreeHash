
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

            System.out.print("Enter size of hash table: ");
            HashTable hash = new HashTable(getInt());
            System.out.print("Enter initial number of items: ");
            int numItems = getInt();
            System.out.print("Enter 'r' to randomly generate " + numItems + " items (from 0 to 1000) or 'e' to enter manually: ");
            input = getChar();

            if (input == 'r') {
                //random generation
                Random r = new Random();
                for (int i = 0; i < numItems; i++) {
                    hash.insert(r.nextInt(1000));
                }
            } else { //manually enter values
                for (int i = 0; i < numItems; i++) {
                    System.out.print("Enter a single value: ");
                    hash.insert(getInt());
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
                        System.out.print("Enter key value to insert: ");
                        hash.insert(getInt());
                        break;
                    case 'd':
                        System.out.print("Enter key value to delete: ");
                        hash.delete(getInt());
                        break;
                    case 'f':
                        System.out.print("Enter key value to find: ");
                        hash.find(getInt());
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

    public void insert(Node n) { //Inserts additional nodes into the tree

        if (root == null) { //If tree is empty
            root = n;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (n.data == current.data) { //Doesnt insert node if it already exist in the tree. 
                    return;
                } else if (n.data < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = n; //Inserts on left
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) { //Insert on right
                        parent.rightChild = n;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree(Node current) { //Displays in an in-order fashion
        if (current != null) {
            displayTree(current.leftChild); //recursively move left
            System.out.print(current.data + " ");//recursively print
            displayTree(current.rightChild);//recursively move right          
        }
    }

    public void delete(int val) { //Removes desired node from tree

    }

    public void find(int val) { //Searches through based on value to determine if the key is in the hash
        if (root == null) {
            System.out.println("Could not find " + val);
        } else {
            Node current = root;
            while (true) {
                if (val == current.data) {  
                    System.out.println("Found " + val);
                    return;
                } else if (val < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        System.out.println("Could not find " + val);
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) { 
                        System.out.println("Could not find " + val);
                        return;
                    }
                }
            }
        }
        return;
    }
} //End of Tree Class
////////////////////////////////////////////////////////////////////

class Node {

    public int data; //Key value
    public Node leftChild; //Nodes children if there are any
    public Node rightChild;

    public Node(int data) {
        this.data = data;
    }
}//End of Node Class
////////////////////////////////////////////////////////////////////

class HashTable {

    private int size; //Size of array
    private Tree[] hash; //Array of trees

    public HashTable(int size) { //Constructs the hash with specified size
        this.size = size; //Intializes size of array
        hash = new Tree[size];
    }

    public void show() { //Displays array index and then the tree in an inorder fashion
        for (int i = 0; i < size; i++) {
            System.out.print(i + ". ");
            if (hash[i] != null) {
                hash[i].displayTree(hash[i].root); //Starts the recursive in-order traversal
            }
            System.out.print("\n");
        }
    }

    public void insert(int val) { //Creates tree and node then inserts it into the array
        if (hash[val % size] == null) {
            hash[val % size] = new Tree();
        } 
        
        Node n = new Node(val);
        hash[val % size].insert(n);
    }

    public void delete(int val) { //Deletes the node containing the key if it can be found.
        if (hash[val % size] != null) {
            hash[val % size].delete(val);
        } else {
            System.out.println(val + " does not exist.");
        }
    }

    public void find(int val) { //Looks for the key based on the value in the binary search tree
        if (hash[val % size] != null) {
            hash[val % size].find(val);
        } else {
            System.out.println("Could not find " + val);
        }
    }
}
