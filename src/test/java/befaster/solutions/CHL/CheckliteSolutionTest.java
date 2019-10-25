package befaster.solutions.CHL;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckliteSolutionTest {

    ShopRepo repo = new ShopRepo();
    CheckliteSolution checkout = new CheckliteSolution(repo, new PricingImpl(repo));

    @Test
    public void illegalInputReturnsMinusOne() {
        assertThat(checkout.checklite("E"), equalTo(-1));
        assertThat(checkout.checklite("ABE"), equalTo(-1));
        assertThat(checkout.checklite("FA"), equalTo(-1));
    }

    @Test
    public void basketCreatedCorrectly() {
        BasketItem bi = new BasketItem(repo.getItem("A"), 2);
        Set<BasketItem> basket = new HashSet<>();
        basket.add(bi);
        assertThat(checkout.createBasket("AA"), equalTo(basket));
    }



    @Test
    public void properInput() {
        assertThat(checkout.checklite("A"), equalTo(50));
    }
}
