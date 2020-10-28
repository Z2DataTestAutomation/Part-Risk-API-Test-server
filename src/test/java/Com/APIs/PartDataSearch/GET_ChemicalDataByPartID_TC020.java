package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET_ChemicalDataByPartID_TC020 extends config {

    @Test
    public void GetChemicalDataByPartID() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetChemicalDataByPartID?Apikey=" + API_Key + "&PartID=1049")
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();

    }

}
