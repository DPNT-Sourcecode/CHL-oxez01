package befaster.solutions.CHL;

public class PricingImpl implements Pricing {

    private final ShopRepo repo;

    public PricingImpl(ShopRepo repo) {
        this.repo = repo;
    }

    @Override
    public int evaluate(BasketItem bi) {
        return bi.getQuantity() * bi.getItem().getPrice();
    }
}
