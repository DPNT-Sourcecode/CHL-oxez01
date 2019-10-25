package befaster.solutions.CHL;

import java.util.Objects;

public class MultiItem {

    private final Item item;
    private final int quantity;
    private final int price;

    public MultiItem(Item item, int quantity, int price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MultiItem)) {
            return false;
        }
        MultiItem o = (MultiItem) other;
        return Objects.equals(item, o.item) && Objects.equals(quantity, o.quantity) && Objects.equals(price, o.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, quantity, price);
    }
}

