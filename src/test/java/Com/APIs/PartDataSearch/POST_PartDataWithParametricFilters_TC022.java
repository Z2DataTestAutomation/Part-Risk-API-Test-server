package Com.APIs.PartDataSearch;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.xml.bind.CycleRecoverable.Context;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_PartDataWithParametricFilters_TC022 extends config {

	@Test
	public void POST_PartDataWithParametricFilters() {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("keySearch", "bav99");
		requestParams.put("productId", 0);
		requestParams.put("pagesize", 1);
		requestParams.put("currentpage", 3);
		requestParams.put("sortType", "desc");
		requestParams.put("queryOperators", "BeginWith");

		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		request.body(requestParams.toJSONString()).log().all();
		Response response = request.post("/api/PartDataSearch/GetPartDataWithParametricFilters?Apikey=" + API_Key);
		int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode,200);

	}

}
