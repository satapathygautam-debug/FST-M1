package activities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {

    // Shared petId for all tests
    private static int petId = 77232;

    @BeforeClass
    public void setup() {
        // Base URI setup
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
    }

    @Test(priority = 1)
    public void testPostRequest() {
        String requestBody = "{\n" +
                "    \"id\": " + petId + ",\n" +
                "    \"name\": \"Riley\",\n" +
                "    \"status\": \"alive\"\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post()
        .then()
            .statusCode(200)
            .body("id", equalTo(petId))
            .body("name", equalTo("Riley"))
            .body("status", equalTo("alive"));
    }

    @Test(priority = 2)
    public void testGetRequest() {
        given()
            .pathParam("petId", petId)
        .when()
            .get("/{petId}")
        .then()
            .statusCode(200)
            .body("id", equalTo(petId))
            .body("name", equalTo("Riley"))
            .body("status", equalTo("alive"));
    }

    @Test(priority = 3)
    public void testDeleteRequest() {
        Response response = 
            given()
                .pathParam("petId", petId)
            .when()
                .delete("/{petId}");

        response.then()
            .statusCode(200)
            .body("code", equalTo(200))
            .body("message", equalTo(String.valueOf(petId)));
    }

    @AfterClass
    public void teardown() {
        // Any cleanup logic if needed
        System.out.println("Activity1 tests completed.");
    }
}
