package befaster.solutions.CHL;

public class PricingImpl implements Pricing {

    private final ShopRepo repo;

    public PricingImpl(ShopRepo repo) {
        this.repo = repo;
    }

    @Override
    public int evaluate(BasketItem bi) {
        if (repo.isOnMultiOffer(bi.getItem().getSku())) {
            return calculateMultiPrice(bi);
        }
        return calculateSimplePrice(bi);
    }

    private int calculateSimplePrice(BasketItem bi) {
        return bi.getQuantity() * bi.getItem().getPrice();
    }

    private int calculateMultiPrice(BasketItem bi) {
        int total = 0;
        MultiItem multiItem = repo.getMultiItem(bi.getItem().getSku());
        if (bi.getQuantity() >= multiItem.getQuantity()) {
            int numberOfMultis = bi.getQuantity() / multiItem.getQuantity();
            total += numberOfMultis * multiItem.getPrice();
            int singlesRemaining = bi.getQuantity() % multiItem.getQuantity();
            total += singlesRemaining * bi.getItem().getPrice();
        }
        else {
            total += calculateSimplePrice(bi);
        }
        return total;
    }
}
