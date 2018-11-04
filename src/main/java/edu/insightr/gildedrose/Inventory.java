package edu.insightr.gildedrose;
/*
import java.awt.*;
import java.util.Arrays;
*/
public class Inventory<items> {

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
    public void Visitor (){
        for (int i = 0; i < items.length; i++) {
            //visit +5 Dexterity Vest
            if ("+5 Dexterity Vest".equals(items[i].getName())){
                //SellIn >= 0
                if (items[i].getSellIn() >= 0
                        && items[i].getQuality() > 0){
                    items[i].setQuality(items[i].getQuality() - 1);
                }
                //SellIn < 0
                else if (items[i].getSellIn() < 0
                        && items[i].getQuality() > 0){
                    items[i].setQuality(items[i].getQuality() - 2);
                }
                items[i].setSellIn(items[i].getSellIn() - 1);
                // check Quality
                if (items[i].getQuality() <= 0){
                    items[i].setQuality(0);
                }
            }
            //visit Aged Brie
            if ("Aged Brie".equals(items[i].getName())) {
                //SellIn >= 0
                if (items[i].getSellIn() >= 0
                        && items[i].getQuality() > 0
                        && items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);
                }
                //SellIn < 0
                else if (items[i].getSellIn() < 0
                        && items[i].getQuality() > 0
                        && items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 2);
                }
                    items[i].setSellIn(items[i].getSellIn() - 1);
                // check Quality
                if (items[i].getQuality() >= 50) {
                    items[i].setQuality(50);
                }
                }

            //visit Elixir of the Mongoose
            if ("Elixir of the Mongoose".equals(items[i].getName())){
            //SellIn > 0
            if (items[i].getSellIn() >= 0
                    && items[i].getQuality() > 0){
                items[i].setQuality(items[i].getQuality() - 1);
            }
            //SellIn < 0
            else if (items[i].getSellIn() < 0
                    && items[i].getQuality() > 0){
                items[i].setQuality(items[i].getQuality() - 2);
            }
            items[i].setSellIn(items[i].getSellIn() - 1);
                // check Quality
                if (items[i].getQuality() <= 0){
                    items[i].setQuality(0);
                }
            }
            //visit Sulfuras, Hand of Ragnaros
            if ("Sulfuras, Hand of Ragnaros".equals(items[i].getName())){
                items[i].setQuality(items[i].getQuality());
                items[i].setSellIn(items[i].getSellIn());
            }
            //visit Backstage passes to a TAFKAL80ETC concert
            if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].getName())){
                if(items[i].getSellIn() <= 0){
                    items[i].setQuality(0);
                }
                else if(items[i].getSellIn() >= 50){
                    items[i].setQuality(items[i].getQuality());
                }
                //SellIn <= 5
                else if(items[i].getSellIn() <= 5
                        && items[i].getQuality() < 50){
                    items[i].setQuality(items[i].getQuality() + 3);
                }
                //SellIn <= 10
                else if(items[i].getSellIn() <= 10
                        && items[i].getQuality() < 50){
                    items[i].setQuality(items[i].getQuality() + 2);
                }
                //SellIn > 10
                else if( items[i].getQuality() < 50){
                    items[i].setQuality(items[i].getQuality() + 1);
                }
                items[i].setSellIn(items[i].getSellIn() - 1);
                // check Quality
                if (items[i].getQuality() >= 50) {
                    items[i].setQuality(50);
                }
            }
            //visit Conjured Mana Cake
            if ("Conjured Mana Cake".equals(items[i].getName())){
                //SellIn >= 0
                if (items[i].getSellIn() >= 0
                        && items[i].getQuality() > 0){
                    items[i].setQuality(items[i].getQuality() - 2);
                }
                //SellIn < 0
                else if (items[i].getSellIn() < 0
                        && items[i].getQuality() > 0){
                    items[i].setQuality(items[i].getQuality() - 4);
                }
                items[i].setSellIn(items[i].getSellIn() - 1);
                // check Quality
                if (items[i].getQuality() <= 0){
                    items[i].setQuality(0);
                }
            }

        }
    }

/*
   public void superTruc(){
        Visitor visitor = new Visitor();
        for (int i = 0; 1 < items.length;i++){
            items[i].accept(visitor);
        }

    }*/

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.Visitor();
            inventory.printInventory();
        }
    }
}
