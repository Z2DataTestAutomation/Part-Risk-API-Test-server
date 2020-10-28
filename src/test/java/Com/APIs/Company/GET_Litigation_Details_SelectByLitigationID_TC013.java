package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_Litigation_Details_SelectByLitigationID_TC013 extends config {
    @Test
    public void Litigation_Details_SelectByLitigationID() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/Litigation_Details_SelectByLitigationID?Apikey=" + API_Key
                        + "&LitigationID=21677")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("Content-Type", "application/json; charset=utf-8")
                .and().body("results.CaseID[0]", Is.is(21677)).and().body("results.Title[0]", Is.is("Estate Susan Neveu v. Texas Instruments Incorporated et al")).log().all();
    }

}
