package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BasketItemTest {

    @Test
    public void equalsAndHashCodeSame() {
        BasketItem item1 = new BasketItem(new Item("A", 50), 2);
        BasketItem item2 = new BasketItem(new Item("A", 50), 2);
        assertThat(item1.equals(item2), equalTo(true));
        assertThat(item2.equals(item1), equalTo(true));
    }

    @Test
    public void equalsAndHashCodeDifferentItem() {
        BasketItem item1 = new BasketItem(new Item("B", 50), 2);
        BasketItem item2 = new BasketItem(new Item("A", 50), 2);
        assertThat(item1.equals(item2), equalTo(false));
        assertThat(item2.equals(item1), equalTo(false));
    }

    @Test
    public void equalsAndHashCodeDifferentQuantity() {
        BasketItem item1 = new BasketItem(new Item("A", 50), 2);
        BasketItem item2 = new BasketItem(new Item("A", 50), 4);
        assertThat(item1.equals(item2), equalTo(false));
        assertThat(item2.equals(item1), equalTo(false));
    }
}

