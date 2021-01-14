package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_PartDetailsBySearch_TC006 extends config {

    @Test
    public void PartDetailsBySearch() {
        given().when().get(url + '/'
                + "/api/PartDataSearch/GetPartDetailsBySearch?keySearch=MAX4233ABC&CompanyName=&Pagesize=5&Currentpage=1&Apikey="
                + API_Key)
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }
    @Test
    public void PartDetailsBySearch_bav99() {
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearch?keySearch=bav99&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("results.partSummaryData.partID[0]" , equalTo(4836100)).and()
                .body("results.partSummaryData.partNumber[0]" , equalTo("BAV99")).and()
                .body("status", equalTo("OK")).and()
                .log().all();
    }
    @Test
    public void PartDetailsBySearch_PartConfig_RTT0122R6FTH() {
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearch?keySearch=RTT0122R6FTH&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("numFound" ,equalTo(1))
                // part id changed in partconfig
               // .body("results.partSummaryData.partID[0]" , equalTo(1000845365)).and()
                .body("results.partSummaryData.partNumber[0]" , equalTo("RTT0122R6FTH")).and()
                .body("status", equalTo("OK")).and()
                .log().all();
    }
}
