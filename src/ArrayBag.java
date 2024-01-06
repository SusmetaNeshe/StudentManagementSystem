import java.util.Iterator;

public class ArrayBag implements Bag {
   
   private Student arr[];
   private int size = 0;
   
   public ArrayBag() {
      arr = new Student[4];
      
   }
   
   public ArrayBag (int capacity) {
      if(capacity <4)
         arr = new Student [4];
      else 
         arr = new Student[capacity];
      
   }

   @Override
   public void add(Student s) {
      if ( size == arr.length)
         throw new BagFullException();
      arr[size] = s;
      size++; 
      
   }

   @Override
   public void remove(Student s) {
     for (int i = 0; i < size; i++) {
        if (arr[i].equals(s)) {
          arr[i]= arr[size -1];
             arr[size-1] = null;
             size--;
             break;
        }
     }    
   }

   @Override
   public boolean contains(Student s) {
      for ( int i = 0; i< size; i++) {
         if (arr[i].equals(s)) {
            return true;
         }
      }
      return false;
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   @Override
   public int size() {    
      return size;
   }

   @Override
   public void clear() {
      for ( int i = 0; i < size; i++) {
         arr[i] = null;
      }
      size = 0;
   }

   @Override
   public Iterator<Student> iterator() {
      return new StudentIterator();
      
   }
   
   private class StudentIterator implements Iterator <Student>{

      private int index = 0;
         
      @Override
      public boolean hasNext() {
         return index < size;
      }

      @Override
      public Student next() {
         return arr[index++];
      }
      
   }

}
