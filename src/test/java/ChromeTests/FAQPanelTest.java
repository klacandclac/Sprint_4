package ChromeTests;

import org.junit.Test;
import PageObject.FAQPanel;

import static Constants.Information.*;

import static org.junit.Assert.assertEquals;

public class FAQPanelTest extends BaseChromeUITest {

    @Test
    public void checkPaymentInfoRight() {
        String paymentInfo = new FAQPanel(driver)
                .open()
                .getPaymentInfo();
        assertEquals("Information not found or incorrect", EXPECTED_PAYMENT_INFO, paymentInfo);
    }

    @Test
    public void checkAmountOfInfoRight() {
        String amountOfScootersInfo = new FAQPanel(driver)
                .open()
                .getAmountOfScootersInfo();
        assertEquals("Information not found or incorrect", EXPECTED_AMOUNT_OF_SCOOTERS_INFO, amountOfScootersInfo);
    }

    @Test
    public void checkRentTimeInfoRight() {
        String rentTimeInfo = new FAQPanel(driver)
                .open()
                .getRentTimeInfo();
        assertEquals("Information not found or incorrect", EXPECTED_RENT_TIME_INFO, rentTimeInfo);
    }

    @Test
    public void checkScooterTodayInfoRight() {
        String ScooterTodayInfo = new FAQPanel(driver)
                .open()
                .getScooterTodayInfo();
        assertEquals("Information not found or incorrect", EXPECTED_SCOOTER_TODAY_INFO, ScooterTodayInfo);
    }

    @Test
    public void checkExtendReturnInfoRight() {
        String extendReturnInfo = new FAQPanel(driver)
                .open()
                .getExtendReturnInfo();
        assertEquals("Information not found or incorrect", EXPECTED_EXTEND_RETURN_INFO, extendReturnInfo);
    }

    @Test
    public void checkChargerCableInfoRight() {
        String chargerCableInfo = new FAQPanel(driver)
                .open()
                .getChargerCableInfo();
        assertEquals("Information not found or incorrect", EXPECTED_CHARGER_CABLE_INFO, chargerCableInfo);
    }

    @Test
    public void checkOrderCancellationInfoRight() {
        String orderConfirmationInfo = new FAQPanel(driver)
                .open()
                .getOrderCancellationInfo();
        assertEquals("Information not found or incorrect", EXPECTED_ORDER_CANCELLATION_INFO, orderConfirmationInfo);
    }

    @Test
    public void checkCoverageZoneInfoRight() {
        String coverageZoneInfo = new FAQPanel(driver)
                .open()
                .getCoverageZoneInfo();
        assertEquals("Information not found or incorrect", EXPECTED_COVERAGE_ZONE_INFO, coverageZoneInfo);
    }
}