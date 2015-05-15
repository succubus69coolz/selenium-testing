package com.googlecode.selenium.mds;

import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Dhimas Adiyasa Wirawan on 5/14/2015.
 */
@SuppressWarnings("ALL")
public class CheeseTest {
    @Test
    public void SearchForCheese(){
        /* Call Firefox WebDriver & get Google URL */
        WebDriver driver = new FirefoxDriver();
        Wait<WebDriver> wait =  new WebDriverWait(driver,30);
        driver.get("http://www.google.co.id");

        /* Find Google's q Element & put it into variable
         * Type "Cheese" with sendKeys */
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("cheese.com");
        /* Find Google's btnG Element & put it into variable
         * Click btnG */
        WebElement blueButton = driver.findElement(By.name("btnG"));
        blueButton.click();

        /* Wait until cheese.com appear */
        WebElement link = wait.until(textIsPresent("Cheese.com"));
        link.click();
    }

    private ExpectedCondition<WebElement> textIsPresent(final String text) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                List<WebElement> allLinks = driver.findElements(By.tagName("a"));
                for(WebElement link:allLinks){
                    if(link.getText().contains(text)){
                        return link;
                    }
                }

                return null;
            }
        };
    }
}
