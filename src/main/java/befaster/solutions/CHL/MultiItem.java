package befaster.solutions.CHL;

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
}
