package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_ProductLineList_TC0012 extends config {
    @Test
    public void ProductLineList() {
        given().when().get(url + '/' + "/api/PartDataSearch/GetProductLineList?Apikey=" + API_Key).then().assertThat()
                .body("results.productID[1]", Is.is(1004649)).and()
                .body("results.productName[0]", Is.is("Tantalum Polymer Capacitors")).statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }
    @Test
    public void ProductLineList_ViasatAPIKey() {
        given().when().get(url + '/' + "/api/PartDataSearch/GetProductLineList?Apikey=" + ViaSatAPIKey).then().assertThat()
                .body("results.productID[1]", Is.is(1004649)).and()
                .body("results.productName[0]", Is.is("Tantalum Polymer Capacitors")).statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }
}