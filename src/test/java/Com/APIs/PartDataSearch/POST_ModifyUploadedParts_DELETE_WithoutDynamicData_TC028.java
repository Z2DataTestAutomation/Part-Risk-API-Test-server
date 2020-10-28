package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_ModifyUploadedParts_DELETE_WithoutDynamicData_TC028 extends config {
    @Test
    public void ModifyUploadedParts_DELETE_WithoutDynamicData() {

        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("changeType", "delete");
        requestParams.put("internalPartNumber", "Test24");
        requestParams.put("manufacturerPartNumber", "BBB");
        requestParams.put("manufacturer", "BBB");
        requestParams.put("description", "test");


        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ModifyUploadedParts?Apikey=" + ViaSatAPIKey);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


}
