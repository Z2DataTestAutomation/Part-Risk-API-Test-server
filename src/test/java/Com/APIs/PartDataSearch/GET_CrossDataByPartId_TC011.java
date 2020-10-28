package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_CrossDataByPartId_TC011 extends config {

    @Test
    public void GetCrossDataByPartId() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetCrossDataByPartId?PartId=32&CurrentPage=1&PageSize=1&Apikey="
                        + API_Key + "&CrossType=DROP-IN C/Downgrade")
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }

}
