package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyDirectorsByCompanyID_TC022 extends config {


    @Test
    public void CompanyDirectorsByCompanyID() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyDirectorsByCompanyID?Apikey=" + API_Key + "&CompanyID=1006096")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("statusCode",Is.is("200"))
                .and().body("results.CompanyName[0]", Is.is("Texas Instruments Incorporated"))
                .log().all();

    }

}
