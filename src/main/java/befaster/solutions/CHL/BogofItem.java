package befaster.solutions.CHL;

import java.util.Objects;
import java.util.Set;

public class BogofItem implements  BogofPromotion {

    private final Item item;
    private final int eligibleQuantity;

    private final Item freebie;
    private final int freebieQuantity;

    public BogofItem(Item item, int eligibleQuantity, Item freebie, int freebieQuantity) {
        this.item = item;
        this.eligibleQuantity = eligibleQuantity;
        this.freebie = freebie;
        this.freebieQuantity = freebieQuantity;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MultiItem.Offer)) {
            return false;
        }
        MultiItem.Offer o = (MultiItem.Offer) other;
        return Objects.equals(quantity, o.quantity) && Objects.equals(price, o.price);
    }
    @Override
    public Set<BasketItem> apply(Set<BasketItem> basket) {
        return null;
    }
}