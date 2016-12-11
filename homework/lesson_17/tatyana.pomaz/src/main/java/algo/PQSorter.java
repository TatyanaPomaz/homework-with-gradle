package algo;

import java.util.Arrays;
import java.util.Comparator;

public class PQSorter {
  private Order order;

  public static enum Order {
    ASCENDING, DESCENDING;
  }

  public PQSorter() {}

  public PQSorter(Order order) {
    this.order = order;
  }

  public <T extends Comparable> T[] sort(T[] unsorted) {
    PriorityQueue<T> pq = new PriorityQueue<>(new StringComparator());
    Object[] sorted = new Object[unsorted.length];
  
    for (int i = 0; i < unsorted.length; i++) {
      pq.insert(unsorted[i]); 
    }
    for (int i = 0; i < sorted.length; i++) {
      sorted[i] = pq.min(); 
    }  
  
    return (T[]) Arrays.copyOfRange(sorted, 0, unsorted.length, unsorted.getClass());
  }

  public class StringComparator<T extends String> implements Comparator<T> {
    @Override
    public int compare(T left, T right) {
      if (order == Order.ASCENDING) {
        return left.compareTo(right);
      } else {
        return left.compareTo(right) * -1;
      }
    }
  }
}
