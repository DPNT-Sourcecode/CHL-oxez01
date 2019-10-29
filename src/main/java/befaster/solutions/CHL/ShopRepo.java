package befaster.solutions.CHL;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Map;

public class ShopRepo {

    static final Item ITEM_A = new Item("A", 50);
    static final Item ITEM_B = new Item("B", 30);
    static final Item ITEM_C = new Item("C", 20);
    static final Item ITEM_D = new Item("D", 15);
    static final Item ITEM_E = new Item("D", 40);
    static final Item ITEM_F = new Item("F", 10);
    static final Item ITEM_G = new Item("G", 20);
    static final Item ITEM_H = new Item("H", 10);
    static final Item ITEM_I = new Item("I", 35);
    static final Item ITEM_J = new Item("J", 60);
    static final Item ITEM_K = new Item("K", 80);
    static final Item ITEM_L = new Item("L", 90);
    static final Item ITEM_M = new Item("M", 15);
    static final Item ITEM_N = new Item("N", 40);
    static final Item ITEM_O = new Item("O", 10);

    static final MultiItem.Offer offerA3 = new MultiItem.Offer(3, 130);
    static final MultiItem.Offer offerA5 = new MultiItem.Offer(5, 200);
    static final MultiItem MULTI_A = new MultiItem(ITEM_A, Lists.newArrayList(offerA3, offerA5));
    //
    static final MultiItem.Offer offerB2 = new MultiItem.Offer(2, 45);
    static final MultiItem MULTI_B = new MultiItem(ITEM_B, Lists.newArrayList(offerB2));
    //
    static final MultiItem.Offer offerH5 = new MultiItem.Offer(5, 45);
    static final MultiItem.Offer offerH10 = new MultiItem.Offer(10, 80);
    static final MultiItem MULTI_H = new MultiItem(ITEM_H, Lists.newArrayList(offerH5, offerH10));
    //
    static final MultiItem.Offer offerK2 = new MultiItem.Offer(2, 150);
    static final MultiItem MULTI_K = new MultiItem(ITEM_K, Lists.newArrayList(offerK2));


    static final Map<String, Item> items = new HashMap();
    static final Map<String, MultiItem> multiItems = new HashMap();

    static {
        items.put("A", ITEM_A);
        items.put("B", ITEM_B);
        items.put("C", ITEM_C);
        items.put("D", ITEM_D);
        items.put("E", ITEM_E);
        items.put("F", ITEM_F);
        items.put("G", ITEM_G);
        items.put("H", ITEM_H);
        items.put("I", ITEM_I);
        items.put("J", ITEM_J);
        items.put("K", ITEM_K);
        items.put("L", ITEM_L);
        items.put("M", ITEM_M);
        items.put("M", ITEM_N);
        items.put("O", ITEM_O);
        //
        multiItems.put("A", MULTI_A);
        multiItems.put("B", MULTI_B);
        multiItems.put("H", MULTI_H);
        multiItems.put("K", MULTI_K);
    }


    public Item getItem(String sku) {
        return items.get(sku);
    }

    public MultiItem getMultiItem(String sku) {
        return multiItems.get(sku);
    }

}


