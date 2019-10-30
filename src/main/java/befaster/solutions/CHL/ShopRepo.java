package befaster.solutions.CHL;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    static final Item ITEM_P = new Item("P", 50);
    static final Item ITEM_Q = new Item("Q", 30);
    static final Item ITEM_R = new Item("R", 50);
    static final Item ITEM_S = new Item("S", 30);
    static final Item ITEM_T = new Item("T", 20);
    static final Item ITEM_U = new Item("U", 40);
    static final Item ITEM_V = new Item("V", 50);
    static final Item ITEM_W = new Item("W", 20);
    static final Item ITEM_X = new Item("X", 90);
    static final Item ITEM_Y = new Item("Y", 10);
    static final Item ITEM_Z = new Item("Z", 50);

    // volume promotions
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
    //
    static final MultiItem.Offer offerP5 = new MultiItem.Offer(5, 200);
    static final MultiItem MULTI_P = new MultiItem(ITEM_P, Lists.newArrayList(offerP5));
    //
    static final MultiItem.Offer offerQ3 = new MultiItem.Offer(3, 80);
    static final MultiItem MULTI_Q = new MultiItem(ITEM_Q, Lists.newArrayList(offerQ3));
    //
    static final MultiItem.Offer offerV2 = new MultiItem.Offer(2, 90);
    static final MultiItem.Offer offerV3 = new MultiItem.Offer(3, 130);
    static final MultiItem MULTI_V = new MultiItem(ITEM_V, Lists.newArrayList(offerV2, offerV3));



    static final BogofPromotion freebieForE = new BogofItem(ITEM_E, 2, ITEM_B, 1);
    static final BogofPromotion freebieForF = new BogofItem(ITEM_F, 3, ITEM_F, 1);
    static final BogofPromotion freebieForN = new BogofItem(ITEM_N, 3, ITEM_M, 1);
    static final BogofPromotion freebieForR = new BogofItem(ITEM_R, 3, ITEM_Q, 1);
    static final BogofPromotion freebieForU = new BogofItem(ITEM_U, 4, ITEM_U, 1);


    static final Map<String, Item> items = new HashMap();
    static final Map<String, MultiItem> multiItems = new HashMap();
    static final List<BogofPromotion> freebiePromotions  = new ArrayList<>();

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
        items.put("N", ITEM_N);
        items.put("O", ITEM_O);
        items.put("P", ITEM_P);
        items.put("Q", ITEM_Q);
        items.put("R", ITEM_R);
        items.put("S", ITEM_S);
        items.put("T", ITEM_T);
        items.put("U", ITEM_U);
        items.put("V", ITEM_V);
        items.put("W", ITEM_W);
        items.put("X", ITEM_X);
        items.put("Y", ITEM_Y);
        items.put("Z", ITEM_Z);
        //
        multiItems.put("A", MULTI_A);
        multiItems.put("B", MULTI_B);
        multiItems.put("H", MULTI_H);
        multiItems.put("K", MULTI_K);
        multiItems.put("P", MULTI_P);
        multiItems.put("Q", MULTI_Q);
        multiItems.put("V", MULTI_V);
        //
        freebiePromotions.add(freebieForE);
        freebiePromotions.add(freebieForF);
        freebiePromotions.add(freebieForN);
        freebiePromotions.add(freebieForR);
        freebiePromotions.add(freebieForU);
    }

    public List<VolumePromotion> volumePromotions() {
        return new ArrayList<>(multiItems.values());
    }

    public List<BogofPromotion> freebiePromotions() {
        return new ArrayList<>(freebiePromotions);
    }

    public Item getItem(String sku) {
        return items.get(sku);
    }

    public MultiItem getMultiItem(String sku) {
        return multiItems.get(sku);
    }

}

