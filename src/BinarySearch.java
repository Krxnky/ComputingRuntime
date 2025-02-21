import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public static void search(int n) {
        // Get numbers from sortednumb.txt
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("sortednumb.txt"));
            while(sc.hasNextInt()) {
                numbers.add(sc.nextInt());
            }
        } catch (FileNotFoundException err) {
            System.out.println("FileNotFoundException: " + err.getMessage());
        }

        long start = System.nanoTime();
        // Write Binary Search Logic Below
        int result = binarySearch(numbers, n, 0, numbers.size() - 1);
        long end = System.nanoTime();
        System.out.println("Binary Search: Took " + (end - start) / 1000000.0 + " ms to find " + n + " at index " + result);
        // Print completed time below
    }

    public static int binarySearch(ArrayList<Integer> list, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (list.get(mid) == target) {
            return mid;
        } else if (list.get(mid) > target) {
            return binarySearch(list, target, low, mid - 1);
        } else {
            return binarySearch(list, target, mid + 1, high);
        }
    }
}
