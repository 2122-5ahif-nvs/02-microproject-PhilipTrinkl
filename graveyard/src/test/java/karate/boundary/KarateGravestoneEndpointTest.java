package karate.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class KarateGravestoneEndpointTest {
    @Test
    public void testgravestoneEndpoint() {
        given().when().get("/gravestone")
                .then()
                .statusCode(200);
    }

    @Karate.Test
    Karate addNewBookTest() {return Karate.run("gravestone.feature").relativeTo(getClass());}

}