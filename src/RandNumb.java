import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandNumb {
    private static final String filePath = "RandNumb.txt";

    public static void generate() {
        try {
            Random random = new Random();
            FileWriter fw = new FileWriter(filePath);

            for(int i=0; i<1000; i++) {
                try {
                    fw.write(random.nextInt(1000) + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            fw.close();
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
