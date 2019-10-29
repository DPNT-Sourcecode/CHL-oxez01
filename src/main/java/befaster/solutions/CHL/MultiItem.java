package befaster.solutions.CHL;

import java.util.*;

public class MultiItem implements Promotion {

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

    @Override
    public int discount(Set<BasketItem> basket) {
        // check if basket contains item and if it does calculate the notional discount
        Optional<BasketItem> bi = basket.stream().filter(i -> i.getItem().getSku().equals(item.getSku())).findAny();
        if (bi.isPresent() && bi.get().getQuantity() > minimumMultiQuantity()) {
            int quantity = bi.get().getQuantity();
            int totalDiscount = 0;
            Iterator<Offer> iterator = offers.iterator();
            while (iterator.hasNext()) {
                MultiItem.Offer next = iterator.next();
                int numberOfMultis = quantity / next.getQuantity();
                totalDiscount += next.getPrice() - numberOfMultis * item.getPrice();
                quantity %= next.getQuantity();
            }
            return totalDiscount;
        }
        return 0;
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





