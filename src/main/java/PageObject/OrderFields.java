package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderFields extends BaseObjectPage{

    public OrderFields(WebDriver driver) {
        super(driver);
    }
    public static String URL = "https://qa-scooter.praktikum-services.ru/";


    // Кнопки заказать
    private final By topRightOrderButton = (By.className("Button_Button__ra12g"));
    private final By bottomOrderButton = (By.xpath("(//button [text()='Заказать'])[2]"));

    // Поля с инофрмацией о клиенте
    private final By nameField = (By.xpath(".//input[@placeholder='* Имя']"));
    private final By surnameField = (By.xpath(".//input[@placeholder='* Фамилия']"));
    private final By addressField = (By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"));
    private final By metroStationField = (By.className("select-search__input"));
    // Найденая станция
    private final By foundMetroStation = (By.xpath(".//div[contains(@class, 'Order_Text__2broi') and contains(text(), 'Аэропорт')]"));
    private final By phoneNumberField = (By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"));

    // Кнопка далее
    private final By nextButton = (By.className("Button_Middle__1CSJM"));

    // Поля с информацией о самокате
    // Поле даты доставки
    private final By deliveryDateField = (By.xpath(".//input[@placeholder='* Когда привезти самокат']"));

    // Поле срока аренды
    private final By rentPeriod = (By.className("Dropdown-arrow"));
    // Конкретный период, например двое суток
    private final By twoDays = (By.xpath(".//div[contains(text(), 'двое суток')]"));

    // Чекбокс выбора цвета
    private final By blackColorCheckBox = (By.id("black"));
    private final By lastOrderButton = (By.xpath( ".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Заказать')]"));
    private final By orderConfirmationButton = (By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Да')]"));

    // Заказ оформлен
    private final By orderStatus =
            (By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Посмотреть статус')]"));
    // Конструктор

    @Override
    public OrderFields open(){
        driver.get(URL);
        return this;
    }

    // Домашняя страница и страница ввода информации о клиенте
    // Локаторы кнопок заказать на главной странице
    public OrderFields clickTopOrderButton(){
        driver.findElement(topRightOrderButton).click();
        return this;
    }
    private WebElement getBottomOrderButtonLocator() {
        return driver.findElement(bottomOrderButton);
    }
    public void scrollToBottomButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", getBottomOrderButtonLocator());
    }
    private void waitElementClickable(WebElement element){
        WebDriverWait pause = new WebDriverWait(driver, 3);
        pause.until(ExpectedConditions.elementToBeClickable(element));
    }
    public OrderFields clickBottomOrderButton(){
        WebElement element = driver.findElement(bottomOrderButton);
        waitElementClickable(element);
        scrollToBottomButton();
        element.click();
        return this;
    }

    // Локатор страницы информации о пользователе
    private WebElement getNameFieldLocator(){
        return driver.findElement(nameField);
    }
    // Локаторы страницы информации о самокате
    private WebElement getDeliveryDateFieldLocator() {
        return driver.findElement(deliveryDateField);
    }
    // Локатор кнопки подтверждения заказа
    private WebElement getOrderConfirmationButtonLocator() {
        return driver.findElement((orderConfirmationButton));
    }

    // Локатор кнопки статуса заказа
    public boolean getOrderStatus(){
        return driver.findElement(orderStatus).isDisplayed();
    }

    // Заполнение полей о пользователе
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStation(String station) {
        driver.findElement(metroStationField).sendKeys(station);
        driver.findElement(foundMetroStation).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // Заполнение полей о самокате
    private void setDeliveryDate(String date){
        driver.findElement(deliveryDateField).sendKeys(date);
    }

    private void setRentPeriod() {
        driver.findElement(rentPeriod).click();
        driver.findElement(twoDays).click();
    }

    private void setBlackColorCheckBox() {
        driver.findElement(blackColorCheckBox).click();
    }

    // Клик на кнопку далее
    private void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    // Клик на финальную кнопку заказать
    private void clickLastOrderButton() {
        driver.findElement(lastOrderButton).click();
    }

    // Клик на кнопку подтверждения "да"
    public void clickOrderConfirmationButton() {
        waitElementClickable(getOrderConfirmationButtonLocator());
        driver.findElement(orderConfirmationButton).click();
    }

    // Ввести всю информацию о клиенте
    public OrderFields setAllOrderFields() {
        waitElementClickable(getNameFieldLocator());
        setName("Иван");
        setSurname("Иванов");
        setAddress("Маяковская 19");
        setMetroStation("Аэро");
        setPhoneNumber("89114543454");
        clickNextButton();
        waitElementClickable(getDeliveryDateFieldLocator());
        setDeliveryDate("15.07.2022");
        setRentPeriod();
        setBlackColorCheckBox();
        clickLastOrderButton();
        clickOrderConfirmationButton();
        return this;
    }
}