/******************************************************************************
 *  Compilation:  javac ArrayStackOfStrings.java
 *  Execution:    java ArrayStackOfStrings
 *  Data files:   tobe.txt
 *
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java ArrayStackOfStrings 
 *  Enter file name :
 *  tobe.txt
 *  (8 left on stack)
 *  Stack : [ is, that, be, to, not, or, be,  ]
 *
 ******************************************************************************/



 import java.io.File;
 import java.util.Iterator;
 import java.util.NoSuchElementException;
 import java.util.Scanner;
 
 public class ArrayStackOfStrings implements Iterable<String> {
     private String[] items;
     private int n;
 
     public ArrayStackOfStrings(int capacity) {
         items = new String[capacity];
         n = 0;
     }
 
     public boolean isEmpty() { return n == 0; }
 
     public boolean isFull() { return n == items.length; }
 
     public void push(String item) { 
         if (item == null) throw new NullPointerException();
         items[n++] = item; 
     }
 
     public String pop() {
         String item = items[n--];
         items[n+1] = null;
         return item;
     }
 
     public int size() {
         return n;
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
 
     public class ReverseArrayIterator implements Iterator<String> {
         private int i;
 
         public ReverseArrayIterator() {
             i = n-1; 
         }
 
         public boolean hasNext() { return i > 0; }
 
         public String next() {
             if (!hasNext()) throw new NoSuchElementException();
             return items[i--];
         }
 
         public void remove() { throw new UnsupportedOperationException(); }
     }
 
     public static void main(String[] args) {
         ArrayStackOfStrings stack = new ArrayStackOfStrings(10);
                   
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
 