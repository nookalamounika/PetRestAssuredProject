package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import api.payload.User;


public class DDTests {

	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
  public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph) {

User userPayload = new User();

userPayload.setId(Integer.parseInt(userID));            
userPayload.setUsername(userName);          
 userPayload.setFirstName(fname);       
 userPayload.setLastName(lname);         
 userPayload.setEmail(useremail);
 userPayload.setPassword(pwd); 
  userPayload.setPhone(ph);   

Response response=UserEndpoints.createUser(userPayload);    
 response.then().log().all();                                 
Assert.assertEquals(response.getStatusCode(),200);          	
}

@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
public void testDeleteUserByName(String userName) {


Response response = UserEndpoints.deleteUser(userName);
Assert.assertEquals(response.getStatusCode(),200); 





}
}
