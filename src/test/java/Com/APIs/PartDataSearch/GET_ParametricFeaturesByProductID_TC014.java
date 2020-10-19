package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_ParametricFeaturesByProductID_TC014 extends config {

	@Test
	public void ParametricFeaturesByProductID() {

		given().when()
				.get(url + '/' + "/api/PartDataSearch/GetParametricFeaturesByProductID?Apikey=" + API_Key
						+ "&ProductID=4404")
				.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("content-Type", "application/json; charset=utf-8").log().all();
	}

}
