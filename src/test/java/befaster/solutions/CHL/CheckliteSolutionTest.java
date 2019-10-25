package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckliteSolutionTest {

    @Test
    public void illegalInput() {
        CheckliteSolution checkout = new CheckliteSolution();
        assertThat(checkout.checklite("ABCD"), equalTo(-1));

    }
}

