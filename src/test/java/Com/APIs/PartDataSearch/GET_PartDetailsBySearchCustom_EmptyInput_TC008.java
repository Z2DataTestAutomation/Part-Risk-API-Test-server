package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_PartDetailsBySearchCustom_EmptyInput_TC008 extends config {

	
	@Test
	public void PartDetailsBySearchCustom_EmptyInput () {
		
		given().when().get(url + '/' + "/api/PartDataSearch/GetPartDetailsBySearchCustom?Apikey=" + ViaSatAPIKey)
		.then().statusCode(400)
		.log().all();
		
	}
	
	
}
