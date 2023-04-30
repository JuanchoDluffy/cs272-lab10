import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class MinHeap {
  // Implementing a Min Heap of Integers

  private ArrayList<Integer> heap;

  public MinHeap() {
    heap = new ArrayList<Integer>();
  }

  // zero based index
  private int leftChild(int i) {
    return 2 * i + 1;
  }

  // zero based index
  private int rightChild(int i) {
    return 2 * (i + 1);
  }

  // zero based index
  private int parent(int i) {
    return (i - 1) / 2;
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public String toString() {
    return "" + heap;
  }

  public int size() {
    return heap.size();
  }

  public void add(Integer v) {
    heap.add(v); // add at end
    reheapUp(heap.size() - 1); // reheap upward from the new node to its parent
  }

  private void reheapUp(int i) {
    if (i > 0) { // until you reach the root of the heap
      int parent = parent(i);
      if (heap.get(i) < heap.get(parent)) {
        // swap the parent and child
        Integer temp = heap.get(parent);
        heap.set(parent, heap.get(i));
        heap.set(i, temp);
        reheapUp(parent); // recur from the parent
      }
    }
  }

  private void reheapDown(int pos) {
    int leftPos = leftChild(pos);
    int rightPos = rightChild(pos);
    int minIndex = pos;
    if (leftPos < heap.size() && heap.get(leftPos) < heap.get(minIndex)) {
      minIndex = leftPos;
    }
    if (rightPos < heap.size() && heap.get(rightPos) < heap.get(minIndex)) {
      minIndex = rightPos;
    }
    if (minIndex != pos) {
      Integer temp = heap.get(pos);
      heap.set(pos, heap.get(minIndex));
      heap.set(minIndex, temp);
      reheapDown(minIndex);
    }
  }

  public Integer remove() {
    if (heap.isEmpty())
      return null;
    else {
      Integer res = heap.get(0);
      Integer newRoot = heap.get(heap.size() - 1);
      heap.set(0, newRoot);
      heap.remove(heap.size() - 1);
      reheapDown(0);
      return res;
    }

  }

  /*
   * The time complexity of the findSmallers method is O(n log n), where n is the
   * length of the input array.
   */
  public static int findSmallers(int[] array, int KthSmall) {
    MinHeap finder = new MinHeap();
    for (int i = 0; i < array.length; i++) {
      finder.add(array[i]);
    }
    int answer = -1;
    while (KthSmall > 0) {
      answer = finder.remove();
      KthSmall--;
    }
    return answer;
  }

  public static void main(String[] args) {
    MinHeap test1 = new MinHeap();
    test1.add(8);
    test1.add(6);
    test1.add(10);
    System.out.println("Initial Heap:\n" + test1);

    test1.add(4);
    test1.add(7);
    test1.add(5);
    System.out.println("Heap after adding more elements:\n" + test1);

    test1.add(15);
    test1.add(4);
    test1.add(7);
    test1.add(1);
    System.out.println("Heap after adding more elements:\n" + test1);
    test1.remove();
    System.out.println("Heap after removing the smallest element:\n" + test1);

    MinHeap test2 = new MinHeap();
    Random rand = new Random();

    for (int i = 0; i < 20; i++) {
      test2.add(rand.nextInt(1000)); // add a random integer between 0 and 99
    }
    System.out.println("Random Heap:\n" + test2);
    System.out.println("The smallest element is: " + test2.remove());
    System.out.println("Random number in order");
    while (!test2.isEmpty()) {
      System.out.print(test2.remove() + " ");
    }
    System.out.println();
    System.out.println("-----fidning the  K smallest elemetmt------");
    // Test case 1
    int[] arr1 = { 1, 2, 3, 4, 5 };
    int k1 = 2;
    int smallest1 = findSmallers(arr1, k1);
    System.out.println("The " + k1 + "th smallest element in " + Arrays.toString(arr1) + " is " + smallest1);

    // Test case 2
    int[] arr2 = { 10, 7, 8, 9, 4, 2, 6, 5, 1, 3 };
    int k2 = 4;
    int smallest2 = findSmallers(arr2, k2);
    System.out.println("The " + k2 + "th smallest element in " + Arrays.toString(arr2) + " is " + smallest2);

    // Test case 3
    int[] arr3 = { 5, 5, 5, 5, 5 };
    int k3 = 3;
    int smallest3 = findSmallers(arr3, k3);
    System.out.println("The " + k3 + "th smallest element in " + Arrays.toString(arr3) + " is " + smallest3);

    // Test case 4
    int[] arr4 = { 8, 6, 10, 4, 7, 5, 15, 4, 7, 1 };
    int k4 = 6;
    int smallest4 = findSmallers(arr4, k4);
    System.out.println("The " + k4 + "th smallest element in " + Arrays.toString(arr4) + " is " + smallest4);

  }
}