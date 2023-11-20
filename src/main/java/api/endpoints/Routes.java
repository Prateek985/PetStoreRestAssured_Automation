package api.endpoints;

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user
	
	//Create_user
	public static String Post_url = base_url+"/user";
	//get_user
	public static String get_url = base_url+"/user/{username}";
	//update_user
	public static String update_url = base_url+"/user/{username}";
	//delete_user
	public static String delete_url = base_url+"/user/{username}";
}
