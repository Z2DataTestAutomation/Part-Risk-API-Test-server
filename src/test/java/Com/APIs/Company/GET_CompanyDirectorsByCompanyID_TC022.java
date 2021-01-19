package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyDirectorsByCompanyID_TC022 extends config {


    @Test
    public void CompanyDirectorsByCompanyID_1006008() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyDirectorsByCompanyID?Apikey=" + API_Key
                        + "&CompanyID=1006008")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .and().body("results.CompanyName[0]", Is.is("Molex Incorporated"))
                .log().all();


    }


}
