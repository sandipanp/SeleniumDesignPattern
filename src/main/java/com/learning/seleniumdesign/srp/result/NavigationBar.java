package com.learning.seleniumdesign.srp.result;

import com.learning.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb-msb")
    private WebElement bar;

    @FindBy( linkText = "Videos")
    private WebElement videos;

    @FindBy( linkText = "News" )
    private WebElement news;


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToNews(){
        this.news.click();
    }

    public void goToVideos(){
        this.videos.click();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bar.isDisplayed());
    }
}
