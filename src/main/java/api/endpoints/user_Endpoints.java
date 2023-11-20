package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import api.payload.User;




//user_End_points
// created for performing CRUD operations
public class user_Endpoints {
	
	public static Response createUser(User payload)
	{
	
		Response response =given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)	
		
		.when()
		   .post(Routes.Post_url);
		
		
		return response;
	}
	
	public static Response readUser(String username)
	{
	
		Response response =given()
		      .pathParam("username", username)	
		
		.when()
		   .get(Routes.get_url);
		
		
		return response;
	}
	public static Response updateUser(String Username,User payload)
	{
	
		Response response =given()
				.contentType(ContentType.JSON)
	      .accept(ContentType.JSON)
	      .pathParam("username", Username)
	      .body(payload)	
	      
		.when()
		   .put(Routes.update_url);
		
		return response;
	}
	public static Response deleteUser(String Username)
	{
	
		Response response =given()
	      .pathParam("username", Username)	
	      
		.when()
		   .delete(Routes.delete_url);
		
		return response;
	}
}
