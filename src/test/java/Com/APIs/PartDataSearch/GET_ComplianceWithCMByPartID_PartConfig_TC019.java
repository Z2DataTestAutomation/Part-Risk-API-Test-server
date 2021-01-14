package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_ComplianceWithCMByPartID_PartConfig_TC019 extends config {


    @Test
    public void ComplianceWithCMByPartID_PartConfig() {
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey
                        + "&PartID=1000078207")
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();
    }
    @Test
    public void ComplianceWithCMByPartID_PartConfig_1000078207(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey
                        + "&PartID=1000078207")
                .then().assertThat().statusCode(200).and()
                .body("numFound", equalTo(1)).and()
                .body("results.partID[0]" , equalTo(1000078207)).and()
                // part number not appear on test but appear on prod
              //  .body("results.partNumber[0]" , equalTo("RTT0122R6FTH")).and()
                .body("results.material_declaration[0].source[0]" , equalTo(""))
                .log().all();
    }
   // how to print specific value from json
}
