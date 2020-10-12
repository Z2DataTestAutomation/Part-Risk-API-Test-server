package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_PartDataByPartId_PartConfig_TC004 extends config {
	@Test
	public void PartDataByPartId_PartConfig () {
		
		given().when().get(url + '/' + "/api/PartDataSearch/GetPartDataByPartId?PartId=1000078207&Apikey=" + API_Key)
		.then().assertThat().body("results.partSummaryData.partID[0]", Is.is(1000078207)).and().body("results.partSummaryData.partNumber[0]",Is.is("RTT0122R6FTH"))
		.statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
	}
	

}
