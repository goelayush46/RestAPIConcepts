package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BDDStyleGetRequest {
	@Test
	public void test01(){
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	RestAssured.given().queryParam("posts", "1").when().get().then().statusCode(200);
	
	}
}
