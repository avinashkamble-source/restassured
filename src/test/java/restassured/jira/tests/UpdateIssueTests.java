package restassured.jira.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import restassured.constants.Constants;
import restassured.specbuilders.Requestspec;
import restassured.specbuilders.Responsespec;

public class UpdateIssueTests extends BaseTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = prop.getProperty("base_uri");
	}
	
	
	@Test
	public void updateissue() {
		
		try {
			given().log().all()
			.spec(Requestspec.getRequestSpecification())
			.pathParams("num","3", "issueid", "RA-1")
			.when()
			.put(Constants.update_issue)
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
