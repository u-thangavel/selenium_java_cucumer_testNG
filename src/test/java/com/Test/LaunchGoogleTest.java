package com.Test;

import com.utils.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchGoogleTest  {

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        System.out.println("Browser opened");
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        BaseClass.googleWeb.navigateToURL(url);

    }

    @Then("get the page title")
    public void i_should_see_the_title_contains() {
        Assert.assertEquals(BaseClass.getTitle(),"Google");

    }

}
