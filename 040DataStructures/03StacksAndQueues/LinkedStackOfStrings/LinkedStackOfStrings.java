/*****************************************************************************
 *  Compilation:  javac LinkedStackOfStrings.java
 *  Execution:    java LinkedStackOfStrings
 *  Data files:   tobe.txt
 *
 *  Stack of strings implementation using a linked list.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java LinkedStackOfStrings tobe.txt
 *  (8 left on stack)
 *  Stack : [ is, that, be, to, not, or, be,  ]
 *
 ******************************************************************************/

 import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

 public class LinkedStackOfStrings implements Iterable<String> {
    private int n;
    private Node first;

    private class Node {
        private String item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        String item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Iterator<String> iterator() {
        return new LinkedStackIterator();
    }

    public String toString() {
        String str = "[ ";
        for (String s : this) {
            str += s + ", ";
        }
        str += " ]";
        return str;
    }

    public class LinkedStackIterator implements Iterator<String> {
        private Node current;

        public LinkedStackIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String str = current.item;
            current = current.next;
            return str;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
                   
        Scanner in = new Scanner(System.in);
 
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments.");
            System.exit(0);
        }

        String filename = args[0];
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