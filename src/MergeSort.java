import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

public class MergeSort {
    public static void sort() {
        ArrayList<Integer> numbers = RandNumb.read();

        // Write Merge Sort Logic Below
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long start = threadMXBean.getCurrentThreadCpuTime();
        mergeSort(numbers);
        long end = threadMXBean.getCurrentThreadCpuTime();
        // Save to sortednumb.txt
        try {
            FileWriter fw = new FileWriter("sortednumb.txt");
            for (Integer number : numbers) {
                fw.write(number + "\n");
            }
            fw.close();
        } catch (IOException err) {
            System.out.println("IOException: " + err.getMessage());
        }
        // Print completed time below
        System.out.println("Merge Sort: Took " + (end - start) / 1000000.0 + " ms to sort " + numbers.size() + " numbers");
    }

    private static void merge(ArrayList<Integer> list, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }
}
