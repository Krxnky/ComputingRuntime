import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

public class QuickSort {
    public static void sort() {
        ArrayList<Integer> numbers = RandNumb.read();

        // Write Quick Sort Logic Below
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long start = threadMXBean.getCurrentThreadCpuTime();
        quickSort(numbers, 0, numbers.size() - 1);
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
        System.out.println("Quick Sort: Took " + (end - start) / 1000000.0 + " ms to sort " + numbers.size() + " numbers");
    }

    public static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);

            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
