package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mongodb.assertions.Assertions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUT_Request_RestAssured {


	 
	 @Test
	    public void getRequest() {
		   String baseURI = "https://jsonplaceholder.typicode.com";
	        Response response = RestAssured.given()
	        		.baseUri(baseURI)
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/users")
	                .then()
	                .log().body()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	      
	    }

	 
	 @Test
	    public void getRequest1() {
		   String baseURI = "https://jsonplaceholder.typicode.com";
	        Response response = RestAssured.given()
	        		.baseUri(baseURI)
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/users/1")
	                .then()
	                .log().body()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	        Assert.assertEquals("Leanne Graham", response.jsonPath().getString("name"));
	        Assert.assertEquals("Bret", response.jsonPath().getString("username"));
	        Assert.assertEquals("Sincere@april.biz", response.jsonPath().getString("email"));
	    }

  

	  @Test
	    public void putRequest() {
		   RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
			 
	        String requestBody = "{\r\n" +          
	           " \"name\":\"Rajendra Chozhan\"\r\n"+    
	            "}";
	 
	 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .put("/users/1")
	                .then()
	                .log().body()
	                .extract().response();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	  }
	
}
