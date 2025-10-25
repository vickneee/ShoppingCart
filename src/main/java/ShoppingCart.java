import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a language: \n1 = English \n2 = Finnish \n3 = Swedish \n4 = Japanese \n");

        int choice = scanner.nextInt();

        Locale locale;
        switch (choice) {
            case 1 -> locale = new Locale("en", "US");
            case 2 -> locale = new Locale("fi", "FI");
            case 3 -> locale = new Locale("sv", "SE");
            case 4 -> locale = new Locale("ja", "JP");
            default -> locale = new Locale("en", "US");
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);

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

        System.out.println(messages.getString("total_cost") + " " + currency.format(totalPrice));

        scanner.close();
    }
}
