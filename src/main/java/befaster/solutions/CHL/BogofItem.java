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
        if (!(other instanceof BogofItem)) {
            return false;
        }
        BogofItem o = (BogofItem) other;
        return Objects.equals(item, o.item) && Objects.equals(eligibleQuantity, o.eligibleQuantity)
                && Objects.equals(freebie, o.freebie) && Objects.equals(freebieQuantity, o.freebieQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, eligibleQuantity, freebie, freebieQuantity);
    }


    @Override
    public Set<BasketItem> apply(Set<BasketItem> basket) {
        return null;
    }
}