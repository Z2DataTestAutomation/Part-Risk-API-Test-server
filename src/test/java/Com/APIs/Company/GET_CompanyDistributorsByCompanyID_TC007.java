package Com.APIs.Company;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_CompanyDistributorsByCompanyID_TC007 extends config {

    @Test
    public void CompanyDistributorsByCompanyID() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyDistributorsByCompanyID?Apikey=" + API_Key
                        + "&CompanyID=1006096")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK").body("numFound", equalTo(42))
                .header("Content-Type", "application/json; charset=utf-8").log().all();
    }
}
