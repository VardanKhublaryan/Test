package com.company.swaglabs.pages;

import com.company.swaglabs.components.Footer;
import com.company.swaglabs.components.Header;
import com.company.swaglabs.utils.LoadableComponent;
import com.company.swaglabs.utils.WaitHelper;
import org.openqa.selenium.WebDriver;

public class BasePage extends LoadableComponent<BasePage> {
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

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        if (WaitHelper.waitForJStoLoad(driver)) {
            throw new Error("Page was not successfully loaded");

        }
    }
}
