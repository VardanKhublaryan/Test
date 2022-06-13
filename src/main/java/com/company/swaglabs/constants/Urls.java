package com.company.swaglabs.constants;

public enum Urls {
    HOMPAGE_URL("https://www.saucedemo.com/inventory.html"), LOGINPAGE_URL("https://www.saucedemo.com/");
    String url;

    Urls(String url) {
        this.url = url;
    }
    public String toString(){
        return this.url;
    }
}
