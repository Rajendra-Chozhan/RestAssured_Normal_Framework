package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro; 
	
	
	public  ReadConfig() {
		
		
		File src = new File("./Configuration/Config.properties");
		
	
	try {
		
		FileInputStream fis = new 	FileInputStream(src);
		
		pro = new Properties();
		pro.load(fis);
		
	}catch (Exception e) {
		
		System.out.println("Exception is " + e.getMessage());
	}

	}

	// we have loaded the file 
	// now we need to read and return the value 
	// so need to create a method for every variable in the Config.properties file 
	
	public String get_spotify_ApplicationURL() {
		
		String base_url=pro.getProperty("spotify_base_URI");
		return base_url;
	}
	
	
public String get_spotify_AccessToken() {
		
		String spotify_acc_token=pro.getProperty("spotify_access_token_url");
		return spotify_acc_token;
	}
	
public String get_spotify_ClientId() {
	
	String spotify_client_id=pro.getProperty("spotify_client_id");
	return spotify_client_id;
}

public String get_spotify_ClientSecret() {
	
	String spotify_client_secret=pro.getProperty("spotify_client_secret");
	return spotify_client_secret;
}
	
public String get_spotify_call_back_url() {
	
	String spotify_call_back_url=pro.getProperty("spotify_call_back_url");
	return spotify_call_back_url;
}
public String get_spotify_user_id() {
	
	String spotify_user_id=pro.getProperty("spotify_user_id");
	return spotify_user_id;
}

public String get_spotify_refresh_token() {
	
	String spotify_refresh_token=pro.getProperty("spotify_refresh_token");
	return spotify_refresh_token;

}

public String get_spotify_access_token() {
	
	String spotify_access_token=pro.getProperty("spotify_access_token");
	return spotify_access_token;

}

public String get_spotify_scope() {
	
	String spotify_scope=pro.getProperty("spotify_scope");
	return spotify_scope;

}
public String get_spotify_username() {
	
	String spotify_username=pro.getProperty("spotify_username");
	return spotify_username;

}
public String get_spotify_password() {
	
	String spotify_password=pro.getProperty("spotify_password");
	return spotify_password;

}


public  String get_fakestore_URI() {
	String fake_store_URI=pro.getProperty("fake_store_URI");
	return fake_store_URI;


}
}

