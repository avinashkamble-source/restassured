package restassured.jira.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	
	Properties prop = new Properties();
	public BaseTest() {
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/global.properties"));
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
