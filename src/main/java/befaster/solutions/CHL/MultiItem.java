package befaster.solutions.CHL;

import java.util.*;

public class MultiItem implements Offer {

//    static final MultiItem.Offer offerA3 = new MultiItem.Offer(3, 130);
//    static final MultiItem.Offer offerA5 = new MultiItem.Offer(5, 200);

    private final Item item;
    private final int eligibleQuantity;

    public MultiItem(Item item, int eligibleQuantity) {
        this.item = item;
        this.eligibleQuantity = eligibleQuantity;
    }

    public Item getItem() {
        return item;
    }

    public int getEligibleQuantity() {
        return eligibleQuantity;
    }

    @Override
    public int dicount(Set<BasketItem> basket) {
        return 0;
    }
}


