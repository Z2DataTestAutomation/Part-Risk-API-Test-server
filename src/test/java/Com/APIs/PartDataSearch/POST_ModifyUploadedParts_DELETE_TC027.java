package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_ModifyUploadedParts_DELETE_TC027 extends config {

    @Test
    public void ModifyUploadedParts_DELETE() {

        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("changeType", "delete");
        requestParams.put("internalPartNumber", "Test234");
        requestParams.put("manufacturerPartNumber", "Bav99");
        requestParams.put("manufacturer", "Toshiba");
        requestParams.put("description", "testDes");
        requestParams.put("featureName", "temp");
        requestParams.put("featurevalue", "23");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ModifyUploadedParts?Apikey=" + ViaSatAPIKey);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


}
