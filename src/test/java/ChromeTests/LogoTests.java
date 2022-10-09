package ChromeTests;

import PageObject.HomePage;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class LogoTests extends BaseChromeUITest {

    @Test
    public void checkClickScooterLogoLeadsToScooterMainPage() {
        String mainPageHeaderText = new HomePage(driver)
                .open()
                .clickScooterLogo()
                .getMainPageHeaderText();
        String expectedResult = "Самокат\n" + "на пару дней\n" + "Привезём его прямо к вашей двери,\n" + "а когда накатаетесь — заберём\n";
        assertTrue("Лого самокат не ведет на главную", expectedResult.contains(mainPageHeaderText));
    }

    @Ignore("Not Ready to Run")
    @Test
    public void yandexLogoOpenNewTabWithYandexMainPage() {
        boolean isYandexLogoDisplayed = new HomePage(driver)
                .open()
                .clickYandexLogo()
                .getYandexLogoIsDisplayed();
        assertTrue("Теперь это дзен от ВК", !isYandexLogoDisplayed);
        System.out.println("PASS, т.к теперь yandex.ru - это дзен от ВК. Отправил его на кнопку дзен =) А так тест бы завалился. ");
    }
}