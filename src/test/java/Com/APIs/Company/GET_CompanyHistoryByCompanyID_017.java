package Com.APIs.Company;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

public class GET_CompanyHistoryByCompanyID_017 extends config {

	@Test
	public void GetCompanyHistoryByCompanyID() {
		given().when()
		.get(url + '/' + "/api/CompanyDataSearch/GetCompanyHistoryByCompanyID?Apikey=" + API_Key
				+ "&CompanyID=1006096")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.header("Content-Type", "application/json; charset=utf-8").and()
		.body("results.CompanyID[0]", Is.is(1006096)).and()
		.body("results.CompanyName[0]", Is.is("Samtec")).log().all();
	}
}