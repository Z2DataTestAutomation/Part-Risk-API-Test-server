package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_GetCompanyNewsByCompanyID_TC006 extends config {
    @Test
    public void GetCompanyNewsByCompanyID() {
        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyNewsByCompanyID?CompanyID=1006096&Apikey=" + API_Key
                        + "&PageNumber=1")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK").body("results.CompanyID[0]", Is.is(1006096))
                .body("results.CompanyName[0]", Is.is("Samtec"))
                .header("Content-Type", "application/json; charset=utf-8").log().all();
    }

}
