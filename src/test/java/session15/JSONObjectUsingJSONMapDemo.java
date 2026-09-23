package session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class JSONObjectUsingJSONMapDemo {
	@Test(enabled=false)
	public void CreateAuthToken() {
		Map<String, String> authToken=new HashMap<>();
		authToken.put("username", "admin");
		authToken.put("password","password123");
		
		Response response=RestAssured.given()
			.baseUri("https://restful-booker.herokuapp.com/auth")
			.header("Content-Type","application/json")
			.body(authToken)
			.post();
		
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test
	public void CreateUser() {
		HashMap<String,Object> userData=new HashMap<String,Object>();
		userData.put("firstName", "Amod");
		userData.put("lastName", "Mahajan");
		userData.put("age", 28);
		userData.put("salary", 10000.56);
		userData.put("IsMarried", true);
		
		ArrayList<String> hobbies=new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("Computers");
		hobbies.add("Games");
		userData.put("Hobbies", hobbies);
		
		HashMap<String,String> techSkills=new HashMap<String,String>();
		techSkills.put("Prgramming Language", "Java");
		techSkills.put("Web Automation", "Selenium");
		techSkills.put("API Automation", "Rest Assured");
		userData.put("TechSkills", techSkills);
		
		Response response=RestAssured.given()
			.baseUri("https://reqres.in/api/users")
			.header("Content-Type","application/json")
			.header("x-api-key","reqres_280aa640a27c4378b8b42d7fa0633285")
			.body(userData)
			.post();
		
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 201);
	}
}
