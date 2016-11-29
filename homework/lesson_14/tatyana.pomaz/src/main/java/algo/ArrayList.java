package algo;

import java.util.Random;

public class ArrayList<T> implements List<T> {
  private Object[] array = new Object[0];

  public void add(T item) {
    Object[] temp = new Object[array.length + 1];
    System.arraycopy(array, 0, temp, 0, array.length);
    temp[array.length] = item;
    array = temp;
  }
  
  public T get(int index) {
    return (T)array[index];  
  }
  
  public void remove(int index) {
    Object[] temp = new Object[array.length - 1];
    System.arraycopy(array, 0, temp, 0, index);
    System.arraycopy(array, index + 1, temp, index, array.length - index - 1);
    array = temp;
  }
  
  public boolean isEmpty() {
    return array.length == 0;  
  }
  
  public int size() {
    return array.length;  
  }
  
  public void clear() {
    array = new Object[0];
  }
    
  public Iterator<T> iterator() {
    return new IteratorOfArrayList<T>(0);  
  }
  
  public ReverseIterator<T> reverseIterator() {
    return new ReverseIteratorOfArrayList<T>(array.length - 1);
  }
  
  public Iterator<T> randomIterator() {
    Random generator = new Random(); 
    return new IteratorOfArrayList<T>(generator.nextInt(array.length));  
  }
  
  private class IteratorOfArrayList<T> implements Iterator {
    private int currentIndex;

    IteratorOfArrayList(int index) {
      currentIndex = index;
    }

    public boolean hasNext() {
      return currentIndex < array.length;
    }

    public T next() {
      T item = (T)array[currentIndex++];
      return item;
    }
  }
 
  private class ReverseIteratorOfArrayList<T> implements ReverseIterator {
    private int currentIndex;

    ReverseIteratorOfArrayList(int index) {
      currentIndex = index;
    }

    public boolean hasPrevious() {
      return currentIndex >= 0;
    } 

    public T previous() {
      T item = (T)array[currentIndex--];
      return item;
    }
  }
}
