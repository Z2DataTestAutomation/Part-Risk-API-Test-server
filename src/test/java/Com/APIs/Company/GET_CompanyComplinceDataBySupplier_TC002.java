package Com.APIs.Company;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_CompanyComplinceDataBySupplier_TC002 extends config {

    @Test
    public void CompanyComplianceDataBySupplierName() {
        given().when()
                .get(url + '/' + "api/CompanyDataSearch/CompanyComplianceDataBySupplierName?CompanyName=apple&Apikey="
                        + API_Key + "&CompanyID=1006096")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("numFound", equalTo(1)).log().all();
    }
}
