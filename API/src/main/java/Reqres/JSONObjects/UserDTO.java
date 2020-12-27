package Reqres.JSONObjects;

public class UserDTO {
    private String name;
    private String job;


    public UserDTO(String name, String job)
    {
        this.name = name;
        this.job = job;
    }


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
