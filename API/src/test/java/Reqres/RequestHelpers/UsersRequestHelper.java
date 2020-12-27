package Reqres.RequestHelpers;

import Reqres.JSONObjects.UserDTO;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class UsersRequestHelper {
    public static String getUser(RequestSpecification requestSpec, String endPoint)
    {
        return given()
                .spec(requestSpec)
                .when()
                .get(endPoint)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asPrettyString();
    }


    public static UserDTO addUser(RequestSpecification requestSpec, UserDTO user, String endPoint)
    {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .put(endPoint)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(UserDTO.class);
    }


    public static UserDTO updateUser(RequestSpecification requestSpec, UserDTO user, String endPoint)
    {
        return addUser(requestSpec, user, endPoint);
    }
}
