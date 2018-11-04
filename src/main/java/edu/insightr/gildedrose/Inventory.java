package edu.insightr.gildedrose;

public class Inventory {

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }
    //new update Quality
    public  void updateQuality() {
        //use interface ItemStrategy to Encapsulate the different strategy
        ItemStrategy itemStrategy;
        for (Item item : items) {
            switch (item.getName()) {
                case "Aged Brie":
                    itemStrategy = new AgedBrie();
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    itemStrategy = new BackstagePasses();
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    itemStrategy = new Sulfuras();
                    break;
                case "Conjured Mana Cake":
                    itemStrategy = new Conjured();
                    break;
                default:
                    itemStrategy = new NormalItem();
            }
            itemStrategy.update(item);
        }
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}