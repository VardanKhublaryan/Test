package com.company.swaglabs.constants;

public enum ChecOutOverview {
    PAYMENTINFO("Payment Information:"),
    SAUCECARD("SauceCard #31337"),
    SHIPPINGINFO("Shipping Information:"),
    FREEPONYEXPRESS("FREE PONY EXPRESS DELIVERY!");

    private final String string;


    ChecOutOverview(String string) {
        this.string = string;
    }

    public String toString(){
        return string;
    }
}
