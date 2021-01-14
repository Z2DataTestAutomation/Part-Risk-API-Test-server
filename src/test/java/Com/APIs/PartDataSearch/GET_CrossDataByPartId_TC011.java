package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_CrossDataByPartId_TC011 extends config {

    @Test
    public void GetCrossDataByPartId() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetCrossDataByPartId?PartId=32&CurrentPage=1&PageSize=1&Apikey="
                        + API_Key + "&CrossType=DROP-IN C/Downgrade")
                .then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").header("content-Type", "application/json; charset=utf-8").log().all();

    }
    // api not same as ui check part id 10
    @Test
    public void GetCrossDataByPartId_1049_havecrosses(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetCrossDataByPartId?PartId=1049&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("numFound", equalTo( 1)).and()
                .body("results.partID[0]", equalTo( 1049)).and()
                .body("results.partNumber[0]", equalTo( "OPA2379AIDCNR")).and()
                .log().all();

    }
    @Test
    public void GetCrossDataByPartId_31737540_Nothavecrosses(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetCrossDataByPartId?PartId=31737540&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("numFound", equalTo( 0)).and()
                .body("results", Matchers.hasSize(0)).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }


}
