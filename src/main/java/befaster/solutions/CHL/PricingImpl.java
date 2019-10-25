package befaster.solutions.CHL;

public class PricingImpl implements Pricing {

    @Override
    public int evaluate(BasketItem bi) {
        return bi.getQuantity() * bi.getItem().getPrice();
    }
}
