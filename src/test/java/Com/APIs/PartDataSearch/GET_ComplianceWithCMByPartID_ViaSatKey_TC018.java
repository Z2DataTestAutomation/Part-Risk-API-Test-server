package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;

import Com.APIs.Company.config;

public class GET_ComplianceWithCMByPartID_ViaSatKey_TC018 extends config {

	public void ComplianceWithCMByPartID_ViaSatKey() {

		given().when()
				.get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey
						+ "&PartID=1049")
				.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("content-Type", "application/json; charset=utf-8").log().all();
	}

}
