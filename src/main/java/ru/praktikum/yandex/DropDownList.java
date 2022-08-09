package ru.praktikum.yandex;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownList {
    private WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //first button and its text
    private By scooterCostButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[1]/div[1]");
    private By scooterCost = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[1]/div[2]/p");

    //second button and its text
    private By someScootersButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[2]/div[1]");
    private By someScooters = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[2]/div[2]/p");

    //third button and its text
    private By timeRentButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[3]/div[1]");
    private By timeRent = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[3]/div[2]/p");

    //forth button and its text
    private By todayScooterButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[4]/div[1]");
    private By todayScooter = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[4]/div[2]/p");

    //fifth button and its text
    private By prolongOrBackEarlyButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[5]/div[1]");
    private By prolongOrBackEarly = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[5]/div[2]/p");

    //sixth button and its text
    private By chargerWithScooterButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[6]/div[1]");
    private By chargerWithScooter = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[6]/div[2]/p");

    //seventh button and its text
    private By cancellingOrderButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[7]/div[1]");
    private By cancellingOrder = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[7]/div[2]/p");

    //eighth button and its text
    private By mkadRegionButton = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[8]/div[1]");
    private By mkadRegion = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[8]/div[2]/p");

    public DropDownList(WebDriver driver){
        this.driver = driver;
        driver.get(url);
        waitForLoadHomePage();
        scrollToQuestions();
    }

    private void waitForLoadHomePage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
    }

    private void scrollToQuestions(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public String getScooterCostAnswer(){
        driver.findElement(scooterCostButton).click();
        return driver.findElement(scooterCost).getText();
    }

    public String getSomeScootersAnswer(){
        driver.findElement(someScootersButton).click();
        return driver.findElement(someScooters).getText();
    }

    public String getTimeRentAnswer(){
        driver.findElement(timeRentButton).click();
        return driver.findElement(timeRent).getText();
    }

    public String getTodayScooterAnswer(){
        driver.findElement(todayScooterButton).click();
        return driver.findElement(todayScooter).getText();
    }

    public String getProlongOrBackEarlyAnswer(){
        driver.findElement(prolongOrBackEarlyButton).click();
        return driver.findElement(prolongOrBackEarly).getText();
    }

    public String getChargerWithScooterAnswer(){
        driver.findElement(chargerWithScooterButton).click();
        return driver.findElement(chargerWithScooter).getText();
    }

    public String getCancellingOrderAnswer(){
        driver.findElement(cancellingOrderButton).click();
        return driver.findElement(cancellingOrder).getText();
    }

    public String getMkadRegionAnswer(){
        driver.findElement(mkadRegionButton).click();
        return driver.findElement(mkadRegion).getText();
    }
}
