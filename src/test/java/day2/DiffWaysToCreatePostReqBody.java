package day2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class DiffWaysToCreatePostReqBody {
int id;
	//post request body using HashMap:
	//@Test(priority=1)
	void postUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		
		String coursesarr[]= {"C","C++"};
		data.put("courses", coursesarr);
	
		given()
		 .contentType("application/json")
		 .body(data)
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("courses[0]",equalTo("C"))
		  .header("Content-Type","application/json")
		  .log().all();
	}
	//post req using json
	//@Test(priority=1)
	void postUsingJson() {
		JSONObject data = new JSONObject();
		
		
		data.put("id", "4");
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		
		String coursesarr[]= {"C","C++"};
		data.put("courses", coursesarr);
	
		given()
		 .contentType("application/json")
		 .body(data.toString())
		.when()
		  .post("http://localhost:3000/students")
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("courses[0]",equalTo("C"))
		  .header("Content-Type","application/json")
		  .log().all();
	}
	
	//Post request body using POJO class
	//@Test(priority=1)
	void Pojo_post_Request() {
		Pojo_post_Request data = new Pojo_post_Request();
		
		data.setId("4");
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		String coursesarr[]= {"C","C++"};
		data.setCourses(coursesarr);
	
		given()
		 .contentType("application/json")
		 .body(data)
		 
		.when()
		  .post("http://localhost:3000/students")
		  
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("courses[0]",equalTo("C"))
		  .header("Content-Type","application/json")
		  .log().all();
	}
	
	//Post using external json file
	
@Test(priority=1)
	void postUsingExternaljsonFile() throws FileNotFoundException {
		File f = new File(".//body.json");
//		FileReader fr = new FileReader(f);
//		JSONTokener jt  = new JSONTokener(fr);
//		JSONObject data = new JSONObject(jt);
//	
	
		given()
		 .contentType("application/json")
		 .body(f)
		 
		.when()
		  .post("http://localhost:3000/students")
		  
		.then()
		  .statusCode(201)
		  .body("name",equalTo("Scott"))
		  .body("courses[0]",equalTo("C"))
		  .header("Content-Type","application/json")
		  .log().all();
	}

	
	
	@Test(priority=2)
	void testdelete()
	{
		given()
		.when()
		   .delete("http://localhost:3000/students/4")
		.then()
		   .statusCode(200);
	}

}

