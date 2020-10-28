package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_ComplianceDatainXMLByPartId_TC021 extends config {
    @Test
    public void GComplianceDatainXMLByPartId() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceDatainXMLByPartId?Apikey=" + API_Key + "&PartID=10")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/xml").log().all();

    }
}
