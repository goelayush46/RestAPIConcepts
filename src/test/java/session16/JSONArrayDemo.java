package session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class JSONArrayDemo {
	@Test(enabled=false)
	public void createUserUsingJSONArray() {
		//Create JSONObject for Users
		JSONObject user1=new JSONObject();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		JSONObject user2=new JSONObject();
		user2.put("firstName", "Prerna");
		user2.put("lastName", "Gupta");
		user2.put("age", 28);
		user2.put("salary", 12000.56);
		
		//Add JSONObjects to JSON Array
		JSONArray userPayLoad=new JSONArray();
		userPayLoad.add(user1);
		userPayLoad.add(user2);
		
		Response response=RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.header("x-api-key","reqres_280aa640a27c4378b8b42d7fa0633285")
		.body(userPayLoad)
		.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	@Test
	public void createJSONArrayUsingList() {
		//Create JSONObject for Users
		Map<String, Object> user1=new HashMap<String, Object>();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		Map<String, Object> user2=new HashMap<String, Object>();
		user2.put("firstName", "Prerna");
		user2.put("lastName", "Gupta");
		user2.put("age", 28);
		user2.put("salary", 12000.56);
		
		//Add JSONObjects to JSON Array
		List<Map<String, Object>> jsonArrayListPayLoad=new ArrayList<>();
		jsonArrayListPayLoad.add(user1);
		jsonArrayListPayLoad.add(user2);
		
		Response response=RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.header("x-api-key","reqres_280aa640a27c4378b8b42d7fa0633285")
		.body(jsonArrayListPayLoad)
		.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 201);
	}
}
