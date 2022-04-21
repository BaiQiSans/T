package po;

import ann.DBName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Review {
    @DBName("pk_id")
    private int id;
    @DBName("scrip_id")
    private int scripId;
    @DBName("user_id")
    private int userId;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScripId() {
        return scripId;
    }

    public void setScripId(int scripId) {
        this.scripId = scripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "review{" +
                "id=" + id +
                ", scripId=" + scripId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }

    public static Review initialize(ResultSet resultSet)
    {
        try {
            Review review = new Review();
            review.id = resultSet.getInt("pk_id");
            review.scripId = resultSet.getInt("scrip_id");
            review.userId = resultSet.getInt("user_id");
            review.content = resultSet.getString("content");
            return review;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
