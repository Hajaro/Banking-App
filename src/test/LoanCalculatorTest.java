import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {
    LoanCalculator loanCalculator = new LoanCalculator();
    @Test
    void calculateMonthlyPayment() {
        assertEquals(NaN, loanCalculator.calculateMonthlyPayment(0, 0, 0));
        assertEquals(8.545138334471583, loanCalculator.calculateMonthlyPayment(1000, 10, 0.5));
        assertEquals(8.760412137016194, loanCalculator.calculateMonthlyPayment(1000, 10, 1));
        assertEquals(2.649388371498615, loanCalculator.calculateMonthlyPayment(100, 5, 20));
        assertEquals(856.0748178846737, loanCalculator.calculateMonthlyPayment(10000, 1, 5));
    }
}