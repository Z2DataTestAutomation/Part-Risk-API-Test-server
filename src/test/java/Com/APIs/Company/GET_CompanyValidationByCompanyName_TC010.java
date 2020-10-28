package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyValidationByCompanyName_TC010 extends config {

    @Test
    public void CompanyValidationByCompanyName() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyValidationByCompanyName?CompanySearch=apple&pageNumber=1&Apikey="
                        + API_Key + "&Website=apple.com")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("results.CompanyID[0]", Is.is(1000376)).and().body("results.CompanyName[0]", Is.is("Apple Inc.")).log().all();
    }
}
