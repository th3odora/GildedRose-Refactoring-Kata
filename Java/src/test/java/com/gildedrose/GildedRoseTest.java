package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.stream.Stream;

class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("createItems")
    void updateQualityTest(Item item, int expectedQuality) {
 
        GildedRose app = new GildedRose(new Item[]{item});

        for (int i = 0; i < 5; i++) {
            app.updateQuality();
        }
        assertEquals(expectedQuality, app.items[0].quality);
    }

    private static Stream<Arguments> createItems() {
        return Stream.of(
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10), 0), //sellin is 0, so quality becomes 0
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10), 25), //sellin is between 5 and 10, so quality increaces by 2 and 3 per day
            Arguments.of(new Item("Aged Brie", 0, 21), 26), //quality increates by 1 per day
            Arguments.of(new Item("Sulfuras, Hand of Ragnaros", 20, 25), 80), //fixed at 80
            Arguments.of(new Item("random item", 0, 5), 0) //sellin is 0, so quality decreaces by 2 times faster
        );
    }

}
