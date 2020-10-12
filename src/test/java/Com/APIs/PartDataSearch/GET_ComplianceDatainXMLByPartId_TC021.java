package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_ComplianceDatainXMLByPartId_TC021 extends config {
@Test
	public void GComplianceDatainXMLByPartId() {

		given().when()
				.get(url + '/' + "/api/PartDataSearch/GetComplianceDatainXMLByPartId?Apikey=" + API_Key + "&PartID=10")
				.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("content-Type", "application/xml").log().all();

	}
}
