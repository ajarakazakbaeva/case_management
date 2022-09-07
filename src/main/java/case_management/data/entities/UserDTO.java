package case_management.data.entities;

public class UserDTO {
    private String username;
    private String password;
    private int groupId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroupId() { return groupId; }
}
