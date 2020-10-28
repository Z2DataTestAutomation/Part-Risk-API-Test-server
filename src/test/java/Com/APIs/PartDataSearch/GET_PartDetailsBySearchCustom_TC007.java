package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_PartDetailsBySearchCustom_TC007 extends config {

    @Test
    public void PartDetailsBySearchCustom() {
        given().when().get(url + '/'
                + "/api/PartDataSearch/GetPartDetailsBySearchCustom?internalPartNumber=000603-0000&manufacturerPartNumber=&pagesize=10&currentpage=1&Apikey="
                + ViaSatAPIKey).then().assertThat()
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8")
                .body("results.Uploaded_Internal_Part_Number[0]", Is.is("000603-0000")).and()
                .body("results.Uploaded_Manufacturer_Part_Number[0]", Is.is("9918-100-10")).log().all();
    }
}
