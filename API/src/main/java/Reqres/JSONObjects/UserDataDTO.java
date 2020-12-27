package Reqres.JSONObjects;

public class UserDataDTO {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public UserDataDTO(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        first_name = firstName;
        last_name = lastName;
        this.avatar = avatar;
    }


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
