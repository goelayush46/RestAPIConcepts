package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class FirstGetRequest {

	// https://reqres.in/api/users/2

	@Test
	void testCase01() {
		Response res = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		//System.out.println(res.asString());
		System.out.println("Response code "+ res.getStatusCode());
		System.out.println("Response body "+ res.getBody());
		System.out.println("Response time "+ res.getTime());
		System.out.println("Response header "+ res.getHeader("Content-Type"));
		int expectedStatusCode=200;
		int actualStatusCode=res.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
}
