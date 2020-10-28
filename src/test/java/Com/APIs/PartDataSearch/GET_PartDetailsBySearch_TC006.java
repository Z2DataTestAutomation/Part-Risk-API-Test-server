package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_PartDetailsBySearch_TC006 extends config {

    @Test
    public void PartDetailsBySearch() {
        given().when().get(url + '/'
                + "/api/PartDataSearch/GetPartDetailsBySearch?keySearch=MAX4233ABC&CompanyName=&Pagesize=5&Currentpage=1&Apikey="
                + API_Key)
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }

}
