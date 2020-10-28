package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyFinancialSegmentCompanyID_TC026 extends config {

    @Test
    public void CompanyFinancialSegmentCompanyID() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyFinancialSegmentByCompanyID?Apikey=" + API_Key + "&CompanyID=1005070")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8").and()
                .body("results.CompanyID[0]", Is.is(1005070)).and()
                .body("results.CompanyName[0]", Is.is("Texas Instruments Incorporated")).log().all();


    }

}
