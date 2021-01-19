package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyAcquisitionsByCompanyID_TC018 extends config {

    @Test
    public void CompanyAcquisitionsByCompanyID_1006096() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyAcquisitionsByCompanyID?Apikey=" + API_Key
                        + "&CompanyID=1006096")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8").and()
                .body("results.CompanyID[0]", Is.is(1006096)).and()
                .body("results.CompanyName[0]", Is.is("Samtec")).log().all();
    }
}
