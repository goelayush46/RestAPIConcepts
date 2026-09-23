package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BDDStylePostRequest {
	@Test
	public void test03(){
	
	JSONObject jsondata = new JSONObject();
    jsondata.put("firstName", "Ayush");
    jsondata.put("lastName", "Goyal");
    jsondata.put("age", 30);
	
	baseURI="https://dummyjson.com";
	given().contentType(ContentType.JSON).body(jsondata.toJSONString())
	.when().post("/users/add")
	.then().statusCode(201).log().all();
	}
}
