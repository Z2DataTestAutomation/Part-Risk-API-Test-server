package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_GetCompanySECFilingDateByCompanyID_TC005 extends config {


    @Test
    public void GetCompanySECFilingDateByCompanyID_1006096() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanySECFilingDateByCompanyID?CompanyID=1006096&Apikey="
                        + API_Key + "&PageNumber=1")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .body("numFound", equalTo(52))
                .body("results.CompanyID[0]", Is.is(1006096))
                .body("results.CompanyName[0]", Is.is("Samtec"))
                .header("Content-Type", "application/json; charset=utf-8").log().all();
    }

}
