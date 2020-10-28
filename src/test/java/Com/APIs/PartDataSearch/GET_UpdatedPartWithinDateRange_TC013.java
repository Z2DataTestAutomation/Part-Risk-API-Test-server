package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_UpdatedPartWithinDateRange_TC013 extends config {

    @Test
    public void UpdatedPartWithinDateRange() {
        given().when().get(url + '/' + "/api/PartDataSearch/GetUpdatedPartWithinDateRange?Apikey=" + API_Key + "&fromDate=03-01-2019&toDate=06-17-2020").then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }

}
