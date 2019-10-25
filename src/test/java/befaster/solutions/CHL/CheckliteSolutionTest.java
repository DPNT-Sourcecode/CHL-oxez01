package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckliteSolutionTest {

    @Test
    public void illegalInputReturnsMinusOne() {
        CheckliteSolution checkout = new CheckliteSolution(repo, pricing);
        assertThat(checkout.checklite("E"), equalTo(-1));
        assertThat(checkout.checklite("ABE"), equalTo(-1));
        assertThat(checkout.checklite("FA"), equalTo(-1));

    }
}

