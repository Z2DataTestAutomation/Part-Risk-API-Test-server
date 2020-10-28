package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_SiteProfileBySiteID_TC024 extends config {

    @Test
    public void GetSiteProfileBySiteID() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetSiteProfileBySiteID?Apikey=" + API_Key + "&SiteID=27812")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8").and()
                .body("results.SiteID[0]", Is.is(27812)).and()
                .body("results.SiteName[0]", Is.is("TEXAS INSTRUMENTS, INC-TICL, PHILIPPINES")).log().all();

    }

}
