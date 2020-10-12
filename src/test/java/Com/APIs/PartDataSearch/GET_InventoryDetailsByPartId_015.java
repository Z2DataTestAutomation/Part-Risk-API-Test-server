package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import Com.APIs.Company.config;

public class GET_InventoryDetailsByPartId_015 extends config {

	@Test
	public void InventoryDetailsByPartId() {

		given().when().get(url + '/' + "/api/PartDataSearch/GetInventoryDetailsByPartId?PartID=32&Apikey=" + API_Key)
				.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
				.header("content-Type", "application/json; charset=utf-8").log().all();

	}

}
