package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class GET_UpdatedPartDataWithinDateRange_TC016 extends config {


    @Test
    public void _UpdatedPartDataWithinDateRange() {
        given().when().get(url + '/' + "/api/PartDataSearch/GetUpdatedPartDataWithinDateRange?Apikey=" + ViaSatAPIKey + "&fromDate=06-24-2020 01:00:00&toDate=06-24-2020 01:10:13&pagesize=10&currentpage=1").then().assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }


}
	

