import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UserTests extends BaseTest {

    @Test
    public void testCreateUser() {
        String requestBody = "{" +
                "\"id\": 123," +
                "\"username\": \"testuser\"," +
                "\"firstName\": \"Test\"," +
                "\"lastName\": \"User\"," +
                "\"email\": \"testuser@example.com\"," +
                "\"password\": \"password123\"," +
                "\"phone\": \"1234567890\"," +
                "\"userStatus\": 1" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/user");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("message"), "123");
    }

    @Test
    public void testGetUser() {
        Response response = given()
                .when()
                .get("/user/testuser");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("username"), "testuser");
    }

    @Test
    public void testUpdateUser() {
        String updatedBody = "{" +
                "\"firstName\": \"UpdatedTest\"," +
                "\"lastName\": \"UpdatedUser\"" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put("/user/testuser");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete("/user/testuser");

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
