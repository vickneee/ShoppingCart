import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.NumberFormat;


public class ShoppingCart {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice = getChoice(scanner);

        Locale locale = getLocale(choice);

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);

        double totalPrice = getTotalPrice(messages, scanner);

        printResult(messages, currency, totalPrice);

        scanner.close();
    }

    private static int getChoice(Scanner scanner) {
        System.out.println("Select a language: \n1 = English \n2 = Finnish \n3 = Swedish \n4 = Japanese \n");

        return scanner.nextInt();
    }

    private static Locale getLocale(int choice) {

        Locale locale;
        switch (choice) {
            case 1 -> locale = new Locale("en", "US");
            case 2 -> locale = new Locale("fi", "FI");
            case 3 -> locale = new Locale("sv", "SE");
            case 4 -> locale = new Locale("ja", "JP");
            default -> locale = new Locale("en", "US");
        }
        return locale;
    }

    private static double getTotalPrice(ResourceBundle messages, Scanner scanner) {

        double totalPrice = 0.0;

        System.out.println(messages.getString("number_of_items"));
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {

            System.out.println(messages.getString("price_of_items"));
            double price = scanner.nextDouble();

            System.out.println(messages.getString("quantity_of_items"));
            int quantity = scanner.nextInt();

            totalPrice += price * quantity;
        }
        return totalPrice;
    }

    private static void printResult(ResourceBundle messages, NumberFormat currency, double totalPrice) {
        System.out.println(messages.getString("total_cost") + " " + currency.format(totalPrice));
    }
}
