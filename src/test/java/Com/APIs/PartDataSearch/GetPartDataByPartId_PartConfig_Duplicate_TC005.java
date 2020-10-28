package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPartDataByPartId_PartConfig_Duplicate_TC005 extends config {
    @Test
    public void PartDataByPartId_PartConfig_Duplicate_parametric() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetPartDataByPartId?PartId=1000079600&Apikey=" + API_Key)
                .then().assertThat().body("results.partSummaryData.partID[0]", Is.is(1000079600)).and()
                .body("results.partSummaryData.partNumber[0]", Is.is("SCMM1206S1-R002F"))
                .statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();
    }

}
