package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DELETE_RestAssured {

	
	 @Test
	    public void getRequest1() {
		   String baseURI = "https://jsonplaceholder.typicode.com";
	        Response response = RestAssured.given()
	        		.baseUri(baseURI)
	                .contentType(ContentType.JSON)
	                .when()
	                .delete("/users/1")
	                .then()
	                .log().body()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	        
	        
	     
	        
	        
	 }


}
