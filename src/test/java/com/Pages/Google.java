package com.Pages;

import com.utils.BaseClass;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Setter
public class Google extends BaseClass {

    @FindBy(linkText="Select Park")
    private WebElement selectParkHome;

    public void navigateToURL(String URL) {
        driver.get().get(URL);

    }

    public Google(ThreadLocal<WebDriver> driver) {
        PageFactory.initElements(BaseClass.driver.get(), this);
        actions = new Actions(BaseClass.driver.get());
    }
}
