package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_PartValidation_TC010 extends config {
    @Test
    public void PartValidation() {
        given().when().get(url + '/' + "/api/PartDataSearch/PartValidation?keySearch=bav99&CompanyName=toshiba&Apikey=" + API_Key)
                .then().assertThat().body("results.partSummaryData.partID[0]", Is.is(4836100)).and().body("results.partSummaryData.partNumber[0]", Is.is("BAV99"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }

}
