package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_PartDetailsBySearchCustom_EmptyInput_TC008 extends config {


    @Test
    public void PartDetailsBySearchCustom_EmptyInput() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?Apikey=" + ViaSatAPIKey)
                .then().statusCode(400)
                .log().all();

    }
    // why fail
    @Test
    public void PartDetailsBySearchCustom_Empty_Input() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom")
                .then().assertThat().statusCode(400).and()
                .body("status" , equalTo("API Key is missing"))
                .log().all();

    }
    @Test
    public void PartDetailsBySearchCustom_Input_ApiKey() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?Apikey="
                 + ViaSatAPIKey)
                .then().assertThat().statusCode(400).and()
                .body("status" , equalTo("One value from (InternalPartNumber, ManufacturerPartNumber, Manufacturer, PartID) is required."))
                .log().all();

    }

}
