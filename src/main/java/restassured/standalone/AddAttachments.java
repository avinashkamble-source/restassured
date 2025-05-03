package restassured.standalone;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import restassured.constants.AuthConstants;

public class AddAttachments {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://avinashkamble-team.atlassian.net";

		File f = new File("C:\\Users\\Asus\\eclipse-workspace\\cucumberframework\\src\\main\\resources\\2.png");
		Response response = given().log().all().headers("X-Atlassian-Token", "no-check", "Authorization",
				AuthConstants.key)
				.pathParams("number", "3", "issue-id", "RA-2").multiPart("file", f).when()
				.post("/rest/api/{number}/issue/{issue-id}/attachments");

		System.out.println(response.getStatusCode());

		//System.out.println(response.getBody().asString());

	}

}
