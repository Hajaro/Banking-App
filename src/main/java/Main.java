import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final LoanCalculator loanCalculator = new LoanCalculator();
        final LoginFrame guiFrame = new LoginFrame();
        Double a = loanCalculator.calculateMonthlyPayment(10000, 1, 5);
        String[] customer = Login.login(true,"default_username","default_password");
        String social_security_number = customer[0];
        String role = customer[1];
        if (social_security_number.equals("Invalid login credentials")) {
            System.out.println("Invalid login credentials");
            return;
        }
        switch (role) {
            case "customer" -> {
                MenuCustomer menu = new MenuCustomer(social_security_number);
                menu.showMenu(social_security_number);
            }
            case "employee" -> {
                MenuEmployee menu = new MenuEmployee(social_security_number);
                menu.showMenu(social_security_number);
            }
            case "admin" -> {
                MenuAdmin menu = new MenuAdmin(social_security_number);
                menu.showMenu(social_security_number);
            }
            default -> System.out.println("Invalid role");
        }

    }
}