import java.util.ArrayList;

public class LinearSearch {
    public static void search(int n) {
        ArrayList<Integer> numbers = RandNumb.read();

        // Write Linear Search Logic Below
        long start = System.nanoTime();
        int result = linearSearch(numbers, n);
        long end = System.nanoTime();
        // Print completed time below
        System.out.println("Linear Search: Took " + (end - start) / 1000000.0 + " ms to find " + n + " at index " + result);
    }

    private static int linearSearch(ArrayList<Integer> arr, int n) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == n) {
                return i;
            }
        }
        return -1;
    }
}
