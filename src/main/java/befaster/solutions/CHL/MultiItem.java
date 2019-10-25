package befaster.solutions.CHL;

import java.util.*;

public class MultiItem {

    private final Item item;
    private final List<Offer> offers;

    public MultiItem(Item item, List<Offer> offers) {
        this.item = item;
        this.offers = new ArrayList<>(offers);
        Collections.sort(this.offers);
    }

    public int minimumMultiQuantity() {
        return offers.get(offers.size() - 1).quantity;
    }

    public List<Offer> getOffers() {
        return offers;
    }
    static class Offer implements Comparable<Offer> {
        private final int quantity;
        private final int price;

        Offer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Offer)) {
                return false;
            }
            Offer o = (Offer) other;
            return Objects.equals(quantity, o.quantity) && Objects.equals(price, o.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(quantity, price);
        }

        @Override
        public int compareTo(Offer o) {
            return Integer.compare(o.quantity, quantity);
        }
    }

}


