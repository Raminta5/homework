package ee.bigbank.loanOrigination.testData.lithuania.documents;

import ee.bigbank.models.HostingerLogins;

public class HostingerLoginData {

    public static HostingerLogins hostingerLoginData() {
        HostingerLogins hostingerLogins = new HostingerLogins();
        hostingerLogins.loginEmail = "xxx";
        hostingerLogins.loginPassword = "xxx";
        return hostingerLogins;
    }

}
