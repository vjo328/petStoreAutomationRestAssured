package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;


import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

//Here we will create the tests using Dataproviders and XLUtility
public class DDTests {
	
	Response response;
	User userPayload =  new User();
	
	@Test(priority = 1, dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID,String UserName,String FirstName,String LastName,String Email,String pwd,String ph) {
	
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
}
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String userName) {
		
		response=UserEndPoints.deleteUser(userName);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
}