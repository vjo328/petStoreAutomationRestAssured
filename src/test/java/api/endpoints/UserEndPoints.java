package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// here we perform CRUD requests for the user api
public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.user_post_url);

		return response;

	}

	public static Response getUser(String userName) {

		Response response = given().pathParam("username", userName)

				.when().get(Routes.user_get_url);

		return response;

	}

	public static Response updateUser(User payload, String userName) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(Routes.user_update_url);

		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName)

				.when().delete(Routes.user_delete_url);

		return response;

	}

}
