package Com.APIs.Company;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;



public class GET_CompanyCompetitorsByCompanyID_TC008 extends config {
	@Test
	public void GetCompanyCompetitorsByCompanyID() {
		given().when()
		.get(url + '/' + "/api/CompanyDataSearch/GetCompanyCompetitorsByCompanyID?Apikey="
				+ API_Key + "&CompanyID=1006096")
		.then()
		.statusCode(200).statusLine("HTTP/1.1 200 OK")
		.header("Content-Type", "application/json; charset=utf-8")
		.body("numFound", equalTo (49)).log().all();		
	}
}
