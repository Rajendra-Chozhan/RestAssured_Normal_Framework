package testcases;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;



public class Pojo_Example {
	
	@Test
	public void createEmployeesJSONArray() throws JsonProcessingException
	{
		//create first employeeObject
		Employees emp1 = new Employees();

		emp1.setFirstName("Suresh");
		emp1.setLastname("Raina");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.56);


		//create second employeeObject
		Employees emp2 = new Employees();

		emp2.setFirstName("Ramkosal");
		emp2.setLastname("Kumar");
		emp2.setGender("Male");
		emp2.setAge(30);
		emp2.setSalary(34000.56);

		//create third employeeObject
		Employees emp3 = new Employees();

		emp3.setFirstName("Regina");
		emp3.setLastname("Chozhan");
		emp3.setGender("Female");
		emp3.setAge(30);
		emp3.setSalary(39000.56);
		
		//Create List Of Employee
		
		List<Employees> listOfEmp = new ArrayList<Employees>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		//Convert employee class objects to json array payload as String
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonArrayPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		
		System.out.println("employee class objects to json array payload");
		System.out.println(jsonArrayPayload);
		
		
		//create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		//specify URL
		reqSpec.baseUri("http://httpbin.org/post");
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonArrayPayload);
		
		//perform POST request
		Response response = reqSpec.post();
		System.out.println("----------ResponseBody----------------");
		
		response.prettyPrint();
		
		
		//verify the status code		
		Assert.assertEquals(response.statusCode(), 200,"check for status code.");
		
		
		
		//convert JsonArray to Employee class objects (Deserialization)
		
		ResponseBody responseBody = response.getBody();
		
		JsonPath jsonPathView = responseBody.jsonPath(); 
		
		List<Employees> allEmployees = jsonPathView.getList("json", Employees.class);

	
		System.out.println("----------Emoployee objects in ResponseBody----------------");

		for(Employees emp:allEmployees)
		{
			System.out.println(emp.getFirstName()+ " " + emp.getLastname());
		}
		
		
	
	}

}
