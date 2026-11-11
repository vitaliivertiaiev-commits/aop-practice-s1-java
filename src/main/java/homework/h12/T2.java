package homework.h12;

// https://leetcode.com/problems/relative-sort-array/
public class T2 {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] frequencies = new int[1001];
    for (int value : arr1) {
      frequencies[value]++;
    }

    int[] result = new int[arr1.length];
    int index = 0;
    for (int value : arr2) {
      while (frequencies[value] > 0) {
        result[index++] = value;
        frequencies[value]--;
      }
    }

    for (int value = 0; value < frequencies.length; value++) {
      while (frequencies[value] > 0) {
        result[index++] = value;
        frequencies[value]--;
      }
    }
    return result;
  }
}
