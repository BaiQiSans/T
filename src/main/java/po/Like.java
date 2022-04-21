package po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Like {
    private int userId;
    private int scripId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public int getScripId() {
        return scripId;
    }

    public void setScripId(int scripId) {
        this.scripId = scripId;
    }

    @Override
    public String toString() {
        return "Like{" +
                "userId=" + userId +
                ", scripId=" + scripId +
                '}';
    }

    public static Like initialize(ResultSet resultSet)
    {
        try {
            Like like = new Like();
            like.userId = resultSet.getInt("user_id");
            like.scripId = resultSet.getInt("scrip_id");
            return like;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
