import java.util.Arrays;
import java.util.Scanner;

public class sortArray {
    public static void main(String[] args) {

        
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Number of elements: ");
        // int n = scanner.nextInt();
        // int[] array = new int[n];
        // System.out.println("Enter your array: ");
        // for (int i = 0; i < n; i++) {
        //     array[i] = scanner.nextInt();
        // }
        // scanner.close();

        int[] array = {5, 2, 9, 1, 7};

        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        double average = (double) sum / array.length;
        System.out.println("Average: " + average);
    }
}