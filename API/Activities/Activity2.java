package activities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {

    private static String username = "justinc"; // must match JSON file
    private static int userId = 9901;           // must match JSON file

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
    }

    @Test(priority = 1)
    public void testPostRequest() {
        File jsonFile = new File("src/test/resources/userInfo.json");

        given()
            .contentType(ContentType.JSON)
            .body(jsonFile)
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("message", equalTo(String.valueOf(userId)));
    }

    @Test(priority = 2)
    public void testGetRequest() throws IOException {
        Response response =
            given()
                .pathParam("username", username)
            .when()
                .get("/{username}");

        response.then()
            .statusCode(200)
            .body("id", equalTo(userId))
            .body("username", equalTo(username))
            .body("firstName", equalTo("Justin"))
            .body("lastName", equalTo("Case"))
            .body("email", equalTo("justincase@mail.com"))
            .body("password", equalTo("password123"))
            .body("phone", equalTo("9812763450"));

        // Write response to external JSON file
        FileWriter writer = new FileWriter("src/test/resources/getUserResponse.json");
        writer.write(response.getBody().asPrettyString());
        writer.close();
    }

    @Test(priority = 3)
    public void testDeleteRequest() {
        given()
            .pathParam("username", username)
        .when()
            .delete("/{username}")
        .then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("message", equalTo(username));
    }

    @AfterClass
    public void teardown() {
        System.out.println("Activity2 tests completed.");
    }
}
