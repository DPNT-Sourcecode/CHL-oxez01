package befaster.solutions.CHL;

import com.google.common.collect.Lists;
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

    static final MultiItem.Offer offerA3 = new MultiItem.Offer(3, 130);
    static final MultiItem.Offer offerA5 = new MultiItem.Offer(5, 200);
    static final MultiItem MULTI_A = new MultiItem(ITEM_A, Lists.newArrayList(offerA3, offerA5));

}

