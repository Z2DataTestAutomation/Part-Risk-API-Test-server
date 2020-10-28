package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_PartDetailsBySearchCustom_EmptyInput_TC008 extends config {


    @Test
    public void PartDetailsBySearchCustom_EmptyInput() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?Apikey=" + ViaSatAPIKey)
                .then().statusCode(400)
                .log().all();

    }


}
