package testcases;

import java.util.Base64;

import org.bson.assertions.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ReadConfig;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredOAuth2 {
	
	public static Response response;

	  
	
public static ReadConfig read = new ReadConfig();
	
	
	public static String BaseURI=read.get_spotify_AccessToken();
	public static String clientId=read.get_spotify_ClientId();
	public static String client_secret=read.get_spotify_ClientSecret();
	public static String scope=read.get_spotify_scope();
	public static String redirectUri=read.get_spotify_call_back_url();
	public static String username=read.get_spotify_username();
	public static String password=read.get_spotify_password();
	   

	    public static String accesstoken;
	    

	    public static String encode(String str1, String str2) {
	        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
	    }

	    public static Response getToken(String authCode) {
	        String authorization = encode(username, password);
	        RestAssured.baseURI = "https://api.spotify.com/";
	        return
	        		
	        		response = RestAssured.given()
	                .header("authorization", "Basic " + authorization)
	                .contentType(ContentType.URLENC)
	                .queryParam("code", authCode)
	                .queryParam("redirect_uri", redirectUri)
	               // .queryParam("grant_type", grantType)
	                .post("/oauth2/token")
	                .then()
	             //   .statusCode(200)
	                .extract()
	                .response();
	        }

	        public static String parseForAccessToken(Response loginResponse) {
	            return loginResponse.jsonPath().getString("access_token");
	        }

		        
	        @Test
                   public void test2() {
	        	   RestAssured.baseURI = BaseURI;
	        	
	     RequestSpecification repspec = RestAssured.given();
	     
	     repspec.auth().preemptive().basic(clientId, client_secret)	;
	     repspec.param("grant_type","client_credentials");
	  Response res = repspec.post();
	  
	        
	        System.out.println(res.getBody().asPrettyString());
	        
	        accesstoken = res.jsonPath().getString("access_token");
	        
	  	   RestAssured.baseURI = "https://api.spotify.com/"; 
	    	   repspec = RestAssured.given();
	   	   repspec.header("Authorization","Bearer" +accesstoken);
	       repspec.header("Content-Type","application/json");
	   	    res = repspec.get();
	    		  
		        
		        System.out.println(res.prettyPrint());
	        }
	        
}
