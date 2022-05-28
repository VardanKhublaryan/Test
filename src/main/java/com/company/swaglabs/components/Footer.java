package com.company.swaglabs.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer {
    private WebDriver driver;

    @FindBy(css = "'[target='_blank']'")
    private List<WebElement> socialLinks;
    @FindBy(className = "footer_robot")
    private WebElement footerRobot;
    @FindBy(className = "footer_copy")
    private WebElement footerText;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnTwitter() {
        this.socialLinks.get(0).click();
    }

    public void clickOnFaceBook() {
        this.socialLinks.get(1).click();
    }

    public void clickOnLinkedIn() {
        this.socialLinks.get(2).click();
    }

    public String footerTex() {
        return this.footerText.getText();
    }
}