package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_ComplianceWithCMByPartID_TC017 extends config {

	@Test
	public void ComplianceWithCMByPartID() {
		given().when()
				.get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + API_Key + "&PartID=32")
				.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("content-Type", "application/json; charset=utf-8").log().all();
	}

}
