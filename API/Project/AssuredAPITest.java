import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssuredAPITest {

    private RequestSpecification requestSpec;
    private String sshKey = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAg...."; // Replace with your public key
    private int keyId;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token YOUR_PERSONAL_ACCESS_TOKEN") // Replace with your token
                .build();
    }

    @Test(priority = 1)
    public void testAddSSHKey() {
        String requestBody = "{ \"title\": \"TestAPIKey\", \"key\": \"" + sshKey + "\" }";

        Response response = RestAssured.given()
                .spec(requestSpec)
                .body(requestBody)
                .post("/user/keys");

        response.prettyPrint();
        keyId = response.jsonPath().getInt("id");

        Reporter.log("POST Response: " + response.asString(), true);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201");
    }

    @Test(priority = 2, dependsOnMethods = "testAddSSHKey")
    public void testGetSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .get("/user/keys/{keyId}");

        response.prettyPrint();
        Reporter.log("GET Response: " + response.asString(), true);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
    }

    @Test(priority = 3, dependsOnMethods = "testGetSSHKey")
    public void testDeleteSSHKey() {
        Response response = RestAssured.given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Response: " + response.asString(), true);
        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204");
    }
}
