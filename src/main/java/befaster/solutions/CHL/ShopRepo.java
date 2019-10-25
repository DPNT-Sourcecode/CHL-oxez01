package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

public class ShopRepo {

    Item itemA = new Item("A", 50);
    MultiItem multiA = new MultiItem(itemA, 3, 130);
    Item itemB = new Item("B", 30);
    MultiItem multiB = new MultiItem(itemB, 2, 45);
    Item itemC = new Item("C", 20);
    Item itemD = new Item("D", 15);
    //
    Map<String, Item> items = new HashMap();
    items.put("A", itemA);
    Map<String, MultiItem> multiItems = new HashMap();

}
