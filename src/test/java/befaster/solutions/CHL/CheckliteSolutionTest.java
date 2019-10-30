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
        checkout = new CheckliteSolution(repo);
    }

    @Test
    public void illegalInputReturnsMinusOne() {
        assertThat(checkout.checklite("%"), equalTo(-1));
        assertThat(checkout.checklite("*"), equalTo(-1));
        assertThat(checkout.checklite("="), equalTo(-1));
    }

    @Test
    public void properInput() {
        assertThat(checkout.checklite("A"), equalTo(50));
        assertThat(checkout.checklite("AA"), equalTo(100));
        assertThat(checkout.checklite("AB"), equalTo(80));
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
    public void failedInitially() {
        assertThat(checkout.checklite("UUU"), equalTo(120));
        assertThat(checkout.checklite("UUUUUUUU"), equalTo(240));

    }

        @Test
    public void properInputWithFreebies() {
        assertThat(checkout.checklite("BEE"), equalTo(80));
        assertThat(checkout.checklite("BBEE"), equalTo(110));
    }

    @Test
    public void properInputWithFreebies2() {
        assertThat(checkout.checklite("FF"), equalTo(10));
        assertThat(checkout.checklite("FFF"), equalTo(20));
    }

}

