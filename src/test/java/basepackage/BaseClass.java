package basepackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;







public class BaseClass {
	
	public static Properties prop;
	public String clientid = prop.getProperty("client_id");
	public String clientsecret = prop.getProperty("client_secret");

public void loadConfigFile() throws IOException {
		
		FileInputStream fis = new FileInputStream("E:\\RestAssured_Cucumber_BDD\\Configuration\\Config.properties");
		prop = new Properties();
		prop.load(fis);
		
	}
	



	}