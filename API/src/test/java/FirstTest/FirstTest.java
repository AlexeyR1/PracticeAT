package FirstTest;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class FirstTest {
    private final String baseURL = "http://demo.guru99.com/V4/sinkministatement.php";
    private final String url = baseURL + "?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";


    @Test
    public void getResponseWhole() {
        given()
                .when().get(url)
                .then().log().all();
    }


    @Test
    public void getResponseBody() {
        given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(baseURL)
                .then().log().body();
    }


    @Test
    public void getResponseStatus() {
        int expectedResponseStatus = 200;

        given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(baseURL)
                .then().statusCode(expectedResponseStatus);
    }


    @Test
    public void getResponseHeaders() {
        System.out.println("headers: " + get(url).then().extract().headers());
    }


    @Test
    public void getResponseTime() {
        System.out.println("The time taken to fetch the response " + get(url).timeIn(TimeUnit.MILLISECONDS) + " ms");
    }


    @Test
    public void getResponseContentType() {
        System.out.println("content type: " + get(url).contentType());
    }
}
