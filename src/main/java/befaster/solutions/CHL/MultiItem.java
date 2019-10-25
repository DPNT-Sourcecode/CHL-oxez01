package befaster.solutions.CHL;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MultiItem {

    private final Item item;
    private final List<Offer> offers;

    public MultiItem(Item item, List<Offer> offers) {
        this.item = item;
        this.offers = offers;
    }

    public List<Offer> getOffers() {
        return new LinkedList<>(offers);
    }

    //    public Item getItem() {
//        return item;
//    }


    static class Offer implements Comparable<Offer> {
        private final int quantity;
        private final int price;

        Offer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
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
            return 0;
        }
    }

}

