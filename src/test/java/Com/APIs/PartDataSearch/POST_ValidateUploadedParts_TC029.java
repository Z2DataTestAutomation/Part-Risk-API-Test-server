package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POST_ValidateUploadedParts_TC029 extends config {
    @Test
    public void ValidateUploadedParts() {
        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("PartID", 4836100);
        requestParams.put("mpn", "BAV99");
        requestParams.put("man", "Toshiba");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ValidateUploadedParts?Apikey=" + ViaSatAPIKey);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void ValidateUploadedParts2() {
        RestAssured.baseURI = url;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("PartID", 4836100);
        requestParams.put("mpn", "BAV99");
        requestParams.put("man", "Toshiba");

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        request.body(requestParams.toJSONString()).log().all();
        Response response = request.post("/api/PartDataSearch/ValidateUploadedParts?Apikey=" + ViaSatAPIKey);
        //response.then().body("results.mpn[0]", Is.is("BAV99")).log().all();
        response.then().assertThat().statusCode(200).log().all();
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);


    }
    /*
    @Test
    public void ValidateUploadedParts3() {
        given().when()
                .get(url + "/api/PartDataSearch/ValidateUploadedParts?Apikey=" + ViaSatAPIKey)
                .then().assertThat().body("results.mpn[0]", Is.is("BAV99")).log().all();
}*/
}
