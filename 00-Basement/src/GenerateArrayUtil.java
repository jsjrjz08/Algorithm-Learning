import java.util.Random;

public class GenerateArrayUtil {
    public static int[] generateOrderedArray(int n) {
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            result[i] = i;
        }

        return result;
    }

    public static int[] generateRandomArray(int n) {
        int[] result = new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++) {
            result[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return result;
    }
}
