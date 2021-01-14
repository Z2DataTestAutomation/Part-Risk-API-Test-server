package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GET_InventoryDetailsByPartId_015 extends config {

    @Test
    public void InventoryDetailsByPartId() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetInventoryDetailsByPartId?PartID=32&Apikey=" + API_Key)
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();

    }

    @Test
    public void InventoryDetailsByPartId_10_haveinventory(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetInventoryDetailsByPartId?PartID=10&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("results.inventorySummary[0].zpartId[0]", equalTo( 10)).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }

    @Test
    public void InventoryDetailsByPartId_13719913_Nothaveinventory(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetInventoryDetailsByPartId?PartID=13719913&Apikey="
                        + API_Key)
                .then().assertThat().statusCode(200).and()
                .body("results.inventorySummary[0]", Matchers.hasSize(0)).and()
                .body("results.sellersDetail[0]", Matchers.hasSize(0)).and()
                .body("status", equalTo( "OK")).and()
                .log().all();

    }

}



