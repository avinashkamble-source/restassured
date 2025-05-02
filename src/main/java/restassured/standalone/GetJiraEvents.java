package restassured.standalone;

import static io.restassured.RestAssured.given;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restassured.response.event.pojos.Event;

public class GetJiraEvents {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://avinashkamble-team.atlassian.net";
		Response response = given().log().all()
		.accept(ContentType.JSON)
		.header("Authorization" ,"Basic cGthdmluYXNAZ21haWwuY29tOkFUQVRUM3hGZkdGMFlKTDc2eFhONmY5blY3dzVMWnhuaEN0a2FwZEhheVlWR3VfZmNyM3dYVnVPb25rT2RTN2g2ZHFMRE9uWV8tM0dSMFZZN09zTU0xOUN5LUo3b1lTVVBhcmlWa2FpT1EtZTBmUzdfZEsxVzl1dy16Q21vWXpXcFZ3blhIN05aTnlWdzM0OTg0cE5jZmJvS0U3V0NObThtY0tnWkpuMC1DV1c2QU40UEJ2NlBKMD1BOTlCODVFQQ==")
		.when()
		.get("rest/api/3/events");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
	//	EventPojo eventPojo = response.getBody().as(EventPojo.class);
		
		List<Event> events = objectMapper.readValue( response.getBody().asString(), new TypeReference<List<Event>>() {});
		
		for(Event e : events) {
			System.out.println(e.getId());
			System.out.println(e.getName());
		}
		
		System.out.println(response.getStatusCode());
	}

}
