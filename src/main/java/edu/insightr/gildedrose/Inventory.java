package edu.insightr.gildedrose;

import java.util.Arrays;

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


    // 1- Add to github and add a tag
    // 2- Create a branch named "visitor"
    // 3- use the visitor pattern

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }


    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].getQuality() > 0) {
                    if (items[i].getName() != "Sulfuras, Hand of Ragnaros"
                        && items[i].getName() != "Conjured Mana Cake") {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                    else if(items[i].getName() != "Sulfuras, Hand of Ragnaros"){
                        items[i].setQuality(items[i].getQuality() - 2);
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].getName())) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getQuality() > 0) {
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros"
                                    && items[i].getName() != "Conjured Mana Cake") {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                            else if(items[i].getName() != "Sulfuras, Hand of Ragnaros"){
                                items[i].setQuality(items[i].getQuality() - 2);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }


   /* public void superTruc(){
        Visitor visitorQuality = new VisitorQuality();
        Visitor visitorSellIn = new VisitorSellIn();
        for (int i = 0; 1 < items.length;i++){
            item.accept(visitorQuality);
            item.accept(visitorSellIn);
        }

    }*/

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
