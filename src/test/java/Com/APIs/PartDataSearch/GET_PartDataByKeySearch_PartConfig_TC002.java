package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_PartDataByKeySearch_PartConfig_TC002 extends config {
	@Test
	public void PartDataByKeySearch_PartConfig() {

		given().when()
				.get(url + '/' + "/api/PartDataSearch/GetPartDataByKeySearch?keySearch=RTT0122R6FTH&Apikey=" + API_Key)
				.then().assertThat().body("results.partID[0]", Is.is(25910425))
				.statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

	}

}
