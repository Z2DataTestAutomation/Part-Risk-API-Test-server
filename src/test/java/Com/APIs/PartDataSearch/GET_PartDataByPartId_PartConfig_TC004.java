package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_PartDataByPartId_PartConfig_TC004 extends config {
    @Test
    public void PartDataByPartId_PartConfig() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDataByPartId?PartId=1000078207&Apikey=" + API_Key)
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }


}
