package activities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        // Build RequestSpecification
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();

        // Build ResponseSpecification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] petData() {
        return new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
    }

    @Test(priority = 1)
    public void testPostRequest() {
        // Pet 1
        String pet1 = "{ \"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\" }";
        given().spec(requestSpec)
                .body(pet1)
        .when()
                .post()
        .then()
                .spec(responseSpec)
                .body("id", equalTo(77232))
                .body("name", equalTo("Riley"));

        // Pet 2
        String pet2 = "{ \"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\" }";
        given().spec(requestSpec)
                .body(pet2)
        .when()
                .post()
        .then()
                .spec(responseSpec)
                .body("id", equalTo(77233))
                .body("name", equalTo("Hansel"));
    }

    @Test(priority = 2, dataProvider = "petData")
    public void testGetRequest(int id, String name, String status) {
        given().spec(requestSpec)
                .pathParam("petId", id)
        .when()
                .get("/{petId}")
        .then()
                .spec(responseSpec)
                .body("id", equalTo(id))
                .body("name", equalTo(name))
                .body("status", equalTo(status));
    }

    @Test(priority = 3, dataProvider = "petData")
    public void testDeleteRequest(int id, String name, String status) {
        given().spec(requestSpec)
                .pathParam("petId", id)
        .when()
                .delete("/{petId}")
        .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo(String.valueOf(id)));
    }

    @AfterClass
    public void teardown() {
        System.out.println("Activity3 tests completed.");
    }
}
