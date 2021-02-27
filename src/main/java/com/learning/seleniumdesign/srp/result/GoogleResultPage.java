package com.learning.seleniumdesign.srp.result;

import com.learning.seleniumdesign.srp.common.SearchSuggestion;
import com.learning.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private NavigationBar navigationBar;
    private ResultStats resultStats;

    public GoogleResultPage(final WebDriver driver){
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStats = PageFactory.initElements(driver, ResultStats.class);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStats getResultStats() {
        return resultStats;
    }
}
