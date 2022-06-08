package com.company.swaglabs.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.company.swaglabs.utils.CustomWebElement.*;

public class Footer {
    private WebDriver driver;

    @FindBy(css = "[target='_blank']")
    private List<WebElement> socialLinks;
    @FindBy(className = "footer_robot")
    private WebElement footerRobot;
    @FindBy(className = "footer_copy")
    private WebElement footerText;
    @FindBy(css = "[src='https://pbs.twimg.com/profile_banners/16672130/1630421106/1080x360']")
    private WebElement twitterPage;

    public Footer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTwitter() {
        return this.socialLinks.get(0);
    }

    public WebElement getFaceBook() {
        return this.socialLinks.get(1);
    }

    public WebElement getLinkedIn() {
        return this.socialLinks.get(2);
    }

    public String footerTex() {
        return this.footerText.getText();
    }

    public WebElement getTwitterPage() {
        return twitterPage;
    }
    public void FooterRobotvisibilitiOf(){
        isDisplayed(footerRobot);
    }
}