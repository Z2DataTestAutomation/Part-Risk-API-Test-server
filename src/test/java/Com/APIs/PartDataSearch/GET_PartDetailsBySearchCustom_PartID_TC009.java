package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GET_PartDetailsBySearchCustom_PartID_TC009 extends config {

    @Test
    public void PartDetailsBySearchCustom_PartID() {
        given().when().get(url + '/'
                + "/api/PartDataSearch/GetPartDetailsBySearchCustom?partID=10000396&pagesize=50&currentpage=1&Apikey="
                + ViaSatAPIKey).then().body("results.Uploaded_Internal_Part_Number[0]", Is.is("000930-0001")).and()
                .body("results.Uploaded_Manufacturer_Part_Number[0]", Is.is("390261-3")).log().all();
    }
}
