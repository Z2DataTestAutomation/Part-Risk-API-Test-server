package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_PartDataByPartId_TC003 extends config {

	@Test
	public void PartDataByPartId() {
		given().when().get(url + '/' + "/api/PartDataSearch/GetPartDataByPartId?PartId=10&Apikey=" + API_Key).then()
				.assertThat().body("results.partSummaryData.partID[0]", Is.is(10)).and()
				.body("results.partSummaryData.partNumber[0]", Is.is("THS6002CDWP")).statusCode(200)
				.statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
	}
}
