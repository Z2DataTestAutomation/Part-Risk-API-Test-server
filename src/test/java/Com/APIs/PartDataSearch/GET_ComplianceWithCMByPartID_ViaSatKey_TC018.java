package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_ComplianceWithCMByPartID_ViaSatKey_TC018 extends config {
    @Test
    public void ComplianceWithCMByPartID_ViaSatKey() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey
                        + "&PartID=1049")
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();
    }

    @Test
    public void ComplianceWithCMByPartID_4815043_Compliance() {
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey + "&PartID=4815043")
                .then().assertThat().statusCode(200).and()
                .body("numFound", equalTo(1)).and()
                .body("results.partID[0]", equalTo(4815043)).and()
                .body("results.partNumber[0]", equalTo("BAV99")).and()
                .body("results.compliance[0].partComplianceSummary.compliance[0]", equalTo("RoHS (2015/863)"))
                .body("results.compliance[0].partComplianceSummary.compliance[1]", equalTo("REACH"))
                .body("results.compliance[0].partComplianceSummary.compliance[2]", equalTo("China RoHS"))
                .body("results.compliance[0].partComplianceSummary.compliance[3]", equalTo("halogen_free"))
                .body("results.compliance[0].partComplianceSummary.compliance[4]", equalTo("RoHS (2011/65/EU)"))
                .body("results.compliance[0].partComplianceSummary.compliance[5]", equalTo("RoHS (2002/95/EC)"))

                .log().all();

    }
}
