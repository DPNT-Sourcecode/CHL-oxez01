package befaster.solutions.CHL;

import java.util.*;

public class MultiItem implements Offer {

//    static final MultiItem.Offer offerA3 = new MultiItem.Offer(3, 130);
//    static final MultiItem.Offer offerA5 = new MultiItem.Offer(5, 200);

    private final Item item;
    private final int eligibleQuantity;
    private final int price;

    public MultiItem(Item item, int eligibleQuantity, int price) {
        this.item = item;
        this.eligibleQuantity = eligibleQuantity;
        this.price = price;
    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public int getEligibleQuantity() {
//        return eligibleQuantity;
//    }

    @Override
    public int discount(Set<BasketItem> basket) {
        Optional<BasketItem> bi = basket.stream().filter(i -> i.getItem().getSku().equals(item.getSku())).findFirst();
        if (bi.isPresent() && bi.get().getQuantity() >= eligibleQuantity) {
            // calculate the discount
            int quantity = bi.get().getQuantity();
            int numberOfMultis = quantity / eligibleQuantity;


        }
        // else no discount
        return 0;
//            int total = 0;
//            int quantity = bi.getQuantity();
//            Iterator<MultiItem.Offer> iterator = multiItem.getOffers().iterator();
//            while (iterator.hasNext()) {
//                MultiItem.Offer next = iterator.next();
//                int numberOfMultis = quantity / next.getQuantity();
//                total += numberOfMultis * next.getPrice();
//                quantity %= next.getQuantity();
//            }
//            return total +  quantity * bi.getItem().getPrice();
//        }
        return 0;
    }
}



