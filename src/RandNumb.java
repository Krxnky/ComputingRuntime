import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RandNumb {
    private static final String filePath = "RandNumb.txt";

    public static void generate() {
        int size = 1000;
        int[] nums = new int[size];

        for(int i = 0; i < size; i++) {
            nums[i] = i;
        }

        Random random = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        try(FileWriter fw = new FileWriter(filePath)) {
            for(int x : nums) {
                fw.write(x + "\n");
            }
        } catch (IOException err) {
            System.out.println("IOException: " + err.getMessage());
        }
    }

    public static ArrayList<Integer> read() {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(filePath));
            while(sc.hasNextInt()) {
                result.add(sc.nextInt());
            }
        } catch (FileNotFoundException err) {
            System.out.println("FileNotFoundException: " + err.getMessage());
        }
        return result;
    }
}
