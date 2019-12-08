package online.qastudy.automationpractice;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import online.qastudy.pages.MainPage;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListenerAdapter.class)
public class ShopTest extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setupMainPage() {
        mainPage = new MainPage(driver);
    }


    @Test(groups = {"smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Check Total price in the Cart with a T-Shirt.")
    public void canCheckTotalPriceForTShirt() {
        mainPage.clickTShirtTab();
        mainPage.scrollToItem();
        mainPage.navigateToItemView();
        mainPage.clickAddToCart();
        mainPage.clickProceedToCheckout();

        String actualResult = mainPage.getTotalPrice();
        String expectedResult = "$18.51";

        Assert.assertEquals(expectedResult, actualResult, "If test failed then total price was changed");
    }

    @Test
    @Description("Test Description: Failed test")
    public void failedTest () {
        Assert.assertTrue(false);
    }

}
