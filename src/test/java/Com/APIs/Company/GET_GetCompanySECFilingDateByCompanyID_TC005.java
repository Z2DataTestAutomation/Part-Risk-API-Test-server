package Com.APIs.Company;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_GetCompanySECFilingDateByCompanyID_TC005 extends config {


    @Test
    public void GetCompanySECFilingDateByCompanyID() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanySECFilingDateByCompanyID?CompanyID=1006096&Apikey=" + API_Key + "&PageNumber=1")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .body("numFound", equalTo(52))
                .header("Content-Type", "application/json; charset=utf-8").log().all();
    }

}
