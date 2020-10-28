package Com.APIs.Company;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_GetCompanyFinancialDataByName_TC004 extends config {

    @Test
    public void GetCompanyFinancialDataByName() {
        given().
                when().
                get(url + '/' + "/api/CompanyDataSearch/GetCompanyFinancialDataByName?Apikey=" + API_Key + "&CompanyName=dell")
                .then().statusCode(200).statusLine(("HTTP/1.1 200 OK")).header("Content-Type", "application/json; charset=utf-8")
                .body("numFound", equalTo(10));


    }

}
