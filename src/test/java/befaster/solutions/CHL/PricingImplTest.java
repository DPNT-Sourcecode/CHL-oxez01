package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class PricingImplTest {

    private ShopRepo repo = new ShopRepo();

    @Test
    public void evaluateItemNotOnOffer() {
        Pricing pricing = new PricingImpl(repo);
        BasketItem bi = new BasketItem(new Item("D", 15), 1);
        assertThat(pricing.evaluate(bi), equalTo(15));
    }

    @Test
    public void evaluateItemOnMultiOfferButNotEnoughQunatity() {
        Pricing pricing = new PricingImpl(repo);
        BasketItem bi = new BasketItem(new Item("A", 50), 2);
        assertThat(pricing.evaluate(bi), equalTo(100));
    }

    @Test
    public void evaluateItemOnMultiOffer() {
        Pricing pricing = new PricingImpl(repo);
        BasketItem bi = new BasketItem(new Item("A", 50), 3);
        assertThat(pricing.evaluate(bi), equalTo(130));
    }

    @Test
    public void evaluateItemOnMultiOfferManyTimes() {
        Pricing pricing = new PricingImpl(repo);
        BasketItem bi = new BasketItem(new Item("A", 50), 6);
        assertThat(pricing.evaluate(bi), equalTo(260));
    }

    @Test
    public void evaluateItemOnMultiOfferWithRemainder() {
        Pricing pricing = new PricingImpl(repo);
        BasketItem bi = new BasketItem(new Item("A", 50), 8);
        assertThat(pricing.evaluate(bi), equalTo(330));
    }


}
