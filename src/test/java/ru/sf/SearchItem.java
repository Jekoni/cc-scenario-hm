package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SearchItem {
    private static final String URL = "http://slavmo.ru/";
    private static final String SEARCH_INPUT = "search";
    private static final String SEARCH_ITEM = "form-control";
    private static final String RESULT = "//*[@class='container s-results margin-bottom-50']/div[1]/h3/a";
    private static final String MESSAGE = "alert-warning";
    private final WebDriver webDriver;

    public SearchItem(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public  void go() {
        webDriver.get(URL);
    }

    public void search(String search){
        webDriver.findElement(By.className(SEARCH_INPUT)).click();
        webDriver.findElement(By.className(SEARCH_ITEM)).sendKeys(search, Keys.ENTER);
    }

    public  void result (String searchResult){
        final var result = webDriver.findElement(By.xpath(RESULT)).getText();
        assertEquals(searchResult,result);
    }

    public  void goNegative() {
        webDriver.get(URL);
    }

    public void searchNegative(String searchNegative){
        webDriver.findElement(By.className(SEARCH_INPUT)).click();
        webDriver.findElement(By.className(SEARCH_ITEM)).sendKeys(searchNegative,Keys.ENTER);
    }

    public  void resultNegative (String searchResultNegative){
        final var result = webDriver.findElement(By.className(MESSAGE)).getText();
        assertEquals(searchResultNegative,result);
    }
}
