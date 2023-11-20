package MyTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.user_Endpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

   Faker faker;
   User userPayLoad;
	
   public Logger logger;
	
  @BeforeClass	
  public void SetupData() {
	  
	  faker=new Faker();
	  userPayLoad=new User();
	  
	  
	  
	  userPayLoad.setId(faker.idNumber().hashCode());
	  userPayLoad.setUsername(faker.name().username());
	  userPayLoad.setFirstName(faker.name().firstName());
	  userPayLoad.setLastName(faker.name().lastName());
	  userPayLoad.setEmail(faker.internet().safeEmailAddress());
	  userPayLoad.setPassword(faker.internet().password(5, 15));
	  userPayLoad.setPhone(faker.phoneNumber().cellPhone());
	  
	 //logs
	  logger = LogManager.getLogger(this.getClass());
  }

  @Test(priority = 1)
  public void TestpostUser() 
  {
	  logger.info("************** Create User **************");
	  Response response=user_Endpoints.createUser(userPayLoad);
	  response.then().log().all();
	  
	  Assert.assertEquals(response.getStatusCode(), 200);
	  //Assert.assertEquals(response.getTime(), 1312);
	  logger.info("************** User is Created **************");
  }
  @Test(priority = 2)
  public void TestGetUserByName() 
  {
	  logger.info("************** Reading User Info**************");
	  Response response=user_Endpoints.readUser(this.userPayLoad.getUsername());
	  response.then().log().all();
	  response.getStatusCode();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  logger.info("************** User info is displayed **************");
	  
  }
  @Test(priority = 3)
  public void TestUpdateUserByName() 
  {
	  //updating the data 
	  logger.info("************** Updating the User**************");
	  userPayLoad.setFirstName(faker.name().firstName());
	  userPayLoad.setLastName(faker.name().lastName());
	  userPayLoad.setEmail(faker.internet().safeEmailAddress());
	  
	  Response response=user_Endpoints.updateUser(this.userPayLoad.getUsername(),userPayLoad);
	  response.then().log().all();
	  response.getStatusCode();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
	  //checking the data after updation 
	  Response responseAfterUpdate=user_Endpoints.readUser(this.userPayLoad.getUsername());
	  responseAfterUpdate.getStatusCode();
	  Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	  logger.info("************** User is Updated**************");
	  
  }
  @Test(priority = 4)
  public void TestDeleteUserByName() 
  {
	  logger.info("************** Deleting the user**************");
	  Response response=user_Endpoints.deleteUser(this.userPayLoad.getUsername());
	  response.getStatusCode();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  logger.info("************** User is Deleted**************");
	  
  }
}
