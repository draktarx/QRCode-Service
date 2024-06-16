import java.math.BigDecimal;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigDecimal Dwalin = new BigDecimal(scanner.nextLine());
        BigDecimal Balin = new BigDecimal(scanner.nextLine());
        BigDecimal Thorin = new BigDecimal(scanner.nextLine());

        BigDecimal totalGold = Dwalin.add(Balin).add(Thorin);
        System.out.println(totalGold);
    }

}
