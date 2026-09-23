package session18;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FileUploadDemo {
	@Test(enabled=false)
	public void fileUploadTest() {
		given()
			.baseUri("http://httpbin.org")
			.multiPart("file1", new File("src/test/resources/sample.txt"))
			.multiPart("file2", new File("src/test/resources/sample1.txt")) // to upload many files in one go
			.contentType("multipart/form-data") //Important for Interview
		.when()
			.post("/post")
		.then()
        	.statusCode(200)
        	.log().all();
	}
	@Test
	public void uploadImage() {
		given()
			.baseUri("http://httpbin.org")
			.multiPart("file1", new File("src/test/resources/Capture.JPG"))
			.contentType("multipart/form-data") //Important for Interview
		.when()
			.post("/post")
		.then()
    		.statusCode(200)
    		.log().all();
	}
}
