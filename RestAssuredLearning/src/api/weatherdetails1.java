package api;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class weatherdetails1 {
	
	@Test
	public void getWeatherDetails(){
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET, "/Delhi");
		System.out.println("Response is "+response.getBody().asString());
		System.out.println("*********");
		JsonPath jpath=response.jsonPath();
		System.out.println("city is "+jpath.get("City"));
		/*Headers allheaders=response.headers();
		for(Header header : allheaders){
			System.out.println("Key is"+header.getName()+ " Value is "+header.getValue());
		}*/
	}
}
