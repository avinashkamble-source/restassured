package restassured.jira.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restassured.constants.Constants;
import restassured.request.createissue.pojos.CreateIssueRequest;
import restassured.request.createissue.pojos.Fields;
import restassured.request.createissue.pojos.IssueType;
import restassured.request.createissue.pojos.Project;
import restassured.specbuilders.Requestspec;
import restassured.specbuilders.Responsespec;
import restassured.utils.Dataprovider;

/*
 * Passing parameters
 * Using dataprovider with object[][] of testng
 * Using dataprovider with iterator for testng
 * Using dataprovider with excel for testng
 * calls chained, issue is created and then
 * using the issue key a get issue call is made
 */
public class CreateIssueTests extends BaseTest {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = prop.getProperty("base_uri");
	}
	
	@Test(dataProvider = "dataIterator" , dataProviderClass = Dataprovider.class)
	public void povt1(String summary) {
		try {
			String key = given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.when()
					.body(createrequestObj(summary))
					.post(Constants.create_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.statusCode(201)
					.extract()
					.jsonPath().get("key");
			
			
			JsonPath jsonpath = given().log().all()
			.spec(Requestspec.getRequestSpecification())
			.pathParam("issue", key)
			.when()
			.get(Constants.get_issue_path)
			.then()
			.spec(Responsespec.getResponseSpecification())
			.statusCode(200)
			.body("id" , notNullValue())
			.body("key", notNullValue())
			.extract()
			.response().jsonPath();
			
			//.path("fields.summary");
		
		System.out.println(key+ " = " +jsonpath.getString("fields.summary"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "readexcledata" , dataProviderClass = Dataprovider.class)
	public void povt2(String issuetype, String keys, String summary) {
		try {
			String key = given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.when()
					.body(createrequestObj(issuetype,keys,summary))
					.post(Constants.create_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.statusCode(201)
					.extract()
					.jsonPath().get("key");
			
			
			JsonPath jsonpath = given().log().all()
			.spec(Requestspec.getRequestSpecification())
			.pathParam("issue", key)
			.when()
			.get(Constants.get_issue_path)
			.then()
			.spec(Responsespec.getResponseSpecification())
			.statusCode(200)
			.body("id" , notNullValue())
			.body("key", notNullValue())
			.extract()
			.response().jsonPath();
			
			//.path("fields.summary");
		
		System.out.println(key+ " = " +jsonpath.getString("fields.summary"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "summarydata" , dataProviderClass = Dataprovider.class)
	public void povt3(String summary) {
		try {
			String key = given()
					.log().all()
					.spec(Requestspec.getRequestSpecification())
					.when()
					.body(createrequestObj(summary))
					.post(Constants.create_issue_path)
					.then()
					.spec(Responsespec.getResponseSpecification())
					.statusCode(201)
					.extract()
					.jsonPath().get("key");
			
			
			JsonPath jsonpath = given().log().all()
			.spec(Requestspec.getRequestSpecification())
			.pathParam("issue", key)
			.when()
			.get(Constants.get_issue_path)
			.then()
			.spec(Responsespec.getResponseSpecification())
			.statusCode(200)
			.body("id" , notNullValue())
			.body("key", notNullValue())
			.extract()
			.response().jsonPath();
			
			//.path("fields.summary");
		
		System.out.println(key+ " = " +jsonpath.getString("fields.summary"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private CreateIssueRequest createrequestObj(String issuetype, String keys, String summary) {
		
		CreateIssueRequest createIssueRequest = new CreateIssueRequest();
		Fields fields = new Fields();

		IssueType issueType = new IssueType();
		issueType.setName(issuetype);
		fields.setIssuetype(issueType);
		Project project = new Project();
		project.setKey(keys);
		fields.setProject(project);
		fields.setSummary(summary);

		createIssueRequest.setFields(fields);
		return createIssueRequest;
	}
	
	private CreateIssueRequest createrequestObj(String summary) {
		CreateIssueRequest createIssueRequest = new CreateIssueRequest();
		Fields fields = new Fields();

		IssueType issueType = new IssueType();
		issueType.setName("Task");
		fields.setIssuetype(issueType);
		Project project = new Project();
		project.setKey("RA");
		fields.setProject(project);
		fields.setSummary(summary);

		createIssueRequest.setFields(fields);
		return createIssueRequest;
	}
	

}
