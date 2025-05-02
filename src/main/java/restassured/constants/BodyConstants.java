package restassured.constants;

public interface BodyConstants {

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
	
	String key ="Basic cGthdmluYXNAZ21haWwuY29tOkFUQVRUM3hGZkdGMGo4WEhJeTY2QW8tbjVOV3lJc05qakRRTHVsVnJmblpZSUEyMTdOR3pwVkotSnpEWWVHRGFQckFDNHJnUV8tbGhGTUZKYmhueWc5M1o5RVFkUm5EUDNUOFBkU0w4WTRLV1I3bnU1NzV1OWQtQS1idFIzVlZGbTk5UjRSY3J0NUhMV3BnRnZkZE1BVC1FUUhjdnNaa1V6Z0FkTEtsZzZWbUluZk1zZTVPdFAxST0zRjJCNjk4Ng==";
}
