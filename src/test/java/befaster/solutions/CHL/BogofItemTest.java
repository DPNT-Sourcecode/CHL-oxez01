package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class BogofItemTest {

    static final Item ITEM_A = new Item("A", 50);
    static final Item ITEM_B = new Item("A", 30);

    @Test
    public void equalsAndHashCodeSame() {
        BogofItem item1 = new BogofItem(ITEM_A, 2, ITEM_A, 1)
        BogofItem item2 = new BogofItem(ITEM_A, 2, ITEM_A, 1)
        assertThat(item1.equals(item2), equalTo(true));
        assertThat(item2.equals(item1), equalTo(true));
    }

}
