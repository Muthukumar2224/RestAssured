package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.Pojo_post_Request;

public class SerializationDeserialization {
@Test
	void ConvertPojo2Json() throws JsonProcessingException
	{
	Student data = new Student();
	
	data.setId("4");
	data.setName("Scott");
	data.setLocation("France");
	data.setPhone("123456");
	String coursesarr[]= {"C","C++"};
	data.setCourses(coursesarr);
	//convert java obj to json object
	ObjectMapper objmapper = new ObjectMapper();
	String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	System.out.println(jsondata);
	}


///DeSerialization

  @Test
   void Convertjson2Pojo() throws JsonMappingException, JsonProcessingException 
   {
	   String jsondata = "{\r\n"
	   		+ "  \"id\" : \"4\",\r\n"
	   		+ "  \"name\" : \"Scott\",\r\n"
	   		+ "  \"location\" : \"France\",\r\n"
	   		+ "  \"phone\" : \"123456\",\r\n"
	   		+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
	   		+ "}";
	   
	   //convert jsonobj to java obj(Pojo obj)
	   ObjectMapper objmapper = new ObjectMapper();
	   
	   Student obj = objmapper.readValue(jsondata,Student.class);
	   
	  System.out.println("Name  "+obj.getName()); 
	  System.out.println("Location  "+obj.getLocation()); 
	  System.out.println("Phone  "+obj.getPhone());
	  System.out.println("Course1  "+obj.getCourses()[0]);
	  System.out.println("Course2  "+obj.getCourses()[1]);
	   
	  
	   
	   		
	   
   }
	
}
