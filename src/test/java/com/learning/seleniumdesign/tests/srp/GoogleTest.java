package com.learning.seleniumdesign.tests.srp;

import com.learning.seleniumdesign.srp.main.GoogleMainPage;
import com.learning.seleniumdesign.srp.result.GoogleResultPage;
import com.learning.seleniumdesign.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setUpPage(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage  = new GoogleResultPage(driver);
    }

    @Test (dataProvider = "getData")
    public void googleWorkFlow(String keyword, int index){
        //System.out.println("I am in");
        //String keyword = "Selenium webdriver tutorial";
        //int index = 3;
        googleMainPage.GoTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        System.out.println(
                googleResultPage.getResultStats().getStat()
        );
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {
                {"Selenium", 3},
                {"Docker", 1}
        };
    }
}
