package algo;

import java.util.Comparator;

public class SelectionSortBinarySearch extends BinarySearch {

  public Object[] sort(Object[] unsorted) {
    for (int i = 0; i < unsorted.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < unsorted.length; j++) {
        Comparable obj = (Comparable) unsorted[j];
        if (obj.compareTo(unsorted[min]) < 0) {
          min = j;
          Object temp = unsorted[i];
          unsorted[i] = unsorted[min];
          unsorted[min] = temp;
        }
      }
    }
    return unsorted;
  } 
}