package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MultiItemTest {

    @Test
    public void checkMinimumQuantity() {
        ShopRepo repo = new ShopRepo();
        MultiItem a = repo.getMultiItem("A");
        assertThat(a.minimumMultiQuantity(), equalTo(3));

    }
}
