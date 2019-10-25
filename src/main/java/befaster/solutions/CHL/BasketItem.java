package befaster.solutions.CHL;

import java.util.Objects;

public class BasketItem {

    private final Item item;
    private final int quantity;

    public BasketItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BasketItem)) {
            return false;
        }
        BasketItem o = (BasketItem) other;
        return Objects.equals(item, o.item) && Objects.equals(quantity, o.quantity);
    }
}

