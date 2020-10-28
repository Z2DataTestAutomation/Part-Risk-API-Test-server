package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_ModifyUploadedParts_ADD_WithoutDynamicData_TC025 extends config {
    @Test
    public void ModifyUploadedParts_ADD_WithoutDynamicData() {

        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("changeType", "Add");
        requestParams.put("internalPartNumber", "Test789");
        requestParams.put("manufacturerPartNumber", "Bav99");
        requestParams.put("manufacturer", "Toshiba");
        requestParams.put("description", "testDes");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ModifyUploadedParts?Apikey=" + ViaSatAPIKey);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

}
