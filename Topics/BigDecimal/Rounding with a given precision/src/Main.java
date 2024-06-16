import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.next();
        int newScale = scanner.nextInt();

        BigDecimal bigDecimal = new BigDecimal(numberStr);
        bigDecimal = bigDecimal.setScale(newScale, RoundingMode.HALF_DOWN);
        System.out.println(bigDecimal.toString());
    }

}
