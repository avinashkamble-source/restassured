package cucumberframework.standalone;

import static io.restassured.RestAssured.given;

import cucumberframework.request.createissue.pojos.CreateIssueRequest;
import cucumberframework.request.createissue.pojos.Fields;
import cucumberframework.request.createissue.pojos.IssueType;
import cucumberframework.request.createissue.pojos.Project;
import cucumberframework.response.createissue.pojos.CreateIssueResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreateIssue createIssue = new CreateIssue();
		
		CreateIssueRequest requestbody = createIssue.createrequestObj();;
		createIssue.createIssue(requestbody);
	}


	private void createIssue(CreateIssueRequest requestbody) {
		
		RestAssured.baseURI ="https://avinashkamble-team.atlassian.net";
		
		Response response = given().log().all()
		.pathParam("number", "3")
		.headers("Content-Type","application/json")
		//.auth().basic("pkavinas@gmail.com", "ATATT3xFfGF0YJL76xXN6f9nV7w5LZxnhCtkapdHayYVGu_fcr3wXVuOonkOdS7h6dqLDOnY_-3GR0VY7OsMM19Cy-J7oYSUPariVkaiOQ-e0fS7_dK1W9uw-zCmoYzWpVwnXH7NZNyVw34984pNcfboKE7WCNm8mcKgZJn0-CWW6AN4PBv6PJ0=A99B85EA")
		.header("Authorization", "Basic cGthdmluYXNAZ21haWwuY29tOkFUQVRUM3hGZkdGMFlKTDc2eFhONmY5blY3dzVMWnhuaEN0a2FwZEhheVlWR3VfZmNyM3dYVnVPb25rT2RTN2g2ZHFMRE9uWV8tM0dSMFZZN09zTU0xOUN5LUo3b1lTVVBhcmlWa2FpT1EtZTBmUzdfZEsxVzl1dy16Q21vWXpXcFZ3blhIN05aTnlWdzM0OTg0cE5jZmJvS0U3V0NObThtY0tnWkpuMC1DV1c2QU40UEJ2NlBKMD1BOTlCODVFQQ==")
		.when().body(requestbody).post("/rest/api/{number}/issue");
		
		
		System.out.println(response.getBody().asString());
		CreateIssueResponse issueresponse = response.getBody().as(CreateIssueResponse.class);
		
		System.out.println(issueresponse.getId());
		System.out.println(issueresponse.getKey());
		System.out.println(issueresponse.getSelf());
		
		System.out.println(response.getStatusCode());
		
	}
	
	private CreateIssueRequest createrequestObj() {
		CreateIssueRequest createIssueRequest = new CreateIssueRequest();
		Fields fields = new Fields();
		
		IssueType issueType = new IssueType();
		issueType.setName("Task");
		fields.setIssuetype(issueType);
		Project project = new Project();
		project.setKey("RA");
		fields.setProject(project);
		fields.setSummary("Simple issue created with curl now");
		
		createIssueRequest.setFields(fields);
		return createIssueRequest;
	}

}
