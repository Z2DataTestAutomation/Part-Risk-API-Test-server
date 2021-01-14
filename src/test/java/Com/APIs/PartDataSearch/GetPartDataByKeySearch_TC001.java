package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPartDataByKeySearch_TC001 extends config {

    @Test
    public void PartDataByKeySearch() {
        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDataByKeySearch?keySearch=bav99&Apikey=" + API_Key)
                .then().assertThat().body("results.partID[0]", Is.is(4836100)).statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }
    @Test
    public void PartDataByKeySearch_Part_BAV99(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetPartDataByKeySearch?keySearch=bav99&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("results.partNumber[0]", equalTo( "BAV99")).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }
}
