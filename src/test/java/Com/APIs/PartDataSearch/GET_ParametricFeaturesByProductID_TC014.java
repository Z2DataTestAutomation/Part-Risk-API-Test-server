package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_ParametricFeaturesByProductID_TC014 extends config {

    @Test
    public void ParametricFeaturesByProductID() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetParametricFeaturesByProductID?Apikey=" + API_Key
                        + "&ProductID=4404")
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();
    }
    @Test
    public void ParametricFeaturesByProductID_21691(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetParametricFeaturesByProductID?Apikey="
                        + API_Key + "&ProductID=21691")
                .then().assertThat().statusCode(200).and()
                .body("numFound" , equalTo(1)).and()
                .body("results.ProductID[0]", equalTo( 21691)).and()
                .body("results.ProductName[0]", equalTo("NVRAM")).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }

}
