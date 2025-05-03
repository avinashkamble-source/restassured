package restassured.standalone;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import restassured.constants.AuthConstants;
import restassured.constants.Constants;

public class DeleteIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = Constants.base_uri;
		Response rs = given().log().all().headers("Authorization", AuthConstants.key)
				.pathParams("num", "3", "issueid", "RA-2")
				.when().delete("rest/api/{num}/issue/{issueid}");

		System.out.println(rs.getStatusCode());

	}

}
