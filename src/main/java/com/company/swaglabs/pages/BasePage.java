package com.company.swaglabs.pages;

import com.company.swaglabs.components.Footer;
import com.company.swaglabs.components.Header;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;
    private Header header;
    private Footer footer;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(this.driver);
        footer = new Footer(this.driver);
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
