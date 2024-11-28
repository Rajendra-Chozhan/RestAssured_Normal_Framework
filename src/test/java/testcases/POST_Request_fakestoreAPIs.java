package testcases;

import java.net.URI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReadConfig;

public class POST_Request_fakestoreAPIs {

	public Response response;
	
	public RequestSpecification repspec;

	static ReadConfig read = new ReadConfig();
		
	public static String Fake_storeBaseURI= read.get_fakestore_URI();
	

	  @Test
      public void test1_addproductusingJSONasString() {
		  
String JsonasString = "\"title\":\"Laptop\",\"price\":\"100\",\"description\":\"Best Laptop in 2024\",\"category\":\"electronic\"";

RestAssured.baseURI = "https://fakestoreapi.com/products";

 repspec = RestAssured.given();

repspec.contentType(ContentType.JSON);
repspec.body(JsonasString);

response = repspec.post();
System.out.println(response.getBody().asPrettyString());

}
	  
	  
	  //way 2
	  @Test
	  
		public void postRequestBooksAPI() 
		{ 
		   RestAssured.baseURI = "https://demoqa.com"; 
		   RequestSpecification request = RestAssured.given();
	
		   JSONObject requestParams = new JSONObject(); 
		   requestParams.put("userId", "Chozhan"); 
		   requestParams.put("isbn", "9781449325862"); 
		 
		   request.header("Content-Type", "application/json"); 
		   request.body(requestParams.toJSONString());
		   Response response = request.post("/BookStore/V1/Books"); 
		   System.out.println("The status received: " + response.statusLine());
		   
		   
		   
		   
		}
		
	  
}
