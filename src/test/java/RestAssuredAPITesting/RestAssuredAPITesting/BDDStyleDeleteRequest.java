package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDDStyleDeleteRequest {
	@Test
	public void test06(){
	
	baseURI="https://dummyjson.com";
	
	given().pathParam("id", 1)
	.when().delete("/users/{id}")
	.then().statusCode(200)
	.log().all();
	}
}
