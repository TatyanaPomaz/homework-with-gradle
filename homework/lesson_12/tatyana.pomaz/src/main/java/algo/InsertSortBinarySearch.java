package algo;

import java.util.Comparator;

public class InsertSortBinarySearch extends BinarySearch {

  public Object[] sort(Object[] unsorted) {
    for (int i = 1; i < unsorted.length; i++) {
      Comparable temp = (Comparable) unsorted[i];
      int fl = i;
 
      while (fl > 0 && temp.compareTo(unsorted[fl - 1]) < 0) {
        unsorted[fl] = unsorted[fl - 1];
        --fl;
      }
      unsorted[fl] = temp;
    }
    return unsorted;
  } 
}