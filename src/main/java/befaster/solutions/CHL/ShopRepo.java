package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

public class ShopRepo {

    static final Item ITEM_A = new Item("A", 50);
    static final Item ITEM_B = new Item("B", 30);
    static final Item ITEM_C = new Item("C", 20);
    static final Item ITEM_D= new Item("D", 15);

    static final MultiItem MULTI_A = new MultiItem(ITEM_A, 3, 130);
    static final MultiItem MULTI_B = new MultiItem(ITEM_B, 2, 45);
    //
    static final Map<String, Item> items = new HashMap();
    static final Map<String, MultiItem> multiItems = new HashMap();

    static {
        items.put("A", ITEM_A);
        items.put("B", ITEM_B);
        items.put("C", ITEM_C);
        items.put("D", ITEM_D);
        //
        multiItems.put("A", MULTI_A);
        multiItems.put("B", MULTI_B);
    }


    public Item getItem(String sku) {
        return items.get(sku);
    }

    public MultiItem getMultiItem(String sku) {
        return multiItems.get(sku);
    }

    public boolean isOnMultiOffer(String sku) {
        return multiItems.containsKey(sku);
    }
}
