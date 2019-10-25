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
    public void properInput() {
        assertThat(checkout.checklite("A"), equalTo(50));
        assertThat(checkout.checklite("AA"), equalTo(100));
        assertThat(checkout.checklite("AB"), equalTo(80));
    }

    @Test
    public void properInputWithMultis() {
        assertThat(checkout.checklite("AAABB"), equalTo(175));
        assertThat(checkout.checklite("ABB"), equalTo(95));
        assertThat(checkout.checklite("BBB"), equalTo(75));
        assertThat(checkout.checklite("BBBCD"), equalTo(110));
        assertThat(checkout.checklite("AAA"), equalTo(130));
    }


    @Test
    public void properInputWithFreebies() {
        assertThat(checkout.checklite("BEE"), equalTo(80));
    }

}

