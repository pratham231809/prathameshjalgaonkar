import java.util.ArrayList;
import java.util.Scanner;

public class MaximumSumPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array X: ");
        int m = scanner.nextInt();
        int[] X = new int[m];
        System.out.println("Enter the elements of array X (sorted):");
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of array Y: ");
        int n = scanner.nextInt();
        int[] Y = new int[n];
        System.out.println("Enter the elements of array Y (sorted):");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        scanner.close();

        ArrayList<Integer> maxPath = new ArrayList<>();
        int maxSum = findMaximumSumPath(X, Y, maxPath);

        System.out.println("The maximum sum path is:");
        printMaximumSumPath(maxPath);
        System.out.println("The maximum sum is: " + maxSum);
    }

    public static int findMaximumSumPath(int[] X, int[] Y, ArrayList<Integer> maxPath) {
        int m = X.length;
        int n = Y.length;
        int i = 0, j = 0;
        int sumX = 0, sumY = 0, maxSum = 0;

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else { // Common element found, choose maximum sum path
                maxSum += Math.max(sumX, sumY) + X[i];
                maxPath.add(X[i]);
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sumX += X[i++];
        }

        while (j < n) {
            sumY += Y[j++];
        }

        maxSum += Math.max(sumX, sumY);

        return maxSum;
    }

    public static void printMaximumSumPath(ArrayList<Integer> maxPath) {
        for (int i = 0; i < maxPath.size() - 1; i++) {
            System.out.print(maxPath.get(i) + " -> ");
        }
        System.out.println(maxPath.get(maxPath.size() - 1) + " -> End");
    }
}
