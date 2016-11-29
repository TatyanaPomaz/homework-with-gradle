package algo;

import java.util.Comparator;

public class BubbleSortBinarySearch extends BinarySearch {

  public Object[] sort(Object[] unsorted) {
    for (int i = unsorted.length - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        Comparable obj = (Comparable) unsorted[j];

        if (obj.compareTo(unsorted[j + 1]) > 0) {
          Object temp = unsorted[j];
          unsorted[j] = unsorted[j + 1];
          unsorted[j + 1] = temp;
        }
      }
    }
    return unsorted;
  }  
}