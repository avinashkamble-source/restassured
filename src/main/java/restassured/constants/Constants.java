package restassured.constants;

public interface Constants {

	String base_uri = "https://avinashkamble-team.atlassian.net";
	String get_issue_path = "rest/api/3/issue/{issue}";
	String create_issue_path ="/rest/api/3/issue";
	String get_events = "rest/api/3/events";
	String update_issue = "rest/api/{num}/issue/{issueid}";
	String delete_issue = "rest/api/{num}/issue/{issueid}";
	
	Integer id = 10004;
	String updateissuebody ="{\r\n"
			+ "    \"update\": {\r\n"
			+ "        \"comment\": [\r\n"
			+ "            {\r\n"
			+ "                \"add\": {\r\n"
			+ "                    \"body\": {\r\n"
			+ "                        \"type\": \"doc\",\r\n"
			+ "                        \"version\": 1,\r\n"
			+ "                        \"content\": [\r\n"
			+ "                            {\r\n"
			+ "                                \"type\": \"paragraph\",\r\n"
			+ "                                \"content\": [\r\n"
			+ "                                    {\r\n"
			+ "                                        \"type\": \"text\",\r\n"
			+ "                                        \"text\": \"This is a second new comment added via the REST API using ADF.\"\r\n"
			+ "                                    }\r\n"
			+ "                                ]\r\n"
			+ "                            }\r\n"
			+ "                        ]\r\n"
			+ "                    }\r\n"
			+ "                }\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    }\r\n"
			+ "}";
	
}
