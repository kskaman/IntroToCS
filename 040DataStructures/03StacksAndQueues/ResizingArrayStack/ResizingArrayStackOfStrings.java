/******************************************************************************
 *  Compilation:  javac ResizingArrayStackOfStrings.java
 *  Execution:    java ResizingArrayStackOfStrings
 *  Dependencies: None
 *  Data files:   tobe.txt
 *
 *  Stack implementation with a resizing array.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java ResizingArrayStack
 *  Enter file name :
 *  tobe.txt
 *  (8 left on stack)
 *  Stack : [ is, that, be, to, not, or, be, to,  ]
 *
 ******************************************************************************/

 import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ResizingArrayStackOfStrings implements Iterable<String> {
    private String[] items;     // array of strings
    private int n = 0;          // number of elements on stack

    // create an empty stack
    public ResizingArrayStackOfStrings() {
        items = new String[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }


    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++)
            temp[i] = items[i];
        items = temp;
    }

    // push a new item onto the stack
    public void push(String item) {
        if (n == items.length) resize(2*items.length);  // double array length if necessary
        items[n++] = item;                              // add item
    }

    // delete and return the item most recently added
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = items[n-1];
        items[n-1] = null;        // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == items.length/4) resize(items.length/2);
        return item;
    }

    public String toString() {
        String str = "[ ";
        for (String s : this) {
            str += s + ", ";
        }
        str += " ]";
        return str;
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<String> {
        private int i = n-1;
        public boolean hasNext()  { return i >= 0;                              }
        public void remove()      { throw new UnsupportedOperationException();  }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[i--];
        }
    }



   /***************************************************************************
    * Test routine.
    ***************************************************************************/
    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
                   
        Scanner in = new Scanner(System.in);
 
        System.out.println("Enter file name : ");
        String filename = in.next();
        in.close();
        try {
            File file = new File(filename);
            Scanner fileContent = new Scanner(file);
            while (fileContent.hasNext()) {
                String item = fileContent.next();
 
                if (!item.equals("-"))
                    stack.push(item);
                 
                 
            }
            fileContent.close();
            System.out.println("(" + stack.size() + " left on stack)");
            System.out.println("Stack : " + stack);
 
        } catch (Exception FileSystemNotFoundException) {
            System.out.println("File not found");
        } 
    } 
}
