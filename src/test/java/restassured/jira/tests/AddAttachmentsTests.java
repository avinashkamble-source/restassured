package restassured.jira.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import restassured.specbuilders.Requestspec;
import restassured.specbuilders.Responsespec;

public class AddAttachmentsTests extends BaseTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = prop.getProperty("base_uri");
	}
	
	@Test
	public void add() {
		File f = new File("C:\\Users\\Asus\\eclipse-workspace\\cucumberframework\\src\\main\\resources\\2.png");
		try {
			given().log().all()
			.spec(Requestspec.getRequestSpecification())
			.pathParams("number", "3", "issue-id", "RA-2")
			.when()
			.multiPart("file", f)
			.post()
			.then()
			.statusCode(200)
			.spec(Responsespec.getResponseSpecification())
			.extract()
			.response();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
