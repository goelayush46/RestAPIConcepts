package session17;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JSONObjectUsingJacksonAPI {

		@Test
		public void createJSONObjectUsingJackson() {
			// Create an ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();

			// Create a objectNode to represent the JSON object
			ObjectNode jsonObject = objectMapper.createObjectNode();
			// Add key-value pairs to the JSON object
			jsonObject.put("name", "John Doe");
			jsonObject.put("age", 30);
			jsonObject.put("email", "goel.ayush55@gmail.com");
			jsonObject.put("isStudent", false);
			jsonObject.put("techskills", "Java, Selenium, RestAssured");
			jsonObject.put("Hobbies", objectMapper.convertValue(Arrays.asList("Reading", "Traveling", "Cooking"), JsonNode.class));
			ObjectNode nestedObject = objectMapper.createObjectNode();
			nestedObject.put("street", "123 Main St");
			nestedObject.put("city", "New York");
			nestedObject.put("state", "USA");
			jsonObject.set("address", nestedObject);
			
			//print the JSON object
			System.out.println(jsonObject.toPrettyString());
			
			//retrieve values from the JSON object
			String name = jsonObject.get("name").asText();
			int age = jsonObject.get("age").asInt();
			String email = jsonObject.get("email").asText();
			boolean isStudent = jsonObject.get("isStudent").asBoolean();
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Email: " + email);
			System.out.println("Is Student: " + isStudent);
			
			//retrieve nested values
			JsonNode addressNode = jsonObject.get("address");
			String street = addressNode.get("street").asText();
			String city = addressNode.get("city").asText();
			String state = addressNode.get("state").asText();
			System.out.println("Street: " + street);
			System.out.println("City: " + city);
			System.out.println("State: " + state);
			
			//Iterate over the JSON object
			System.out.println("----------iTERATE OVER JSON OBJECT----------");
			jsonObject.fieldNames().forEachRemaining(fieldName -> {
				JsonNode value = jsonObject.get(fieldName);
				System.out.println(fieldName + ": " + value);
				});
			//iterate all field values
			System.out.println("----------iTERATE OVER JSON OBJECT VALUES----------");
			jsonObject.elements().forEachRemaining(value -> {
				System.out.println("Value: " + value);
				});
			//iterate all field names
			System.out.println("----------iTERATE OVER JSON OBJECT FIELD NAMES----------");
			jsonObject.fieldNames().forEachRemaining(fieldName -> {
			System.out.println("Field Name: " + fieldName);
				});
			//remove a field from the JSON object
			jsonObject.remove("age");
			System.out.println("----------JSON OBJECT AFTER REMOVING Age FIELD----------");
			System.out.println(jsonObject.toPrettyString());
			
			//update a field value in the JSON object
			jsonObject.put("name", "Ronnie Doe");
			nestedObject.put("city", "New Jersey");
			System.out.println("----------JSON OBJECT AFTER UPDATING Name and City FIELDS----------");
			System.out.println(jsonObject.toPrettyString());
			
			//Perform Post Request and get response as JSON object
			Response response = RestAssured.given()
					.baseUri("https://jsonplaceholder.typicode.com")
					.basePath("/posts")
					.header("Content-Type", "application/json")
					.body(jsonObject)
					.post();
			
			//print the response
			System.out.println("----------Response from POST Request----------");
			System.out.println(response.asPrettyString());
			
			//Validate the response
			Assert.assertEquals(response.getStatusCode(), 201);
			}



}
