package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_GetCompanyFinancialDataByName_TC004 extends config {

    @Test
    public void GetCompanyFinancialDataByName_dell() {
        given().
                when().
                get(url + '/' + "/api/CompanyDataSearch/GetCompanyFinancialDataByName?Apikey="
                        + API_Key + "&CompanyName=dell")
                .then().statusCode(200).statusLine(("HTTP/1.1 200 OK"))
                .header("Content-Type", "application/json; charset=utf-8")
                .body("results.CompanyID[0]", Is.is(1006036)).and()
                .body("results.CompanyName[0]", Is.is("Dell Inc.")).log().all();


    }

}
