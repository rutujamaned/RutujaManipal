package org.example;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class parallelhelper {


    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public static String remote_url = "http://localhost:4444/";
    public Capabilities capabilities;
    @Parameters({"browser"})
    @BeforeMethod
    public void setDriver(String browser) throws MalformedURLException, InterruptedException {
        System.out.println("Test is running on "+browser);
        if(browser.equals("firefox")) {
            capabilities = new FirefoxOptions();
        } else if (browser.equals("chrome")) {
            capabilities = new ChromeOptions();
        } else if (browser.equals("edge")) {
            capabilities = new EdgeOptions();
        }
        driver.set(new RemoteWebDriver(new URL(remote_url), capabilities));
        driver.get().get("https://opensource-demo.orangehrmlive.com/");
        driver.get().manage().window().maximize();
        Thread.sleep(3000);
    }
    public WebDriver getDriver() { return driver.get(); }

    @AfterMethod
    public  void closeBrowser() {
        //  driver.get().quit();
        // driver.remove();
    }

}
