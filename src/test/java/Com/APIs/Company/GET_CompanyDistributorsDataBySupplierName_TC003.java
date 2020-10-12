package Com.APIs.Company;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;



public class GET_CompanyDistributorsDataBySupplierName_TC003 extends config {
	@Test
	public void CompanyDistributorsDataBySupplierName() {
		given().when()
				.get(url+
			    	'/'+ "/api/CompanyDataSearch/CompanyDistributorsDataBySupplierName?CompanyName=apple&Apikey="+API_Key+"&CompanyID=1006096")
				.then()
				.statusCode(200).statusLine("HTTP/1.1 200 OK")
				.body("numFound", equalTo (1))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
		
				
		        

	}

}
