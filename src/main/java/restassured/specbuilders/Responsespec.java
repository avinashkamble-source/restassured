package restassured.specbuilders;
//import io.restassured.builder.RequestSpecBuilder;

import static org.hamcrest.Matchers.containsString;

import java.io.FileNotFoundException;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Responsespec {
	
	static ResponseSpecification responseSpecification;
	
	public static ResponseSpecification getResponseSpecification() throws FileNotFoundException {
		
		responseSpecification = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectHeader("server", containsString("AtlassianEdge"))
                .expectHeader("Set-Cookie", containsString("atlassian.xsrf.token"))
                .expectHeader("Strict-Transport-Security", containsString("max-age="))
                .expectHeader("Strict-Transport-Security", containsString("includeSubDomains"))
                .expectHeader("Strict-Transport-Security", containsString("preload"))
                .build();
		return responseSpecification;
	}

}
