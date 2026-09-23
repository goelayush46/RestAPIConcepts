package session19;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnAPIServerTestingforCRUD {

	@BeforeClass
	public void setupDefault() {
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.setBaseUri("http://localhost:3000")
				.setContentType(ContentType.JSON)
				.build();
		RestAssured.requestSpecification = requestSpecification;
	}
	@Test
	public void readUserData() {
		Response response = RestAssured.get("/users");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(enabled=false)
	public void CreateUser() {
		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("name", "Anil");
		requestParams.put("age", 35);
		Response response = RestAssured.given()
				.body(requestParams.toString())
				.post("/users");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	@Test
	public void updateUser() {
		Map<String, Object> requestParams = new HashMap<>();
		requestParams.put("name", "Anil Kumar");
		requestParams.put("age", 36);
		Response response = RestAssured.given()
				.body(requestParams.toString())
				.put("/users/CrSUtudajhI");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test
	public void deleteUser() {
		Response response = RestAssured.delete("/users/CrSUtudajhI");
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}