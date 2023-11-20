package api.payload;

//JSON = java script object notation
//POJO = pale older java object
public class User {
	
      int id;
      String username;
	  String firstName;
	  String lastName;
	  String email;
	  String password;
	  String phone;
	  int userStatus = 0;
	
	  
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String i) {
		this.firstName = i;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
		

}
