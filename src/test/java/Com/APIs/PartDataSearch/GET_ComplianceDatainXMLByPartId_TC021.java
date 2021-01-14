package Com.APIs.PartDataSearch;

import Com.APIs.Company.config;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class GET_ComplianceDatainXMLByPartId_TC021 extends config {
    @Test
    public void GComplianceDatainXMLByPartId() {

        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceDatainXMLByPartId?Apikey=" + API_Key + "&PartID=10")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .header("content-Type", "application/xml").log().all();

    }
    @Test
    public void GComplianceDatainXMLByPartId_740147_havecompliancedata(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceDatainXMLByPartId?Apikey=" + API_Key + "&PartID=740147")
                .then().assertThat().statusCode(200).and()
                // Need path
               // .body("Response date.Authorizer name.Email address", equalTo("info@z2data.com")).and()
                .header("content-type" , equalTo("application/xml")).log().all();
    }

    @Test
    public void GComplianceDatainXMLByPartId_4815043_Nothavecompliancedata(){
        given().when()
                .get(url + '/' + "/api/PartDataSearch/GetComplianceDatainXMLByPartId?Apikey=" + API_Key + "&PartID=4815043")
                 .then().assertThat().statusCode(200).and()
               //  .body().and()
                 .header("content-type" , equalTo("application/xml")).and()
                 .header("content-length" , equalTo("0")).log().all();
    }
}
