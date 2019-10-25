package befaster.solutions.CHL;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ShopRepoTest {


    @Test
    public void canRetrieveItem() {
        ShopRepo repo = new ShopRepo();
        assertThat(repo.getItem("A"), equalTo(ShopRepo.ITEM_A));
        assertThat(repo.getItem("B"), equalTo(ShopRepo.ITEM_B));
        assertThat(repo.getItem("C"), equalTo(ShopRepo.ITEM_C));
        assertThat(repo.getItem("D"), equalTo(ShopRepo.ITEM_D));
    }

    @Test
    public void canRetrieveMultiItem() {
        ShopRepo repo = new ShopRepo();
        assertThat(repo.getMultiItem("A"), equalTo(ShopRepo.MULTI_A));
        assertThat(repo.getMultiItem("B"), equalTo(ShopRepo.MULTI_B));
    }

}


