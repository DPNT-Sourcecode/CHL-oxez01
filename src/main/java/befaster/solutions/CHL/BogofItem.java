package befaster.solutions.CHL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BogofItem implements BogofPromotion {

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
        Map<String, BasketItem> basketAsMap = basket.stream().collect(Collectors.toMap(i -> i.getItem().getSku(), Function.identity(), (prev, next) -> next, HashMap::new));
        if (basketAsMap.containsKey(item.getSku())) {
            BasketItem bi = basketAsMap.get(item.getSku());
            if (bi.getQuantity() >= eligibleQuantity && basketAsMap.containsKey(freebie.getSku())) {
                // if freebie in basket, subtract numFreebies*quantity
                int numFreebies = bi.getQuantity() / eligibleQuantity;
                BasketItem freebiebi = basketAsMap.get(freebie.getSku());
                BasketItem newFreebie = new BasketItem(freebie, Math.max(0, freebiebi.getQuantity() - freebieQuantity));
                basketAsMap.replace(freebie.getSku(), newFreebie);
            }
            return new HashSet<>(basketAsMap.values());
        }
        return basket;
    }


        @Override
        public boolean equals (Object other){
            if (!(other instanceof BogofItem)) {
                return false;
            }
            BogofItem o = (BogofItem) other;
            return Objects.equals(item, o.item) && Objects.equals(eligibleQuantity, o.eligibleQuantity)
                    && Objects.equals(freebie, o.freebie) && Objects.equals(freebieQuantity, o.freebieQuantity);
        }

        @Override
        public int hashCode () {
            return Objects.hash(item, eligibleQuantity, freebie, freebieQuantity);
        }

    }

