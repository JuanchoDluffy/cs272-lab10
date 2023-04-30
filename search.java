import java.util.Arrays;

public class search {
  public static int binarySearch(int[] A, int e) {
    int lo = 0;
    int hi = A.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (A[mid] == e) {
        return mid;
      } else if (A[mid] < e) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int e1 = 5;
    int e2 = 10;
    int e3 = 0;
    int e4 = 1;
    int e5 = 9;

    System.out.println("Test 1:");
    System.out.println("Searching for " + e1 + " in array: " + Arrays.toString(A));
    System.out.println("Index of " + e1 + " is: " + binarySearch(A, e1)); // expected output: 4

    System.out.println("Searching for " + e2 + " in array: " + Arrays.toString(A));
    System.out.println("Index of " + e2 + " is: " + binarySearch(A, e2)); // expected output: -1

    System.out.println("Searching for " + e3 + " in array: " + Arrays.toString(A));
    System.out.println("Index of " + e3 + " is: " + binarySearch(A, e3)); // expected output: -1

    System.out.println("Searching for " + e4 + " in array: " + Arrays.toString(A));
    System.out.println("Index of " + e4 + " is: " + binarySearch(A, e4)); // expected output: 0

    System.out.println("Searching for " + e5 + " in array: " + Arrays.toString(A));
    System.out.println("Index of " + e5 + " is: " + binarySearch(A, e5)); // expected output: 8

    System.out.println("\nTest 2:");
    int[] test2 = new int[100];
    for (int i = 0; i < 100; i++) {
      test2[i] = i;
    }
    System.out.println("Searching for 46 in array: " + Arrays.toString(test2));
    System.out.println("Index of 46 is: " + binarySearch(test2, 46));

  }
}
