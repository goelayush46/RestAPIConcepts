package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BDDStylePatchRequest {
	@Test
	public void test05(){
	
	baseURI="https://dummyjson.com";
	
	JSONObject jsondata=new JSONObject();
	jsondata.put("firstName", "John");
	
	given().header("Content-Type","application/json").contentType(ContentType.JSON).body(jsondata.toJSONString())
	.when().patch("/users/1")
	.then().statusCode(200).log().all();
	}
}
