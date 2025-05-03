package restassured.standalone;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import restassured.constants.AuthConstants;
import restassured.constants.Constants;

import static io.restassured.RestAssured.*;

public class UpdateIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://avinashkamble-team.atlassian.net";
		Response rs = given().log().all()
				.headers("Content-Type","application/json","Authorization",AuthConstants.key)
				.pathParams("num","3", "issueid", "RA-1")
				.body(Constants.updateissuebody)
				.when().put("rest/api/{num}/issue/{issueid}");
		
		rs.getBody().asString();
		System.out.println(rs.getStatusCode());
	}

}
