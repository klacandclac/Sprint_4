package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FAQPanel extends BaseObjectPage {

    public FAQPanel(WebDriver driver) {
        super(driver);
    }

    public static String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By yandexScooterFAQ = By.xpath(".//div[contains(@class,'Home_SubHeader__zwi_E') and contains(text(), 'Вопросы о важном')]");

    // Разделы с информацией
    private final By paymentInfoButton = By.id("accordion__heading-0");
    private final By paymentInfo = By.id("accordion__panel-0");

    private final By amountOfScootersInfoButton = By.id("accordion__heading-1");
    private final By amountOfScootersInfo = By.id("accordion__panel-1");

    private final By rentTimeInfoButton = By.id("accordion__heading-2");
    private final By rentTimeInfo = By.id("accordion__panel-2");

    private final By scooterTodayInfoButton = By.id("accordion__heading-3");
    private final By scooterTodayInfo = By.id("accordion__panel-3");

    private final By extendReturnInfoButton = By.id("accordion__heading-4");
    private final By extendReturnInfo = By.id("accordion__panel-4");

    private final By chargerCableInfoButton = By.id("accordion__heading-5");
    private final By chargerCableInfo = By.id("accordion__panel-5");

    private final By orderCancellationInfoButton = By.id("accordion__heading-6");
    private final By orderCancellationInfo = By.id("accordion__panel-6");

    private final By coverageZoneInfoButton = By.id("accordion__heading-7");
    private final By coverageZoneInfo = By.id("accordion__panel-7");

    @Override
    public FAQPanel open() {
        driver.get(URL);
        return this;
    }

    // Локаторы
    public WebElement getYandexScooterFAQ() {
        return driver.findElement(yandexScooterFAQ);
    }

    // Кнопки с информацией
    private void scrollToFAQ() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getYandexScooterFAQ());
    }

    private void waitVisibilityOfInfo(WebElement element) {
        WebDriverWait pause = new WebDriverWait(driver, 3);
        pause.until(ExpectedConditions.visibilityOf(element));
    }

    public String getPaymentInfo() {
        scrollToFAQ();
        driver.findElement(paymentInfoButton).click();
        WebElement element = driver.findElement(paymentInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getAmountOfScootersInfo() {
        scrollToFAQ();
        driver.findElement(amountOfScootersInfoButton).click();
        WebElement element = driver.findElement(amountOfScootersInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getRentTimeInfo() {
        scrollToFAQ();
        driver.findElement(rentTimeInfoButton).click();
        WebElement element = driver.findElement(rentTimeInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getScooterTodayInfo() {
        scrollToFAQ();
        driver.findElement(scooterTodayInfoButton).click();
        WebElement element = driver.findElement(scooterTodayInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getExtendReturnInfo() {
        scrollToFAQ();
        driver.findElement(extendReturnInfoButton).click();
        WebElement element = driver.findElement(extendReturnInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getChargerCableInfo() {
        scrollToFAQ();
        driver.findElement(chargerCableInfoButton).click();
        WebElement element = driver.findElement(chargerCableInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getOrderCancellationInfo() {
        scrollToFAQ();
        driver.findElement(orderCancellationInfoButton).click();
        WebElement element = driver.findElement(orderCancellationInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }

    public String getCoverageZoneInfo() {
        scrollToFAQ();
        driver.findElement(coverageZoneInfoButton).click();
        WebElement element = driver.findElement(coverageZoneInfo);
        waitVisibilityOfInfo(element);
        return element.getText();
    }
}