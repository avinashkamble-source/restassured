package cucumberframework.standalone;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import cucumberframework.request.specbuilders.Requestspec;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		

		Response response = given().log().all().spec(Requestspec.getRequestSpecification()).get("rest/api/3/issue/{issue}");

		JsonPath responsepath = response.getBody().jsonPath();

		System.out.println(responsepath.getString("expand"));
		System.out.println(responsepath.getInt("id"));
		System.out.println(responsepath.getString("self"));
		System.out.println(responsepath.getString("key"));

		System.out.println("res-->" + responsepath.getString("fields.issuetype.description"));
		
		

	}
}
