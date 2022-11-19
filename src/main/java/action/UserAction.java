package action;

import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.UserRequest;

import static io.restassured.RestAssured.given;

public class UserAction {
    String baseUri = "http://stellarburgers.nomoreparties.site/api/";

    //create
    public Response create(UserRequest userRequest){
        return given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(userRequest)
                .post("auth/register");
    }

    //login
    public Response login(LoginRequest loginRequest){
        return given()
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .body(loginRequest)
                .post("auth/login");
    }

    //delete
    public Response delete(String accessToken){
        return given()
                .header("Authorization", accessToken)
                .header("Content-type", "application/json")
                .baseUri(baseUri)
                .delete("auth/user");
    }

}
