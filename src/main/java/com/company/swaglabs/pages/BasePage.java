package com.company.swaglabs.pages;

import com.company.swaglabs.components.Footer;
import com.company.swaglabs.components.Header;
import com.company.swaglabs.utils.CustomWebDriver;
import com.company.swaglabs.utils.LoadableComponent;
import com.company.swaglabs.utils.WaitHelper;
import org.openqa.selenium.WebDriver;


public class BasePage extends LoadableComponent<BasePage> {
    WebDriver driver = CustomWebDriver.getDriver();
    private static Header header;
    private static Footer footer;


    public BasePage() {
        header = new Header(this.driver);
        footer = new Footer(this.driver);
    }

    public static Header getHeader() {
        return header;
    }

    public static Footer getFooter() {
        return footer;
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
    }

    public void jsIsLoaded() throws Error {
        if(!WaitHelper.waitForJStoLoad()) {
            throw new Error("Page was not successfully loaded");
        }
    }

    public void jqeryIsLoaded() throws Error {
        if(!WaitHelper.waitForJQueryToLoad()) {
            throw new Error("Page was not successfully loaded");
        }
    }
}
