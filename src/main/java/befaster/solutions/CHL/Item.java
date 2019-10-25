package befaster.solutions.CHL;

import java.util.Objects;

public final class Item {
    private final String sku;
    private final int price;


    public Item(String sku, int price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Item)) {
            return false;
        }
        Item o = (Item) other;
        return Objects.equals(sku, o.sku) && Objects.equals(price, o.price);
    }
}

