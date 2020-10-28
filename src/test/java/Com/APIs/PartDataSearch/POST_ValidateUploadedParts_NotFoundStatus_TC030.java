package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_ValidateUploadedParts_NotFoundStatus_TC030 extends config {
    @Test
    public void ValidateUploadedParts_NotFoundStatus() {
        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("PartID", 1);
        requestParams.put("mpn", "BAV99");
        requestParams.put("man", "Toshipa");

        requestParams.put("PartID", 2);
        requestParams.put("mpn", "BAV99");
        requestParams.put("man", "Texas");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ValidateUploadedParts?Apikey=" + API_Key);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
