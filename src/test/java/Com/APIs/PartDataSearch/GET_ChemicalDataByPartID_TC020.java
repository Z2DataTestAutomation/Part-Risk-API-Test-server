package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class GET_ChemicalDataByPartID_TC020 extends config {

    @Test
    public void GetChemicalDataByPartID() {

        given().when().get(url + '/' + "/api/PartDataSearch/GetChemicalDataByPartID?Apikey=" + API_Key + "&PartID=1049")
                .then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/json; charset=utf-8").log().all();

    }
    @Test
    public void GetChemicalDataByPartID_10_havechecmical() {
        given().when().get(url+'/'+"/api/PartDataSearch/GetChemicalDataByPartID?Apikey="+API_Key+"&PartID=10")
                .then().assertThat().statusCode(200).and().assertThat().body("results.partID[0]", equalTo(10)).log().all();
    }
    @Test
    public void GetChemicalDataByPartID_4836100_Nothavechecmical(){
        given().when()
                .get(url+ '/' + "/api/PartDataSearch/GetChemicalDataByPartID?Apikey=" + API_Key +"&PartID=4836100")
                .then().assertThat().statusCode(200).and()
                .body("numFound" , equalTo(0)).and()
                .body("pageNumber" , equalTo(1)).and()
                .body("results",Matchers.hasSize(0)).and()
                .body("status" , equalTo("OK")).and().log().all();

    }
}
