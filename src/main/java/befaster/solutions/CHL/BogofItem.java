package befaster.solutions.CHL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public Set<BasketItem> apply(Set<BasketItem> basket) {
        Map<String, BasketItem> basketAsMap = basket.stream().collect(Collectors.toMap(i -> i.getItem().getSku(), Function.identity());
        Optional<BasketItem> bi = basket.stream().filter(i -> i.getItem().getSku().equals(item.getSku())).findFirst();
        if (bi.isPresent() && bi.get().getQuantity() >= eligibleQuantity) {
            // if freebie in basket, subtract quantity
            Optional<BasketItem> freebi = basket.stream().filter(i -> i.getItem().getSku().equals(freebie.getSku())).findFirst();
            if (freebi.isPresent()) {
                BasketItem newItem = new BasketItem(freebie, Math.max(0, freebi.get().getQuantity() - freebieQuantity));
//                basket.iterator().remove(freebi.get());
            }
        }
        Set<BasketItem> newBasket = new HashSet<>();
        return null;
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

}


