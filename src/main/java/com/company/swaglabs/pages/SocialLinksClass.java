package com.company.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static com.company.swaglabs.utils.CustomWebElement.click;
import static com.company.swaglabs.utils.CustomWebElement.isDisplayed;

public class SocialLinksClass extends BasePage {
    private static WebDriver driver;
    @FindBy(css = "[class='r-1cvl2hr r-4qtqp9 r-yyyyoo r-16y2uox r-8kz0gk r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-lrsllp']")
    private WebElement twitterLogo;
    @FindBy(linkText = "Watch Video")
    private WebElement facebookElement;
    @FindBy(className = "background")
    private WebElement linkedInIcon;

    public SocialLinksClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnTwitter() {
        isDisplayed(getFooter().getTwitter());
        click(getFooter().getTwitter());
    }

    public void clickOnFacebook() {
        isDisplayed(getFooter().getFaceBook());
        click(getFooter().getFaceBook());
    }

    public void clickOnLinkedIn() {
        isDisplayed(getFooter().getLinkedIn());
        click(getFooter().getLinkedIn());
    }

    public boolean twitterLogoIsDisplayed() {
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }

        }
        return isDisplayed(twitterLogo);
    }

    public boolean facebookIsDisplayed() {
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }

        }
        return isDisplayed(facebookElement);
    }

    public boolean linkedInIsDisplayed() {
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }

        }
        return isDisplayed(linkedInIcon);
    }
}
