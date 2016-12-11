package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T extends Comparable> implements Iterable<T> {
  private Object[] elements = new Object[20]; 
  private int size = 0;
  private Comparator<T> comparator;

  public PriorityQueue() {}

  public PriorityQueue(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  public void insert(T item) {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }

    elements[++size] = item;
    swim(size);
  }

  public T min() {
    T min = (T) elements[1];

    exchange(1, size);
    elements[size--] = null;
    sink(1);

    return min;
  }

  private void swim(int item) {
    // to move up to parent = item / 2
    while (!isRoot(item) && greaterOrEqual(getParentIndex(item), item)) {
      exchange(item, getParentIndex(item));
      item = getParentIndex(item);
    }
  }

  private void sink(int item) {
    // item * 2 = left
    // item * 2 + 1 = right
    while (getLeftChildIndex(item) <= size) {
      int child = getChildIndex(item);
      if (greaterOrEqual(item, child)) {
        exchange(item, child);
        item = child;
      } else {
        break;
      }
    }
  }

  private void exchange(int item1, int item2) {
    T tmp = (T)elements[item1];
    elements[item1] = elements[item2];
    elements[item2] = tmp;
  }

  private boolean greaterOrEqual(int item1, int item2) {
    if (comparator == null) {
      return ((Comparable)elements[item1]).compareTo(elements[item2]) > -1;
    } else {
      return comparator.compare((T)elements[item1], (T)elements[item2]) > -1;   
    }
  }

  private int getParentIndex(int item) {
    return item / 2;
  }

  private int getChildIndex(int item) {
    int leftChild = getLeftChildIndex(item);
    if (leftChild != size && greaterOrEqual(getLeftChildIndex(item), getRightChildIndex(item))) {
      return getRightChildIndex(item);
    }
    return leftChild;
  }

  private int getLeftChildIndex(int item) {
    return item * 2;
  }

  private int getRightChildIndex(int item) {
    return item * 2 + 1;
  }

  private boolean isRoot(int item) {
    return item == 1;
  }

  public Iterator<T> iterator() {
    return new PriorityQueueIterator<T>(elements);
  }
  
  class PriorityQueueIterator<T> implements Iterator<T> {
    private Object[] elements;
    private int index = 1;
 
    PriorityQueueIterator(Object[] elements) {
      this.elements = elements;
    }
 
    public boolean hasNext() {
      return (index < elements.length && elements[index] != null);
    }
 
    public T next() {
      return (T)elements[index++];
    }  
  }
}
  
  