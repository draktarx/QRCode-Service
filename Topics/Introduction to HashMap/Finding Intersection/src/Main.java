import java.util.HashMap;
import java.util.Scanner;

class Main {

    private static void printCommon(int[] firstArray, int[] secondArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : firstArray) {
            map.merge(num, 1, Integer::sum);
        }

        for (int num : secondArray) {
            if (map.getOrDefault(num, 0) > 0) {
                System.out.print(num + " ");
                map.merge(num, -1, Integer::sum);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        for (int i = 0; i < n; ++i) {
            firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            secondArray[i] = scanner.nextInt();
        }

        printCommon(firstArray, secondArray);
    }

}
