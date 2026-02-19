package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {           
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (checkIfQualityInRange(items[i].quality)) {
                switch (items[i].name) {
                    case "Aged Brie":              
                        increaseQuality(items[i], 1);
                        break;
                    case "Backstage passes to a TAFKAL80ETC concert":
                        if (items[i].sellIn < 0) {
                             items[i].quality = 0;
                        } else if (items[i].sellIn < 6 && items[i].quality < 48) {
                            increaseQuality(items[i], 3);
                        } else if (items[i].sellIn < 11 && items[i].quality < 49) { 
                            increaseQuality(items[i], 2);
                        } else {
                            increaseQuality(items[i], 1);
                        }
                        break;
                    case "Sulfuras, Hand of Ragnaros":
                        items[i].quality = 80;
                        break;
                    default:
                        if (items[i].sellIn >= 0) {
                            decreaseQuality(items[i], 1);
                        } else {
                            decreaseQuality(items[i], items[i].quality);
                        }
                }
            }
        }   
    }

    private boolean checkIfQualityInRange(int quality) {
        return quality >= 0 && quality <= 50;
    }

    private void increaseQuality(Item item, int increaseBy) {
        if (item.quality  < 50) {   
            item.quality = item.quality + increaseBy;
        }
    }

    private void decreaseQuality(Item item, int decreaseBy) {
        if (item.quality  > 0) {
            item.quality = item.quality - decreaseBy;
        }
    }
}
