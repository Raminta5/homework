package ee.bigbank.loanOrigination.tests.web.lithuania.consumerLoanTests;

import ee.bigbank.loanOrigination.testData.lithuania.documents.HostingerData;
import ee.bigbank.loanOrigination.testData.lithuania.documents.HostingerLoginData;
import ee.bigbank.loanOrigination.tests.TestBaseLithuania;
import ee.bigbank.models.Hostinger;
import ee.bigbank.models.HostingerLogins;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PlanPurchaseHostinger extends TestBaseLithuania {


    @Test(testName = "Purchase of the 24 months plan",
            description = "This test tests successful purchase of 24 months plan")
    public void Purchase24monthsPlan() {
        Hostinger hostinger = HostingerData.hostingerData();
        HostingerLogins hostingerLogins = HostingerLoginData.hostingerLoginData();
        open(hostinger.website);
        loginToSelfServicePage.logintToSelfService(hostingerLogins);
        selfServiceAccountPage.validateSelfServiceAccount();
        selfServiceAccountPage.purchaseAnItemInSelfService();

        //Separate HostingerProducts file could have been created if products were listed as values. In that case we can list all the products
        // and use different and not hardcode only one.

    }
}
