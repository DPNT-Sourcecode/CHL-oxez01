package befaster.solutions.CHL;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BogofItemTest {

    static final Item ITEM_A = new Item("A", 50);
    static final Item ITEM_B = new Item("A", 30);

    @Test
    public void equalsAndHashCodeFreebieSame() {
        // for 2A 1 A free
        BogofItem itemA1 = new BogofItem(ITEM_A, 2, ITEM_A, 1);
        BogofItem itemA2 = new BogofItem(ITEM_A, 2, ITEM_A, 1);
        assertThat(itemA1.equals(itemA2), equalTo(true));
        assertThat(itemA2.equals(itemA1), equalTo(true));
    }

    @Test
    public void equalsAndHashCodeFreebieDifferent() {
        // for 2A 1 A free
        BogofItem itemB1 = new BogofItem(ITEM_A, 3, ITEM_B, 2);
        BogofItem itemB2 = new BogofItem(ITEM_A, 3, ITEM_B, 2);
        assertThat(itemB1.equals(itemB2), equalTo(true));
        assertThat(itemB2.equals(itemB1), equalTo(true));
    }

    @Test
    public void correctlyAdjustsBasket() {
        BasketItem a1 = new BasketItem(ITEM_A, 3);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        //
        BogofItem itemA1 = new BogofItem(ITEM_A, 2, ITEM_A, 1);
        
    }
}
