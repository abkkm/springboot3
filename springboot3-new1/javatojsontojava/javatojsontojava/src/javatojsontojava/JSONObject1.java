package javatojsontojava;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.simple.JSONObject;

public class JSONObject1 {
	public static void main(String args[]) throws IOException, ParseException {
		System.out.println("Hello");
		ObjectMapper mapper = new ObjectMapper();
		
		// JAVA to JSON
		Employee e1 = new Employee(100, "ak");
		String jsonData = mapper.writeValueAsString(e1);
		System.out.println("jsonData-1-"+jsonData);
		Employee e2 = new Employee(101, "ka");
		
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		jsonData = mapper.writeValueAsString(empList);
		System.out.println("jsonData-2-"+jsonData);
		
		mapper.writeValue(new File("C:\\10-2023\\JSON\\emp.json"), empList);
		
		//JSON to JAVA
		
		String json = "[{\"id\":100,\"name\":\"ak\"},{\"id\":101,\"name\":\"ka\"}]";
		List<Employee> list =   mapper.readValue(json, new TypeReference<List<Employee>>() {});
		
		list.forEach(e->{
			System.out.println("ID - "+e.getId()+" Name - "+e.getName());
		});
		
		//Read JSON from JAVA
		
		JSONParser jsonparser = new JSONParser();
		
		try (FileReader reader = new FileReader(".\\jsonfiles\\employee.json");){
			Object javaObj = jsonparser.parse(reader); // returns JAVA object
			
			JSONObject empjsonobj = (JSONObject) javaObj;
			
			String fName = (String) empjsonobj.get("firstName");
			
			String lName = (String) empjsonobj.get("lastName");
			
			System.out.println("FirstName-"+fName);
			
			JSONArray array = (JSONArray) empjsonobj.get("address");
            for(int i=0; i< array.size(); i++) {
            	
            	JSONObject address = (JSONObject) array.get(i);
            	
            	String street = (String) address.get("street");
    			
    			System.out.println("Street-"+street);            	
            }
		}catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
       // Write JSON to a file
		
        JSONObject obj = new JSONObject();
        obj.put("name", "test.com");
        obj.put("age", 100);

        JSONArray list1 = new JSONArray();
        list1.add("msg 1");
        list1.add("msg 2");
        list1.add("msg 3");

        obj.put("messages", list1);

        try (FileWriter file = new FileWriter(".\\jsonfiles\\test.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
		
		
		/////Using gson-2.10.1
        
        Employee e3 = new Employee(103, "akk");
        
        Gson gson = new Gson();
        
        String jsonStr = gson.toJson(e3);
        
        
        System.out.println(jsonStr);
        
        jsonStr = gson.toJson(list);
        
        System.out.println(jsonStr);
        
        
		
		
		
		/* Object
		{
			"employee" : {"id":100,"name":"ak"}
		}
		
		String
		
		{
			"name" : "ak"
		}
		
		number
		
		{
			"age" : 30 
			
		}
		
		
		Array

		{
		
		“employees" : ["John", "Anna", "Peter"]
		
		}
		
		Boolean
		
		Example:
		
		{"sale":true }
		
		Null
		
		{"middlename":null }

		
		Data should be in name/value pairs
		Data should be separated by commas
		Curly braces should hold objects
		Square brackets hold arrays
		
		{"employees":[    
					    {"name":"Ram", "email":"ram@gmail.com", "age":23},    
					    {"name":"Shyam", "email":"shyam23@gmail.com", "age":28},  
					    {"name":"John", "email":"john@gmail.com", "age":33},    
					    {"name":"Bob", "email":"bob32@gmail.com", "age":41}   
					]}  
					
					
		JSON Path

		= JSONPath is a query language for JSON, similar to XPath for XML.
		
		= JSONPath Expression
		
		= A JSONPath expression specifies a path to an element (or a set of elements) in a JSON structure.
		Paths can use the dot notation:
		
		$.store.book[0].title
		
		or the bracket notation:
		$['store']['book'][0]['title’]
		
		= $ represents the root object or array and can be omitted.
		For example, $.foo.bar and foo.bar are the same,
		
		and so are $[0].status and [0].status

http://jsonpath.com/?

https://jsonpathfinder.com/

chrome extensions - search in google as jsonpathfinder

		*/
		
	}
	
	

}
//jsonformatter - To validate JSON

//https://jsoneditoronline.org/#left=local.leteyu

class Employee{
	
	private int id;
	private String name;
	
	public Employee() {
		super();
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}