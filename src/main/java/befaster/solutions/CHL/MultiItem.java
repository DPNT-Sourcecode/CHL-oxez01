package befaster.solutions.CHL;

import java.util.*;

public class MultiItem implements Offer {

    private final Item item;
    private final List<Offer> offers;

    public MultiItem(Item item, List<Offer> offers) {
        this.item = item;
        this.offers = new ArrayList<>(offers);
        Collections.sort(this.offers);
    }

}

