package ee.bigbank.loanOrigination.pages.lithuania.webLoanApplication;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ee.bigbank.enums.ResponseTime;
import ee.bigbank.models.HostingerLogins;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static ee.bigbank.commonLoanOrigination.pages.utils.PageUtils.responseTime;
import static ee.bigbank.enums.ResponseTime.THIRTY_SEC;


public class LoginToSelfServicePage {

    private SelenideElement acceptAllcookiesButton = $(byAttribute("data-click-id", "hgr-cookie_consent-accept_all_btn"));
    private SelenideElement cookieConsentModal = $(byId("cookie-consent"));
    private SelenideElement loginToSelfServiceButton = $(byId("hgr-topmenu-login"));
    private SelenideElement loginButton = $(byAttribute("data-qa", "login-button"));
    private SelenideElement loginNameInputField = $(byId("email-input"));
    private SelenideElement loginPasswordInputField = $(byId("password-input"));

    @Step("Login to Hostinger self service ")
    public void logintToSelfService(HostingerLogins hostingerLogins) {
        checkIfCookiesButtonExists();
        loginToSelfServiceButton.click();
        loginButton.should(Condition.exist, responseTime(THIRTY_SEC)).click();
        loginNameInputField.sendKeys(hostingerLogins.loginEmail);
        loginPasswordInputField.sendKeys(hostingerLogins.loginPassword);
        loginButton.click();
    }

    public void checkIfCookiesButtonExists() {
        if (cookieConsentModal.exists()) {
            acceptAllcookiesButton.should(Condition.exist, responseTime(ResponseTime.THIRTY_SEC)).click();
        }
    }

}


