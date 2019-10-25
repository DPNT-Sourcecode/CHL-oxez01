package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ItemTest {

    @Test
    public void equalsAndHashCodeSame() {
        Item item1 = new Item("A", 50);
        Item item2 = new Item("A", 50);
        assertThat(item1.equals(item2), equalTo(true));
        assertThat(item2.equals(item1), equalTo(true));
    }

    @Test
    public void equalsAndHashCodeDifferentPrice() {
        Item item1 = new Item("A", 50);
        Item item2 = new Item("A", 60);
        assertThat(item1.equals(item2), equalTo(false));
        assertThat(item2.equals(item1), equalTo(false));
    }

    @Test
    public void equalsAndHashCodeDifferentSku() {
        Item item1 = new Item("B", 60);
        Item item2 = new Item("A", 60);
        assertThat(item1.equals(item2), equalTo(false));
        assertThat(item2.equals(item1), equalTo(false));
    }

}


