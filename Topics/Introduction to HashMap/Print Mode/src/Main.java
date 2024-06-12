import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Main {

    private static void printMode(int[] map) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i : map) {
            countMap.merge(i, 1, Integer::sum);
        }

        int mode = Integer.MIN_VALUE;
        int maxCount = 0;

        for (var entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        System.out.println(mode + " " + maxCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] map = new int[n];
        for (int i = 0; i < n; ++i) {
            map[i] = scanner.nextInt();
        }

        printMode(map);
    }

}
