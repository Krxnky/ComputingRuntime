import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class BubbleSort {
    public static void sort() {
        ArrayList<Integer> numbers = RandNumb.read();

        // Write Bubble Sort Logic Below
        long start = System.nanoTime();
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Bubble Sort: Took " + (end - start) / 1000000.0 + " ms to sort " + n + " numbers");
        // Save to sortednumb.txt
        try {
            FileWriter fw = new FileWriter("sortednumb.txt");
            for(int i = 0; i < n; i++) {
                fw.write(numbers.get(i) + "\n");
            }
            fw.close();
        } catch (IOException err) {
            System.out.println("IOException: " + err.getMessage());
        }
    }
}
