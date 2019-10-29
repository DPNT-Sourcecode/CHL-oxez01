package befaster.solutions.CHL;

import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckliteSolutionTest {

    private static CheckliteSolution checkout;

    @BeforeClass
    public static void setupShop() {
        ShopRepo repo = new ShopRepo();
        List<Promotion> promotions = Lists.newArrayList(repo.getMultiItem("A"), repo.getMultiItem("B"));
        BogofPromotion freebieForE = new BogofItem(repo.getItem("E"), 2, repo.getItem("B"), 1);
        BogofPromotion freebieForF = new BogofItem(repo.getItem("F"), 2, repo.getItem("F"), 1);
        List<BogofPromotion> freebies = Lists.newArrayList(freebieForE, freebieForF);
        checkout = new CheckliteSolution(repo, new PricingImpl(repo), promotions, freebies);
    }

    @Test
    public void illegalInputReturnsMinusOne() {
        assertThat(checkout.checklite("G"), equalTo(-1));
        assertThat(checkout.checklite("ABG"), equalTo(-1));
        assertThat(checkout.checklite("GA"), equalTo(-1));
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
        assertThat(checkout.checklite("BBEE"), equalTo(110));
    }

    @Test
    public void properInputWithFreebies2() {
        assertThat(checkout.checklite("FF"), equalTo(20));
        assertThat(checkout.checklite("FFF"), equalTo(20));
    }

}

