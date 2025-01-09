package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.User;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;


public class userAuthenticationSteps {
    private static final String BASE_URI = "https://dummyjson.com/";
    private static final String BASE_PATH = "auth/login";
    protected JSONObject jsonObject;
    private Response response;
    private Response userResponse;
    private String accessToken;

    @Given("User log in api is available")
    public void setUp() {
    }

    @When("I send a POST request with {string} and {string}")
    public void sendingPostRequest(String email, String password) {
        jsonObject = new JSONObject();
        jsonObject.put("username", email);
        jsonObject.put("password", password);
        jsonObject.put("expiresInMins", 30);

        response = given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .post();
    }

    @Then("The response status code is {int}")
    public void responseCodeValidation(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode, "Returned status code is not correct");

        JsonPath jsonPath = response.jsonPath();
        accessToken = jsonPath.getString("accessToken");
    }

    @When("I send a GET request with gained token")
    public void sendingGetRequest() {
        userResponse = given()
                .baseUri(BASE_URI)
                .basePath("auth/me")
                .header("Authorization", accessToken)
                .get();
    }

    @Then("The response returns correct user info")
    public void validatingUserInfoResponse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User expectedUser = objectMapper.readValue(new File("src/test/resources/environment/userInfo.json"), User.class);
        User actualUser = userResponse.as(User.class);

        Assert.assertEquals(actualUser, expectedUser, "Returned user info is not correct");
    }

}
