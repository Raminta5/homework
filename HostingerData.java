package ee.bigbank.loanOrigination.testData.lithuania.documents;

import ee.bigbank.models.Application;
import ee.bigbank.models.Hostinger;

public class HostingerData {

    public static Hostinger hostingerData() {
        Hostinger hostinger = new Hostinger();
        hostinger.website = "https://www.hostinger.lt/";
        return hostinger;
    }
}