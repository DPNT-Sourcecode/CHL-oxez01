package befaster.solutions.CHL;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MultiItemTest {

    static final Item ITEM_A = new Item("A", 50);
    static final MultiItem.Offer offerA3 = new MultiItem.Offer(3, 130);
    static final MultiItem.Offer offerA5 = new MultiItem.Offer(5, 200);
    static final MultiItem MULTI_A = new MultiItem(ITEM_A, Lists.newArrayList(offerA3, offerA5));

    @Test
    public void checkMinimumQuantity() {
        ShopRepo repo = new ShopRepo();
        MultiItem a = repo.getMultiItem("A");
        assertThat(a.minimumMultiQuantity(), equalTo(3));
    }

    @Test
    public void calculateDiscountUnderMinimumQuantity() {
        BasketItem a1 = new BasketItem(ITEM_A, 1);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        assertThat(MULTI_A.discount(basket), equalTo(0));
    }

    @Test
    public void calculateDiscountOverMinimumQuantityOne() {
        BasketItem a1 = new BasketItem(ITEM_A, 3);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        assertThat(MULTI_A.discount(basket), equalTo(20));
    }

    @Test
    public void calculateDiscountBetweenOfferQuantities() {
        BasketItem a1 = new BasketItem(ITEM_A, 4);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        assertThat(MULTI_A.discount(basket), equalTo(20));
    }


    @Test
    public void calculateDiscountMinimumQuantityTwo() {
        BasketItem a1 = new BasketItem(ITEM_A, 5);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        assertThat(MULTI_A.discount(basket), equalTo(50));
    }

    @Test
    public void calculateDiscountOverMinimumQuantityTwo() {
        // 5 + 3 + 1 == discount 70
        BasketItem a1 = new BasketItem(ITEM_A, 9);
        Set<BasketItem> basket = Sets.newHashSet(a1);
        assertThat(MULTI_A.discount(basket), equalTo(70));
    }

}
