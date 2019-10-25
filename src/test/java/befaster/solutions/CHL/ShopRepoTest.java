package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShopRepoTest {


    @Test
    public void canRetrieveItem() {
        ShopRepo repo = new ShopRepo();
        assertThat(repo.getItem("A"), equalTo(ShopRepo.ITEM_A));
    }
}

