package ru.praktikum.yandex;

import com.sun.jdi.request.DuplicateRequestException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driverChrome;
    WebDriver driverFirefox;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driverFirefox = new FirefoxDriver();
    }

    @After
    public void tearDown(){
        driverChrome.quit();
//        driverFirefox.quit();
    }
}
