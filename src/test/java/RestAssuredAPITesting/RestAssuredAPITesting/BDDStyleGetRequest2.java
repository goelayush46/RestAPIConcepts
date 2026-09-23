package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BDDStyleGetRequest2 {
	@Test
	public void test02(){
	baseURI="https://jsonplaceholder.typicode.com";
	RestAssured.given().queryParam("posts", "1").when().get().then().statusCode(200);
	
	}
}
