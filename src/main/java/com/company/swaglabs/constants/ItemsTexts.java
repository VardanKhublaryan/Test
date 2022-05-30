package com.company.swaglabs.constants;

import java.util.Random;

public enum ItemsTexts {
    ITEM1("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."),
    ITEM2("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."),
    ITEM3("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."),
    ITEM4("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."),
    ITEM5("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."),
    ITEM6("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."),
    ITEMPRICE1("$29.99"),
    ITEMPRICE2("$9.99"),
    ITEMPRICE3("$15.99"),
    ITEMPRICE4("$49.99"),
    ITEMPRICE5("$7.99"),
    ITEMPRICE6("$15.99");


    private final String text;

    ItemsTexts(String text) {
        this.text = text;
    }
    public String getText(){
        return text;
    }

    public static ItemsTexts[] getItemsTexts() {
        ItemsTexts[] itemsTextsArr = {ITEM1, ITEM2, ITEM3, ITEM4, ITEM5, ITEM6};
        return itemsTextsArr;
    }
    public static ItemsTexts[] getItemsPrices(){
        ItemsTexts[] itemPrices = {ITEMPRICE1,ITEMPRICE2,ITEMPRICE3,ITEMPRICE4,ITEMPRICE5,ITEMPRICE6};
        return itemPrices;
    }
}
