package Reqres.TestSettings;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;

public class TestSettings {
    protected RequestSpecification requestSpec;

    private final String baseURI = "https://reqres.in";


    @BeforeTest
    public void configureSpecs() {
         requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }
}
