package pages;


import java.io.IOException;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Authorization  {
	
public Response response;

public ResponseBody body;

public String accessToken;

@Test
	public void Validate_Authorisation() throws IOException {
		//loadConfigFile();
	
	RestAssured.baseURI = "https://api.spotify.com";
		
	response = RestAssured.given
			
			().contentType("application/json")
			.formParam("grant_type","client_credentials")
			.formParam("client_id", "4dd6d09dc47d4667b947d9b720a28ba0")
			.formParam("client_secret","70d883ffeeeb451c90aef546136808d5")
			.when()
			.get(RestAssured.baseURI );
	

	
	JsonPath jsnpath = response.jsonPath();
	
	
	
	body = response.getBody();
	
		String responseBody = body.asString();
		
		System.out.println(responseBody);
		
	}
}
