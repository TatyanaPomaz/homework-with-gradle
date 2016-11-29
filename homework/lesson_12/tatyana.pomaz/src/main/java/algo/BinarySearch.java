package algo;

import java.util.Comparator;

public abstract class BinarySearch {
  public final int perform(Object[] unsorted, Object toFind) {
    sort(unsorted);
    return binarySearch(unsorted, toFind);
  }

  protected abstract Object[] sort(Object[] unsorted);

  private int binarySearch(Object[] sorted, Object toFind) {
    
    int lowerBound = 0;
    int upperBound = sorted.length - 1;
    int midle;

    while (lowerBound <= upperBound) {
      midle = (lowerBound + upperBound) / 2;
      if (sorted[midle].equals(toFind)) {
        return midle;
      } else {
        Comparable obj = (Comparable) sorted[midle];
        if (obj.compareTo(toFind) < 0) {
          lowerBound = midle + 1;
        } else {
          upperBound = midle - 1;
        }
      }
    }
    return -1;
  }  
}