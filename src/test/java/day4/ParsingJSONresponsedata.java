package day4;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class ParsingJSONresponsedata {

	//@Test
	void testJsonResponse() {
		
		//Approach 1
		
		/*given()
		.contentType(ContentType.JSON)
		.when()
		  .get("http://localhost:3000/store")
		.then()
		 .statusCode(200)
		 .header("Content-Type","application/json; charset=utf-8")
		 .body("book[3].title",equalTo("The Lord of the Rings"));*/
		
		//Approach 2
		
//		Response res = given().contentType(ContentType.JSON)
//		.when()
//		  .get("http://localhost:3000/store");
		 
		/*Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "The Lord of the Rings");*/
	}
	
	@Test
		void testjsonResponse() 
		{
			Response res = given().contentType(ContentType.JSON)
					.when()
					  .get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString());   //converting response to json object type
		//print all titles of book
	/*	for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
		}*/
		
		boolean status = false;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(bookTitle.equals("The Lord of the Rings"))
			{
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true); // if status is false test fails...
		
		double totalprice=0;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice = totalprice+Double.parseDouble(price);
		}
		System.out.println("Total price of the book is:"+totalprice);
		Assert.assertEquals(totalprice, 526.0);
	  }

}
