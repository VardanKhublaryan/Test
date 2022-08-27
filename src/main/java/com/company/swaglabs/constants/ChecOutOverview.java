package com.company.swaglabs.constants;

public enum ChecOutOverview {
    PAYMENT_INFO("Payment Information:"),
    SAUCE_CARD("SauceCard #31337"),
    SHIPPING_INFO("Shipping Information:"),
    FREE_PONY_EXPRESS("FREE PONY EXPRESS DELIVERY!");

    private final String string;


    ChecOutOverview(String string) {
        this.string = string;
    }

    public String toString(){
        return string;
    }
}
