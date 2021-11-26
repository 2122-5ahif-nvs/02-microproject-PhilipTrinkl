package karate.boundary;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class KarateEmployeeEndpointTest {
    @Test
    public void testEmployeeEndpoint() {
        given().when().get("/employee")
                .then()
                .statusCode(200);
    }

    @Karate.Test
    Karate AddNewEmployeeTest() {return Karate.run("employee.feature").relativeTo(getClass());}

    @Karate.Test
    Karate deleteEmployeeTest() {return Karate.run("employee.feature").relativeTo(getClass());}
}