package action;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.UserRequest;

import static io.restassured.RestAssured.given;

public class UserAction {
	String baseUri = "http://stellarburgers.nomoreparties.site/api/";

	@Step("Client registration")
	public void create(UserRequest userRequest) {
		given()
				.header("Content-type", "application/json")
				.baseUri(baseUri)
				.body(userRequest)
				.post("auth/register");
	}

	@Step("Client authorization")
	public Response login(LoginRequest loginRequest) {
		return given()
				.header("Content-type", "application/json")
				.baseUri(baseUri)
				.body(loginRequest)
				.post("auth/login");
	}

	@Step("Deleting a client")
	public void delete(String accessToken) {
		given()
				.header("Authorization", accessToken)
				.header("Content-type", "application/json")
				.baseUri(baseUri)
				.delete("auth/user");
	}
}
