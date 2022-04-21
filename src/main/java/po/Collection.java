package po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Collection {
    private int userId;
    private int scripId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScripId() {
        return scripId;
    }

    public void setScripId(int scripId) {
        this.scripId = scripId;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "userId=" + userId +
                ", scripId=" + scripId +
                '}';
    }

    public static Collection initialize(ResultSet resultSet)
    {
        try {
            Collection collection = new Collection();
            collection.userId = resultSet.getInt("user_id");
            collection.scripId = resultSet.getInt("scrip_id");
            return collection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
