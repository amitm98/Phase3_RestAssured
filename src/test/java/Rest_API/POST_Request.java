package Rest_API;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_Request {
	
	@Test
	public void PostCall(){
		
		Logger logger = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("********* started the Post call***********");
		
		
		RestAssured.given()
			.baseUri("https://reqres.in")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body("[\n" + 
					"    {\n" + 
					"    	\"id\": 7,\n" + 
					"        \"email\": \"abc@xyz.com\",\n" + 
					"        \"first_name\": \"Vishal\",\n" + 
					"        \"last_name\": \"Patil\",\n" + 
					"        \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\n" + 
					"    }\n" + 
					"]")
			.when()
			.post("/api/users")
			.then()
			.statusCode(201)
			.log()
			.all();		
	}
}