package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class PricingImplTest {

    @Test
    public void evaluateItemNotOnOffer() {
        Pricing pricing = new PricingImpl();
        BasketItem bi = new BasketItem(new Item("A", 10), 2);
        assertThat(pricing.evaluate(bi), equalTo(20));
    }

    @Test
    public void evaluateItemNotOnOffer() {
        Pricing pricing = new PricingImpl();
        BasketItem bi = new BasketItem(new Item("A", 10), 1);
        assertThat(pricing.evaluate(bi), equalTo(10));
    }

}