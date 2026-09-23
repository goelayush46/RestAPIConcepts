package session21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONArrayPOJOClassDemo {

	@Test
	public void serilizationTest() throws IOException{
		// Create Employee Data
		Employee emp1 = new Employee();
		emp1.setFirstName("Rajesh");
		emp1.setLastName("Kumar");
		emp1.setAge(30);
		emp1.setGender("Male");
		emp1.setSalary(50000.92);

		Employee emp2 = new Employee();
		emp2.setFirstName("Suresh");
		emp2.setLastName("Kumar");
		emp2.setAge(28);
		emp2.setGender("Female");
		emp2.setSalary(40000.92);

		// Create Employee Array
		List<Employee> empArray = new ArrayList<Employee>();
		empArray.add(emp1);
		empArray.add(emp2);

		// Create EmployeeList class to JSON Array payload as String(Serilization)
		
		//Manually printing JSON Array Payload
		ObjectMapper mapper = new ObjectMapper();
		String empArrayJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empArray);
		System.out.println("Employee Array JSON Payload :");
		System.out.println(empArrayJson);

		//Create Post Request
		Response response =
				RestAssured.given()
				.baseUri("https://httpbin.org")
				.contentType(ContentType.JSON)
				.body(empArray)
				.when()
				.post("/post");

		Assert.assertEquals(response.statusCode(), 200);

		response.prettyPrint();
		
		//Convert Response JSON Array to Employee Array(Deserilization)
		
		List<Employee> empList = response.jsonPath().getList("json", Employee.class);
		System.out.println("----Employee List from Response-----");
		for(Employee emp : empList) {
			System.out.println(emp.getFirstName() + " " + emp.getLastName() + " " + emp.getAge() + " " + emp.getGender() + " " + emp.getSalary());
		
		}
	}
}
