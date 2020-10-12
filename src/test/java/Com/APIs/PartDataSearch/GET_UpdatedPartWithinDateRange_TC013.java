package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_UpdatedPartWithinDateRange_TC013 extends config {

	@Test
	public void UpdatedPartWithinDateRange() {
		given().when().get(url + '/' + "/api/PartDataSearch/GetUpdatedPartWithinDateRange?Apikey=" + API_Key + "&fromDate=03-01-2019&toDate=06-17-2020").then().assertThat()
				.body("results.PartID[0]", Is.is(7795701)).and()
				.body("results.PartNumber[0]", Is.is("ALL-2")).statusCode(200)
				.statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
	}

}
