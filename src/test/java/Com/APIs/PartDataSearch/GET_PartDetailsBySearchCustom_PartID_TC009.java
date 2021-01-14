package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GET_PartDetailsBySearchCustom_PartID_TC009 extends config {

    @Test
    public void PartDetailsBySearchCustom_PartID() {
        given().when().get(url + '/'
                + "/api/PartDataSearch/GetPartDetailsBySearchCustom?partID=10000396&pagesize=50&currentpage=1&Apikey="
                + ViaSatAPIKey).then().body("results.Uploaded_Internal_Part_Number[0]", Is.is("000930-0001")).and()
                .body("results.Uploaded_Manufacturer_Part_Number[0]", Is.is("390261-3")).log().all();
    }
    @Test
    public void PartDetailsBySearchCustom_PartID_10_ViasatAPIKey() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?partID=10000396&Apikey="
                 + ViaSatAPIKey )
                .then().assertThat().statusCode(200).and()
                .body("numFound", equalTo(1)).and()
                .body("results.partID[0]", equalTo("10000396")).and()
                .body("status" , equalTo("OK"))
                .log().all();

    }
    @Test
    public void PartDetailsBySearchCustom_IPN_000930_0001_ViasatAPIKey() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?internalPartNumber=000930-0001&Apikey="
                + ViaSatAPIKey )
                .then().assertThat().statusCode(200).and()
                .body("results.Uploaded_Internal_Part_Number[0]", equalTo("000930-0001")).and()
                .body("status" , equalTo("OK"))
                .log().all();

    }
    @Test
    public void PartDetailsBySearchCustom_MPN_390261_3_ViasatAPIKey() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?manufacturerPartNumber=390261-3&Apikey="
                + ViaSatAPIKey )
                .then().assertThat().statusCode(200).and()
                .body("results.Uploaded_Manufacturer_Part_Number[0]", equalTo("390261-3")).and()
                .body("status" , equalTo("OK"))
                .log().all();

    }
    // Why not have data, why numfound and num page not found
    @Test
    public void PartDetailsBySearchCustom_MAN_Molex_ViasatAPIKey() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?manufacturer=molex&Apikey="
                + ViaSatAPIKey )
                .then().assertThat().statusCode(200).and()
               .body("results.Uploaded_Manufacturer[0]", equalTo("MOLEX")).and()
                .body("status" , equalTo("OK"))
                .log().all();

    }
}
