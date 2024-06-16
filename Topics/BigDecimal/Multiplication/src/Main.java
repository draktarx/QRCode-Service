import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal number1 = new BigDecimal(scanner.next());
        BigDecimal number2 = new BigDecimal(scanner.next());
        BigDecimal result = number1.multiply(number2);
        System.out.println(result);
    }

}
