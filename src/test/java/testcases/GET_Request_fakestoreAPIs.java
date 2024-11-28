package testcases;

import org.json.simple.JSONArray;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utilities.ReadConfig;

import static io.restassured.RestAssured.*;

import java.net.URI;
import java.util.List;


public class GET_Request_fakestoreAPIs {
	
	   // url and uri objects 

    URI uri = null; 
	public Response response;

	static ReadConfig read = new ReadConfig();
		
	public static String Fake_storeBaseURI= read.get_fakestore_URI();
	
	//uri = Fake_storeBaseURI.toURI(); 
	
	// way 1 to execute GET request
	  @Test(enabled =false)
			  
      public void test1() {
	   RestAssured.baseURI = "https://fakestoreapi.com/products";
	
RequestSpecification repspec = RestAssured.given();

Response res = repspec.request(Method.GET);
System.out.println(res.getBody().asPrettyString());

}
	  
	  
		
		// way 2 to execute GET request

	  @Test(enabled =false)
      public void test2() {
		  
		   RestAssured.baseURI = "https://fakestoreapi.com/products";
	
RequestSpecification repspec = RestAssured.given();

Response res = repspec.get();
System.out.println(res.getBody().asPrettyString());

}

	 
		
		// way 3 to execute GET request

	  @Test(enabled =false)
      public void test3() {
		  
		  RestAssured.baseURI = Fake_storeBaseURI;
			
			response = (Response) RestAssured.given()
	
		  .when()
		  .get(Fake_storeBaseURI)
		  .then()
		  .log().all();
	        		

}

	  @Test(enabled =true)
	// Get Book list
		public void GetBooksDetails() throws JsonMappingException, JsonProcessingException { 

			RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
 
			RequestSpecification httpRequest = RestAssured.given(); 
	
			Response response = httpRequest.request(Method.GET, "");
		System.out.println("Status received => " + response.getStatusLine()); 
			System.out.println("Response=>" + response.prettyPrint());
			
			 JSONArray json = new JSONArray();
	            String jsonString = json.toString();

	  }
		
	  

}
