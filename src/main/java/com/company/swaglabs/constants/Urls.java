package com.company.swaglabs.constants;

public enum Urls {
    HOMEPAGE_URL("https://www.saucedemo.com/inventory.html"),
    LOGINPAGE_URL("https://www.saucedemo.com/");
    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String toString(){
        return this.url;
    }
}
