package ru.praktikum.yandex;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetOrder {

    private WebDriver driver;

    //main page url
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //home page locator
    private By mainPageLoaded = By.className("Home_Header__iJKdX");

    // order-button on the main page
    private By mainOrderButton;

    //name field in questionnaire
    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");

    //surname field in questionnaire
    private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");

    //city field in questionnaire
    private By cityField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //metro station field in questionnaire
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");

    //phone number field in questionnaire
    private By phoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //button 'Далее' in questionnaire
    private By nextStepButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    //next page locator in questionnaire
    private By nextStepPage = By.className("Order_Header__BZXOb");

    //date field in questionnaire
    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //drop-down menu locator and choosing one of the items in questionnaire
    private By dropDownMenuOpen = By.xpath(".//div[text()='* Срок аренды']");
    private By daysCountRentField = By.xpath(".//div[@class = 'Dropdown-menu']/div[text()='сутки']");

    //order button in questionnaire
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    // confirmation locator
    private By confirmText = By.xpath(".//div[text()='Хотите оформить заказ?']");

    //last button in accepting order in questionnaire
    private By acceptOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");

    //site's confirmation popup
    private By orderFramedMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public GetOrder(WebDriver driver){
        this.driver = driver;
        driver.get(url);
        waitForAnotherWindow(mainPageLoaded);
    }

    // main test function; here we can define what of "Заказать"-buttons was clicked (1 - upper, 2 - bottom)
    public boolean isOrderGotten(int buttonNumber){
        if (buttonNumber == 1) {
            mainOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
        } else if (buttonNumber == 2) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath(".//div[text()='Курьер забирает самокат']"));
            js.executeScript("arguments[0].scrollIntoView();", element);
            mainOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
        }

        clickOrderButton();
        fillTheQuestionnaire();
        waitForAnotherWindow(orderFramedMessage);
        if (driver.findElement(orderFramedMessage).isEnabled())
            return true;
        return false;
    }

    private void clickOrderButton(){
        driver.findElement(mainOrderButton).click();
    }

    private void fillTheQuestionnaire() {
        driver.findElement(nameField).sendKeys("Тест");

        driver.findElement(surnameField).sendKeys("Тест");

        driver.findElement(cityField).sendKeys("Москва");

        driver.findElement(metroField).sendKeys("Красносельская");
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);

        driver.findElement(phoneNumberField).sendKeys("89654785236");

        driver.findElement(nextStepButton).click();

        waitForAnotherWindow(nextStepPage);

        driver.findElement(dateField).click();
        driver.findElement(dateField).sendKeys(Keys.ENTER);

        driver.findElement(dropDownMenuOpen).click();
        driver.findElement(daysCountRentField).click();

        driver.findElement(orderButton).click();

        waitForAnotherWindow(confirmText);

        driver.findElement(acceptOrderButton).click();

    }

    private void waitForAnotherWindow(By whatElementWeWaitFor) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(whatElementWeWaitFor));
    }
}
