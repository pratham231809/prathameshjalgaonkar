import java.util.Arrays;
import java.util.Scanner;
public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input array X[]
        System.out.print("Enter the size of array X: ");
        int m = scanner.nextInt();
        int[] X = new int[m];
        System.out.println("Enter the elements of array X: ");
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }
        // Input array Y[]
        System.out.print("Enter the size of array Y: ");
        int n = scanner.nextInt();
        int[] Y = new int[n];
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }
        scanner.close();
        mergeArrays(X, Y);
        // Sort the merged array
        Arrays.sort(X);
        System.out.println("Merged and sorted array: " + Arrays.toString(X));
    }
    public static void mergeArrays(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int i = m - 1; // Index of last element in X[]
        int j = n - 1; // Index of last element in Y[]
        int lastIndex = m - 1;
        // Move non-zero elements of X to the end
        for (int k = m - 1; k >= 0; k--) {
            if (X[k] != 0) {
                X[lastIndex--] = X[k];
            }
        }
        // Merge X and Y
        i = lastIndex + 1;
        int k = 0;
        while (i < m && j >= 0) {
            if (X[i] < Y[j]) {
                X[k++] = X[i++];
            } else {
                X[k++] = Y[j--];
            }
        }
        // Copy remaining elements of Y[] if any
        while (j >= 0) {
            X[k++] = Y[j--];
        }
    }
}

