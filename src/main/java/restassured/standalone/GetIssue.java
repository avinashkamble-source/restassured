package restassured.standalone;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import restassured.constants.AuthConstants;

public class GetIssue {

	public static void main(String[] args) throws FileNotFoundException {

		RestAssured.baseURI = "https://avinashkamble-team.atlassian.net";

		// baseuri,pathparam, queryparam, headers, authorization, body,
		// path, GET/POST

		/*
		 * PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 * 
		 * requestSpecification = new
		 * RequestSpecBuilder().setBaseUri("https://avinashkamble-team.atlassian.net")
		 * .addPathParams("issue", "RA-1") .addHeader("Accept", "application/json")
		 * .addHeader("Authorization",BodyConstants.key)
		 * .addFilter(RequestLoggingFilter.logRequestTo(log))
		 * .addFilter(ResponseLoggingFilter.logResponseTo(log))
		 * .setContentType(ContentType.JSON).build();
		 */

		Response response = given().log().all().headers("Authorization", AuthConstants.key, "Accept", "application/json")
				.pathParams("issue", "RA-1").when().get("rest/api/3/issue/{issue}");

		/*
		 * Demo of request spec builders Demo of hamcrest matchers Demo of JSon schema
		 * matching Demo of extraction and Testng asset Demo of jsonpath and testng
		 * assert Demo - Map object can be created and passed to headers for validation
		 * 
		 */
		/*
		 * given().log().all().spec(Requestspec.getRequestSpecification()).get(
		 * "rest/api/3/issue/{issue}").then() .assertThat().body("key", equalTo("RA-1"))
		 * .body("fields.issuetype.description",
		 * equalTo("Bugs track problems or errors.")) .body("id", notNullValue(),
		 * "expand", containsString("operations")) // .body("expand" ,
		 * containsString("operations")) // .body("id", greaterThanOrEqualTo(1000)) //
		 * .body("id", lessThan(2000)) //
		 * .body(matchesJsonSchemaInClasspath("getissue.json")) .header("Content-Type",
		 * containsString("application/json")).header("server", "AtlassianEdge")
		 * .header("set-cookie", notNullValue());
		 */

		// Map expectedHeaders = new HashMap();
		// expectedHeaders.put("headerName1", "headerValue1"));
		// expectedHeaders.put("headerName2", "headerValue2")

		System.out.println(System.getProperty("user.dir"));

		
		  JsonPath responsepath = response.getBody().jsonPath();
		  
		  System.out.println(responsepath.getString("expand"));
		  System.out.println(responsepath.getInt("id"));
		  System.out.println(responsepath.getString("self"));
		  System.out.println(responsepath.getString("key"));
		  
		  System.out.println("res-->" +
		  responsepath.getString("fields.issuetype.description"));
		 

	}
}
