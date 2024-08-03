package ee.bigbank.loanOrigination.pages.lithuania.webLoanApplication;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static ee.bigbank.commonLoanOrigination.pages.utils.PageUtils.responseTime;
import static ee.bigbank.enums.ResponseTime.THIRTY_SEC;
import static org.assertj.core.api.Assertions.assertThat;


public class SelfServiceAccountPage {

    private SelenideElement homeContainerHeading = $(byClassName("home-heading"));
    private SelenideElement userProfileIcon = $(byId("hpanel_tracking-h_header-header_menu_item-link-user_profile"));
    private SelenideElement personalInformationLink = $(byId("hpanel_tracking-h_header-user_profile_routes-link-personal_information"));
    private SelenideElement emailItem = $(byXpath("//*[@id=\"scrollable-content\"]/div/div/div[2]/main/section/div/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div[1]/div"));
    private SelenideElement mainMenuButton = $(byId("overview"));
    private SelenideElement marketplaceButton = $(byAttribute("data-qa", "navigate-marketplace"));
    private SelenideElement sideMenuContainer = $(byClassName("hp-menu__list"));
    private SelenideElement allMarketProducts = $(byAttribute("data-qa", "navigate-marketplace-products"));
    private SelenideElement webHostingProduct = $(byXpath("//*[@id=\"hpanel_tracking-marketplace-explore_button\"]"));
    private SelenideElement selectPlanButton = $(byXpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button"));
    private SelenideElement singleWebHostingModal = $(byId("single-web-hosting-modal"));
    private SelenideElement singleWebHosting24monthsPlan = $(byXpath("//*[@id=\"single-web-hosting-modal\"]/div/div/div[2]/div/ul/li[2]/div/div/div[1]/div[2]/p"));
    private SelenideElement choosePaymentMethodButton = $(byId("hpanel_tracking-buy-hosting-single-web-hosting-modal-choose_payment_method_button"));
    private SelenideElement paypalLogo = $(byId("braintree_paypal"));
    private SelenideElement orderSummaryBlock = $(byXpath("//*[@id=\"payment-methods\"]/div/div[2]/div/div[3]/div[1]"));

    @Step("Validate account after login to self service")
    public void validateSelfServiceAccount() {
        homeContainerHeading.should(Condition.exist, responseTime(THIRTY_SEC));
        userProfileIcon.click();
        personalInformationLink.shouldBe(Condition.visible).click();
        String accountEmail = emailItem.getText();
        assertThat(accountEmail).isEqualTo("horeg55521@fxseller.com");
        mainMenuButton.click();
    }

    @Step("Purchase of the item in self service")
    public void purchaseAnItemInSelfService() {
        // I had to use xath in some of the places because of same attributes for different elements ->
//-> it is possible to find it in another way, this was much faster this time :)
        sideMenuContainer.shouldBe(Condition.visible, responseTime(THIRTY_SEC));
        marketplaceButton.click();
        allMarketProducts.click();
        webHostingProduct.scrollIntoView(true).click();
        selectPlanButton.should(Condition.exist, responseTime(THIRTY_SEC)).click();
        singleWebHostingModal.shouldBe(Condition.visible, responseTime(THIRTY_SEC));
        singleWebHosting24monthsPlan.click();
        choosePaymentMethodButton.click();
        paypalLogo.shouldBe(Condition.visible, responseTime(THIRTY_SEC));
        String productForPurchase = orderSummaryBlock.getText();
        assertThat(productForPurchase).isEqualTo("Single Web Hosting (billed every 2 years)");
        paypalLogo.shouldBe(Condition.visible, responseTime(THIRTY_SEC)).click();

    }
}
