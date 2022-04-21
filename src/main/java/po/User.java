package po;

import ann.DBName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    @DBName("pk_id")
    private int id;
    @DBName("avatar_path")
    private String avatarPath;
    private String name;
    @DBName("private_secret")
    private String privateSecret;
    private String introduction;
    @DBName("is_admin")
    private boolean isAdmin;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivateSecret() {
        return privateSecret;
    }

    public void setPrivateSecret(String privateSecret) {
        this.privateSecret = privateSecret;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatarPath='" + avatarPath + '\'' +
                ", name='" + name + '\'' +
                ", privateSecret='" + privateSecret + '\'' +
                ", introduction='" + introduction + '\'' +
                ", permissionGroup=" + isAdmin +
                '}';
    }

    public static User initialize(ResultSet resultSet)
    {
        try {
            User user = new User();
            user.id = resultSet.getInt("pk_id");
            user.avatarPath = resultSet.getString("avatar_path");
            user.name = resultSet.getString("name");
            user.privateSecret = resultSet.getString("private_secret");
            user.introduction = resultSet.getString("introduction");
            user.isAdmin = resultSet.getBoolean("is_admin");
            user.email = resultSet.getString("email");
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
