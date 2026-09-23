package RestAssuredAPITesting.RestAssuredAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CheckForResponseStatusCodeAndLine {
		@Test
		public void getSingleUser() {
			RestAssured.given()
			.when()
				.get("https://dummyjson.com/users/1")
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
		}
}
