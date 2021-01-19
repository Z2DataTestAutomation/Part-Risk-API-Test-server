package Com.APIs.Company;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CompanyProfileByCompanyID_TC016 extends config {

    @Test
    public void CompanyProfileByCompanyID_1006096() {

        given().when()
                .get(url + '/' + "/api/CompanyDataSearch/GetCompanyProfileByCompanyID?Apikey=" + API_Key
                        + "&CompanyID=1006096")
                .then().body("results.CompanyID[0]", Is.is(1006096)).and()
                .body("results.CompanyName[0]", Is.is("Samtec"))
                .header("Content-Type", Is.is("application/json; charset=utf-8")).statusCode(200).log().all();

    }
}
