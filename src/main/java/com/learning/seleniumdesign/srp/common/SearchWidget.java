package com.learning.seleniumdesign.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import com.learning.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget  extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver){
        super(driver);
    }

    public void enter(String keyword){
        this.searchBox.clear();
        //this.searchBox.sendKeys(keyword);
        // Address call issue that fails test 10% times
        for (char ch: keyword.toCharArray() ){
            Uninterruptibles.sleepUninterruptibly(30, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        //wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        //return this.searchBox.isDisplayed();
        return this.wait.until((d)-> this.searchBox.isDisplayed());
    }
}
