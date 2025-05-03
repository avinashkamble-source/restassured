package restassured.jira.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.constants.Constants;
import restassured.specbuilders.Requestspec;
import restassured.specbuilders.Responsespec;

public class GetIssueTests extends BaseTest{

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = prop.getProperty("base_uri");
	}
	/*
	 * Using just hamcrest matchers for validation both body and header in response
	 * spec we can even add validations for body
	 */

	@Test
	public void posT1() {

		try {
			given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.pathParam("issue", "RA-1")
					.get(Constants.get_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.assertThat()
					.body("key", equalTo("RA-1"))
					.body("fields.issuetype.description", equalTo("Bugs track problems or errors."))
					.body("id", notNullValue(), "expand", containsString("operations"))
					// .header("Content-Type", containsString("application/json"))
					// .header("server", "AtlassianEdge")
					.header("set-cookie", notNullValue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Here schema validation is done Also headers can be validated by providing a
	 * map
	 */
	@Test
	public void posT2() {

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json;charset=UTF-8");
		expectedHeaders.put("server", "AtlassianEdge");

		try {
			given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.pathParam("issue", "RA-1")
					.get(Constants.get_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.assertThat()
					.body("key", equalTo("RA-1"))
					.body("fields.issuetype.description", equalTo("Bugs track problems or errors."))
					.body("id", notNullValue(), "expand", containsString("operations"))
					.body(matchesJsonSchemaInClasspath("getissue.json"))
					.headers(expectedHeaders);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Here extraction is shown where a single string can be extracted
	 */
	@Test
	public void posT3() {

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json;charset=UTF-8");
		expectedHeaders.put("server", "AtlassianEdge");

		try {
			String expand = given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.pathParam("issue", "RA-1")
					.get(Constants.get_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.assertThat()
					.body("key", equalTo("RA-1"))
					.body("fields.issuetype.description", equalTo("Bugs track problems or errors."))
					.body("id", notNullValue(), "expand", containsString("operations"))
					.body(matchesJsonSchemaInClasspath("getissue.json"))
					.headers(expectedHeaders)
					.extract()
					.response().jsonPath().getString("expand");
			// .jsonPath().getString("expand");

			System.out.println("expand-->" + expand);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Here entire response is extracted as json path We can also validate using
	 * testng assertions, use this only if complex pre logic is required after
	 * extraction
	 * 
	 * Otherwise hamcrest matchers are preferred
	 */
	@Test
	public void posT4() {

		Map<String, String> expectedHeaders = new HashMap<String, String>();
		expectedHeaders.put("Content-Type", "application/json;charset=UTF-8");
		expectedHeaders.put("server", "AtlassianEdge");

		try {
			JsonPath response = given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.pathParam("issue", "RA-1")
					.get(Constants.get_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.assertThat()
					.body("key", equalTo("RA-1"))
					.body("fields.issuetype.description", equalTo("Bugs track problems or errors."))
					.body("id", notNullValue(), "expand", containsString("operations"))
					.body(matchesJsonSchemaInClasspath("getissue.json"))
					.headers(expectedHeaders)
					.extract()
					.response().jsonPath();

			Integer id = response.getInt("id");
			String desc = response.getString("fields.issuetype.description");

			Assert.assertEquals(desc, "Bugs track problems or errors.");
			Assert.assertEquals(id, 10004);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
