package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyPatentDetailsByPatentID_TC011 extends config {

    @Test
    public void CompanyPatentDetailsByPatentID() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyPatentDetailsByPatentID?Apikey="
                        + API_Key + "&PatentID=25383627")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("results.PatentID[0]", Is.is(25383627)).and().body("results.PatentTitle[0]", Is.is("Pitch multiplication process")).log().all();
    }

}
