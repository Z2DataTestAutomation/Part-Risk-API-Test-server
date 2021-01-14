package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_PartValidation_TC010 extends config {
    @Test
    public void PartValidation() {
        given().when().get(url + '/' + "/api/PartDataSearch/PartValidation?keySearch=bav99&CompanyName=toshiba&Apikey=" + API_Key)
                .then().assertThat().body("results.partSummaryData.partID[0]", Is.is(4836100)).and().body("results.partSummaryData.partNumber[0]", Is.is("BAV99"))
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
    }
    @Test
    public void PartValidation_Part_bav99_MAN_Infinex() {

        given().when().get(url + '/' + "/api/PartDataSearch/PartValidation?keySearch=bav99&CompanyName=Infinex&Apikey="
                + ViaSatAPIKey)
                .then().assertThat().statusCode(200).and()
                .body("results.partSummaryData.partID[0]" , equalTo(24228032)).and()
                .body("results.partSummaryData.partNumber[0]" , equalTo("BAV99")).and()
                .body("results.partSummaryData.CompanyName[0]" , equalTo("Infinex")).and()
                .log().all();

    }
    @Test
    public void PartValidation_PartConfig_RTT0122R6FTH_MAN_Ralec() {

        given().when().get(url + '/' + "/api/PartDataSearch/PartValidation?keySearch=RTT0122R6FTH&CompanyName=Ralec&Apikey="
                + ViaSatAPIKey)
                .then().assertThat().statusCode(200).and()
                .body("results.partSummaryData.partNumber[0]" , equalTo("RTT0122R6FTH")).and()
                .body("results.partSummaryData.DisplayName[0]" , equalTo("Ralec")).and()
                .log().all();

    }

}
