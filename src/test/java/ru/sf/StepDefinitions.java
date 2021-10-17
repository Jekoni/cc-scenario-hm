package ru.sf;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final SearchItem searchItem;
    static {
        System.setProperty("webriver.chrome.driver","C:\\Users\\User_HP\\Desktop\\cc-scenario-hm\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        searchItem = new SearchItem(webDriver);
            }
    //positive scenario
    @Given("url of milk factory site {string}")
    public void url_of_milk_factory_site(String url) {
       searchItem.go();
    }
    @Then("open search field and search to {string}")
    public void open_search_field_and_search_to(String search) {
        searchItem.search(search);
    }

    @Then("make sure that there was info about {string}")
    public void make_sure_that_there_was_info_about(String searchResult) {
        searchItem.search(searchResult);
    }
//negative scenario

    @Given("url of factory site {string}")
    public void url_of_factory_site(String urlNegative) {
        searchItem.goNegative();
    }
    @Then("open search field to search {string}")
    public void open_search_field_to_search(String searchNegative) {
       searchItem.searchNegative(searchNegative);
    }
    @Then("make sure that there is info {string}")
    public void make_sure_that_there_is_info(String searchResultNegative) {
        searchItem.resultNegative(searchResultNegative);
    }

    @AfterAll
    public static void finalizeResources() {
       webDriver.close();
    }

}
