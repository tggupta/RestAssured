package api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class weatherDetails {

	@Test
	public void getWeatherDetails()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest=RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Delhi");
		String Responsebody=response.getBody().asString();
		System.out.println("Response Body is "+Responsebody);
	}
	

	
}
