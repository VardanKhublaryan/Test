package com.company.swaglabs.constants;

public enum CheckOutOverview {
    PAYMENT_INFO("Payment Information:"),
    SAUCE_CARD("SauceCard #31337"),
    SHIPPING_INFO("Shipping Information:"),
    FREE_PONY_EXPRESS("FREE PONY EXPRESS DELIVERY!"),
    ERROR_MESSAGE("Error: First Name is required"),
    LASTNAME_ERROR_MESSAGE("Error: Last Name is required"),
    POSTAL_CODE_ERROR_MESSAGE("Error: Postal Code is required");

    private final String string;


    CheckOutOverview(String string) {
        this.string = string;
    }

    public String toString(){
        return string;
    }
}
