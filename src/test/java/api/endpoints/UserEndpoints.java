package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
//UserEndPoints.java
//created for perform create,Read,Upadte,Delete requests t the user API

import api.payload.User;

public class UserEndpoints {

public static Response createUser(User payload){

 Response response=given()
.contentType(ContentType.JSON)
.accept(ContentType.JSON)
.body(payload)

.when()
.post(Routes.post_url);
return response;
}


public static Response readUser(String userName){  
                                                  
 Response response=given()                        
.pathParam("username", userName)                                            
                                    
.when()                                           
.get(Routes.get_url);                          
return response;                                  
}                                                 
public static Response updateUser(String userName, User payload){
                                                
 Response response=given()                      
.contentType(ContentType.JSON)                  
.accept(ContentType.JSON)                       
.pathParam("username", userName)
.body(payload)                                  

.when()                                         
.put(Routes.update_url);                         
return response;                                
} 

public static Response deleteUser(String userName){ 
                                                  
 Response response=given()                        
.pathParam("username", userName)                       
                                                  
.when()                                           
.delete(Routes.delete_url);                           
return response;                                  
} 
}