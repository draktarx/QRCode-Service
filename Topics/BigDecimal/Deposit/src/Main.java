import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal startingAmount = new BigDecimal(scanner.next());
        BigDecimal interestRate = new BigDecimal(scanner.next());
        BigDecimal numOfYears = new BigDecimal(scanner.next());

        BigDecimal yearlyPercent = interestRate.divide(new BigDecimal(100));
        BigDecimal totalAmount = startingAmount.multiply(BigDecimal.ONE.add(yearlyPercent)
                                                                       .pow(numOfYears.intValue()))
                                               .setScale(2, RoundingMode.CEILING);

        System.out.println("Amount of money in the account: " + totalAmount);
    }

}
