package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GET_CompanyCompetitorsByCompanyID_TC008 extends config {
    @Test
    public void GetCompanyCompetitorsByCompanyID_1006096() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyCompetitorsByCompanyID?Apikey="
                        + API_Key + "&CompanyID=1006096")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("numFound", equalTo(52)).and()
                .body("results.CompanyID[0]", Is.is(1006096))
                .body("results.CompanyName[0]", Is.is("Samtec")).log().all();
    }
}