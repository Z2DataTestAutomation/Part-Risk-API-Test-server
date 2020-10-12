package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_PartDetailsBySearch_TC006 extends config {

	@Test
	public void PartDetailsBySearch() {
		given().when().get(url + '/'
				+ "/api/PartDataSearch/GetPartDetailsBySearch?keySearch=MAX4233ABC&CompanyName=&Pagesize=5&Currentpage=1&Apikey="
				+ API_Key)
		.then().assertThat().body("results.partSummaryData.partID[0]", Is.is(1005381)).and().body("results.partSummaryData.partNumber[0]",Is.is("MAX4233ABC"))
		.statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();
				
	}

}
