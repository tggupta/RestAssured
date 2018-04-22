package api;

//import java.awt.print.Book;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class booksDetails {

	@Test
	public void getBooksDetails(){
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("");
		JsonPath jpath=response.jsonPath();
		
		List<Book> allbooks=jpath.getList("books", Book.class);
		for(Book book: allbooks){
			System.out.println("Pages are "+book.title);
		}
		
	}
	
}
