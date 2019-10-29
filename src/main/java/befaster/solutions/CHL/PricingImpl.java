package befaster.solutions.CHL;

import java.util.Iterator;
import java.util.List;

public class PricingImpl implements Pricing {

    private final ShopRepo repo;

    public PricingImpl(ShopRepo repo) {
        this.repo = repo;
    }

    @Override
    public int evaluate(BasketItem bi) {
//        if (repo.isOnMultiOffer(bi.getItem().getSku())) {
//            return calculateMultiPrice(bi);
//        }
        return calculateSimplePrice(bi);
    }

    private int calculateSimplePrice(BasketItem bi) {
        return bi.getQuantity() * bi.getItem().getPrice();
    }

//    private int calculateMultiPrice(BasketItem bi) {
//
//        MultiItem multiItem = repo.getMultiItem(bi.getItem().getSku());
//        if (bi.getQuantity() < multiItem.minimumMultiQuantity()) {
//            return calculateSimplePrice(bi);
//        } else {
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
//    }

}
