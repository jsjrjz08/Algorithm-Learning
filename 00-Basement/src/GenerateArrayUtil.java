import java.util.Random;

public class GenerateArrayUtil {
    public static int[] generateOrderedArray(int n) {
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            result[i] = i;
        }

        return result;
    }
    public static int[] generateRandomArray(int n,int maxVal) {
        int[] result = new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++) {
            result[i] = random.nextInt(maxVal);
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

    public static void swap(int[] arr,int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr,String typeDesc,boolean isOrigin) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
            if(i != arr.length-1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(typeDesc+"-"+((isOrigin?"前":"后"))+":\t"+sb.toString());
    }
}
