package session20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SeriliizationAndDeserialization {
	
	@Test
	public void serilizationTest() throws JsonProcessingException {
		Employee emp = new Employee();
		emp.setFirstName("Rajesh");
		emp.setLastName("Kumar");
		emp.setAge(30);
		emp.setGender("Male");
		emp.setSalary(50000.92);
		
		//Convert the Java object to JSON format as String - Serilalization Manually
		/*ObjectMapper mapper = new ObjectMapper();
		String empJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(empJson);*/
		
		//Create Request body for POST API - With RestAssured
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://httpbin.org");
		request.header("Content-Type", "application/json");
		request.body(emp);
		
		//Perform Post Request
		Response response = request.post("/post");
		response.prettyPrint();
		//Validate the response
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Convert the JSON response to Java Object - Deserialization Manually
		/*Employee responseData = mapper.readValue(empJson, Employee.class);
		System.out.println(responseData.getFirstName());
		System.out.println(responseData.getLastName());
		System.out.println(responseData.getAge());
		System.out.println(responseData.getGender());
		System.out.println(responseData.getSalary());*/
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.asString());

		Employee responseData =mapper.treeToValue(root.get("json"), Employee.class);
		System.out.println("firstName :"+responseData.getFirstName());
		System.out.println("lastName :"+responseData.getLastName());
		System.out.println("Age :"+responseData.getAge());
		System.out.println("Gender :"+responseData.getGender());
		System.out.println("Salary :"+responseData.getSalary());
		Assert.assertEquals(responseData.getFirstName(),"Rajesh");
	}
}
