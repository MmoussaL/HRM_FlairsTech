package BonusTask;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RESTAssuredTask {

    int id;
    // Base URI for all the APIs
    static {
        RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com/web/index.php";
    }

    // 1. Validation API
    @Test (priority = 0)
    public void validateLogin() {
        Response response = given()
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .header("accept-language", "en-US,en;q=0.9,ar;q=0.8")
                .header("cache-control", "max-age=0")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("cookie", "orangehrm=318411a45f6c26eef1d9b5bae29c0c9c")
                .header("origin", "https://opensource-demo.orangehrmlive.com")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36")
                .formParam("_token", "c05489ab6e76ef80ccb7cf640381e72._vpWrGNJip7BpXPb3LuZTyjUJTPdS9HQMGhLW3e62qU.nJI62Rd_7K2b1kKSqdfpF1-VemK-M7OfXywjHR7Rt8qTrjfGNiTY34TWIg")
                .formParam("username", "Admin")
                .formParam("password", "admin123")
                .when()
                .post("/auth/validate")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    // 2. Adding Candidate API
    @Test(priority = 1)
    public void addCandidate() {
        String requestBody = "{\n" +
                "  \"firstName\": \"noha\",\n" +
                "  \"middleName\": \"no\",\n" +
                "  \"lastName\": \"mo\",\n" +
                "  \"email\": \"test@test.com\",\n" +
                "  \"contactNumber\": null,\n" +
                "  \"keywords\": null,\n" +
                "  \"comment\": null,\n" +
                "  \"dateOfApplication\": \"2024-09-22\",\n" +
                "  \"consentToKeepData\": false\n" +
                "}";

        Response response = given()
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("cookie", "orangehrm=c125bc6e437ee1e99f0f044de0a563c5")
                .header("origin", "https://opensource-demo.orangehrmlive.com")
                .body(requestBody)
                .when()
                .post("/api/v2/recruitment/candidates")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
        Integer extractedId = response.jsonPath().get("data.id");
        if (extractedId != null) {
            id = extractedId;
            System.out.println("Extracted ID: " + id);
        } else {
            System.out.println("ID not found in the response.");
        }
    }

    // 3. Deleting Candidate API
    @Test (priority = 2)
    public void deleteCandidate() {
        String requestBody = "{ids: [" + id + "]}";

        Response response = given()
                .header("accept", "application/json, text/plain, */*")
                .header("content-type", "application/json")
                .header("cookie", "orangehrm=c125bc6e437ee1e99f0f044de0a563c5")
                .header("origin", "https://opensource-demo.orangehrmlive.com")
                .body(requestBody)
                .when()
                .delete("/api/v2/recruitment/candidates")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
    }
}

