package ChromeTests;

import PageObject.HomePage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WrongOrderNumber extends BaseChromeUITest {

    @Test
    public void putWrongOrderNumberNoOrder() {
        boolean isNoOrderNotificationDisplayed = new HomePage(driver)
                .open()
                .clickOrderStatusButton()
                .setOrderStatus("123454").getNoOrderNotification();
        assertTrue(isNoOrderNotificationDisplayed);
    }
}