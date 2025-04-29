package cucumberframework.standalone;

import static io.restassured.RestAssured.*;

import cucumberframework.constants.BodyConstants;
import cucumberframework.constants.UriConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = UriConstants.base_uri;
		Response rs = given().log().all().headers("Authorization", BodyConstants.key)
				.pathParams("num", "3", "issueid", "RA-2")
				.when().delete("rest/api/{num}/issue/{issueid}");

		System.out.println(rs.getStatusCode());

	}

}
