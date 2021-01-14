package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_PartDataByKeySearch_PartConfig_TC002 extends config {
    @Test
    public void PartDataByKeySearch_PartConfig() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetPartDataByKeySearch?keySearch=RTT0122R6FTH&Apikey=" + API_Key)
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }
    //Need to know what is mean by keysearch
    @Test
    public void PartDataByKeySearch_PartConfig_RTT0122R6FTH(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetPartDataByKeySearch?keySearch=RTT0122R6FTH&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("numFound" , equalTo(1)).and()
                .body("results.partNumber[0]", equalTo( "RTT0122R6FTH")).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }

}
