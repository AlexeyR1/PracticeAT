package Reqres;

import Reqres.EndPoints.EndPoints;
import Reqres.JSONObjects.UserDTO;
import Reqres.JSONObjects.UserDataDTO;
import Reqres.RequestHelpers.UsersRequestHelper;
import Reqres.TestSettings.TestSettings;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;

public class CRUDTest extends TestSettings {
    @Test
    public void addUser() {
        String name = "John";
        String job = "surgeon";

        UserDTO user = new UserDTO(name, job);
        UserDTO receivedUser = UsersRequestHelper.addUser(requestSpec, user, String.format(EndPoints.users));

        Assert.assertEquals(receivedUser.getName(), user.getName());
        Assert.assertEquals(receivedUser.getJob(), user.getJob());
    }


    @Test
    public void getUser() {
        int expectedId = 2;
        String expectedFirstName = "Janet";
        String expectedLastName = "Weaver";
        String expectedEmail = "janet.weaver@reqres.in";
        String expectedAvatar = "https://reqres.in/img/faces/2-image.jpg";

        String json = UsersRequestHelper.getUser(requestSpec, String.format(EndPoints.userByID, 2));
        UserDataDTO userData = from(json).getObject("data", UserDataDTO.class);

        Assert.assertEquals(userData.getId(), expectedId);
        Assert.assertEquals(userData.getFirstName(), expectedFirstName);
        Assert.assertEquals(userData.getLastName(), expectedLastName);
        Assert.assertEquals(userData.getEmail(), expectedEmail);
        Assert.assertEquals(userData.getAvatar(), expectedAvatar);
    }


    @Test
    public void getAllUsers() {
        String json = UsersRequestHelper.getUser(requestSpec, String.format(EndPoints.users));
        UserDataDTO[] usersData = from(json).getObject("data", UserDataDTO[].class);

        for (UserDataDTO userData : usersData) {
            Assert.assertNotEquals(userData.getId(), 0);
            Assert.assertNotNull(userData.getFirstName());
            Assert.assertNotNull(userData.getLastName());
            Assert.assertNotNull(userData.getEmail());
            Assert.assertNotNull(userData.getAvatar());
        }
    }


    @Test
    public void updateUser() {
        String name = "morpheus";
        String job = "zion resident";

        UserDTO user = new UserDTO(name, job);
        UserDTO updatedUser = UsersRequestHelper.updateUser(requestSpec, user, String.format(EndPoints.userByID, 2));

        Assert.assertEquals(updatedUser.getName(), user.getName());
        Assert.assertEquals(updatedUser.getJob(), user.getJob());
    }


    @Test
    public void deleteUser() {
        given().spec(requestSpec)
                .when().delete(String.format(EndPoints.userByID, 2))
                .then().statusCode(204);
    }
}
