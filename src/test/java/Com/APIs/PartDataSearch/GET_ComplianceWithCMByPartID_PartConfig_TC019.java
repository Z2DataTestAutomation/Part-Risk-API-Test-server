package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_ComplianceWithCMByPartID_PartConfig_TC019 extends config{
	
	
	@Test
	public void ComplianceWithCMByPartID_PartConfig () {
		given().when()
		.get(url + '/' + "/api/PartDataSearch/GetComplianceWithCMByPartID?Apikey=" + ViaSatAPIKey
				+ "&PartID=1000078207")
		.then().assertThat().body("results.partID[0]", Is.is(1000078207)).and()
		.body("results.partNumber[0]", Is.is("RTT0122R6FTH")).statusCode(200).statusLine("HTTP/1.1 200 OK")
		.header("content-Type", "application/json; charset=utf-8").log().all();
	}

}
