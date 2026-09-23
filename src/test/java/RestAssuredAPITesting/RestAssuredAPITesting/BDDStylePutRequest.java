package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BDDStylePutRequest {
	@Test
	public void test04(){
	
	baseURI="https://dummyjson.com";
	
	JSONObject jsondata=new JSONObject();
	jsondata.put("firstName", "Sheetal");
	jsondata.put("age", 30);
	
	given().header("Content-Type","application/json").contentType(ContentType.JSON).body(jsondata.toJSONString())
	.when().put("/users/1")
	.then().statusCode(200).log().all();
	}
}
