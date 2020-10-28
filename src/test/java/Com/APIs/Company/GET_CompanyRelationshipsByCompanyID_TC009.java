package Com.APIs.Company;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_CompanyRelationshipsByCompanyID_TC009 extends config {
    @Test
    public void CompanyRelationshipsByCompanyID() {
        given().when()
                .get(url + '/' + "api/CompanyDataSearch/GetCompanyRelationshipsByCompanyID?Apikey="
                        + API_Key + "&CompanyID=1006096")
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .body("numFound", equalTo(43)).log().all();
    }

}
