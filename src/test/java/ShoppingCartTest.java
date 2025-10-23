import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    void testEnglishBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"));
        assertEquals("Enter the number of items to purchase:", rb.getString("number_of_items"));
    }

    @Test
    void testFinnishBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("fi", "FI"));
        assertEquals("Syötä tuotteen hinta:", rb.getString("price_of_items"));
    }

    @Test
    void testJapaneseBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("ja", "JP"));
        assertEquals("「商品の数量を入力してください:」", rb.getString("quantity_of_items"));
    }

    @Test
    void testSwedishBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("sv", "SE"));
        assertEquals("Total kostnad:", rb.getString("total_cost"));
    }

}