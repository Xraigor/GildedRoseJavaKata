package edu.insightr.gildedrose;

import com.sun.scenario.effect.InvertMask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
//Quality test
    @Test
    void vest() {
        Inventory testInventory = new Inventory();
        Item vest = testInventory.getItems()[0];

        assertEquals("+5 Dexterity Vest", vest.getName());
        assertEquals( 20, vest.getQuality());

        testInventory.Visitor();
        assertEquals( 19, vest.getQuality());
        //assertThat(agedbrie.getSellIn(),equalsTo(1));
    }
    @Test
    void agedBrie(){
        Inventory testInventory = new Inventory();
        Item Brie = testInventory.getItems()[1];

        assertEquals("Aged Brie", Brie.getName());
        assertEquals( 0, Brie.getQuality());

        testInventory.Visitor();
        assertEquals( 1, Brie.getQuality());
    }
    @Test
    void elixiroftheMongoose() {
        Inventory testInventory = new Inventory();
        Item Mongoose = testInventory.getItems()[2];

        assertEquals("Elixir of the Mongoose", Mongoose.getName());
        assertEquals(7, Mongoose.getQuality());

        testInventory.Visitor();
        assertEquals(6, Mongoose.getQuality());
    }
    @Test
    void Sulfuras(){
        Inventory testInventory = new Inventory();
        Item Sulfuras = testInventory.getItems()[3];

        assertEquals("Sulfuras, Hand of Ragnaros", Sulfuras.getName());
        assertEquals(80, Sulfuras.getQuality());

        testInventory.Visitor();
        assertEquals(80, Sulfuras.getQuality());
    }
    @Test
    void Backstage(){
        Inventory testInventory = new Inventory();
        Item Backstage = testInventory.getItems()[4];

        assertEquals("Backstage passes to a TAFKAL80ETC concert", Backstage.getName());
        assertEquals(20, Backstage.getQuality());

        testInventory.Visitor();
        assertEquals(21, Backstage.getQuality());
    }
    @Test
    void Conjured(){
        Inventory testInventory = new Inventory();
        Item Conjured = testInventory.getItems()[5];

        assertEquals("Conjured Mana Cake",Conjured.getName());
        assertEquals(6,Conjured.getQuality());

        testInventory.Visitor();
        assertEquals(4, Conjured.getQuality());
    }

//SellIn test
@Test
    void vestSellIn() {
    Inventory testInventory = new Inventory();
    Item vesttSell = testInventory.getItems()[0];

    assertEquals("+5 Dexterity Vest", vesttSell.getName());
    assertEquals( 10, vesttSell.getSellIn());

    testInventory.Visitor();
    assertEquals( 9, vesttSell.getSellIn());
}
    @Test
    void agedBrieSellIn(){
        Inventory testInventory = new Inventory();
        Item BrieSellIn = testInventory.getItems()[1];

        assertEquals("Aged Brie", BrieSellIn.getName());
        assertEquals( 2, BrieSellIn.getSellIn());

        testInventory.Visitor();
        assertEquals( 1, BrieSellIn.getSellIn());
    }
    @Test
    void MongooseSellIn() {
        Inventory testInventory = new Inventory();
        Item MongooseSellIn = testInventory.getItems()[2];

        assertEquals("Elixir of the Mongoose", MongooseSellIn.getName());
        assertEquals(5, MongooseSellIn.getSellIn());

        testInventory.Visitor();
        assertEquals(4, MongooseSellIn.getSellIn());
    }
    @Test
    void SulfurasSellIn(){
        Inventory testInventory = new Inventory();
        Item SulfurasSellIn = testInventory.getItems()[3];

        assertEquals("Sulfuras, Hand of Ragnaros", SulfurasSellIn.getName());
        assertEquals(0, SulfurasSellIn.getSellIn());

        testInventory.Visitor();
        assertEquals(0, SulfurasSellIn.getSellIn());
    }
    @Test
    void BackstageSellIn(){
        Inventory testInventory = new Inventory();
        Item BackstageSellIn = testInventory.getItems()[4];

        assertEquals("Backstage passes to a TAFKAL80ETC concert", BackstageSellIn.getName());
        assertEquals(15, BackstageSellIn.getSellIn());

        testInventory.Visitor();
        assertEquals(14, BackstageSellIn.getSellIn());
    }
    @Test
    void ConjuredSellIn(){
        Inventory testInventory = new Inventory();
        Item ConjuredSellIn = testInventory.getItems()[5];

        assertEquals("Conjured Mana Cake",ConjuredSellIn.getName());
        assertEquals(3,ConjuredSellIn.getSellIn());

        testInventory.Visitor();
        assertEquals(2, ConjuredSellIn.getSellIn());
    }
}