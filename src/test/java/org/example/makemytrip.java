package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class makemytrip extends Goatrip {

    @Test
    public void make() {

        WebElement from = getDriver().findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("Delhi");

        WebElement to = getDriver().findElement(By.xpath("//input[@placeholder='To']]"));
        to.sendKeys("Mumbai");

        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search')]']]"));
        search.click();

    }
}