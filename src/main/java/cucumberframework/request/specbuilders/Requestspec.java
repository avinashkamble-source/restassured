package cucumberframework.request.specbuilders;
//import io.restassured.builder.RequestSpecBuilder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import cucumberframework.constants.BodyConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Requestspec {
	
	static RequestSpecification requestSpecification;
	/**
	 * @return the requestSpecBuilder
	 * @throws FileNotFoundException 
	 */
	public static RequestSpecification getRequestSpecification() throws FileNotFoundException {
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		requestSpecification = new	RequestSpecBuilder().setBaseUri("https://avinashkamble-team.atlassian.net").addPathParams("issue", "RA-1")
				.addHeader("Accept", "application/json").addHeader("Authorization", BodyConstants.key)
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		// System.out.println(requestSpecBuilder);
		return requestSpecification;
	}

}
