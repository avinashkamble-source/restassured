package restassured.jira.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import java.io.FileNotFoundException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import restassured.constants.Constants;
import restassured.response.event.pojos.Event;
import restassured.specbuilders.Requestspec;
import restassured.specbuilders.Responsespec;

public class JiraEventsTests extends BaseTest {

	/*
	 * Rest Assured flattens arrays and pulls all id or name values from each object.
	 * When we have root array element 
	 * use TypeRef
	 */
	@Test
	public void posT1() {
		try {
			List<Event> events = given().log().all()
					.spec(Requestspec.getRequestSpecification())
					.when()
					.get(Constants.get_events)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.statusCode(200)
					.body("", hasSize(17))
					.body("id", hasItems(14, 17))
					.body("name", hasItems("Issue Commented", "Issue Closed"))
					.body("[0].id", equalTo(1))
					.body("[0].name", equalTo("Issue Created"))
					.extract()
					.as(new TypeRef<List<Event>>() {
					});
			
			Assert.assertEquals(events.size(), 17);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = prop.getProperty("base_uri");
	}
}
