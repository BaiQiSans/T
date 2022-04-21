package po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Envelope {
    private int id;
    private String name;
    private String introduction;
    private boolean isPrivate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", isPrivate=" + isPrivate +
                '}';
    }

    public static Envelope initialize(ResultSet resultSet)
    {
        try {
            Envelope envelope = new Envelope();
            envelope.id = resultSet.getInt("pk_id");
            envelope.name = resultSet.getString("name");
            envelope.introduction = resultSet.getString("introduction");
            envelope.isPrivate = resultSet.getBoolean("is_private");
            return envelope;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
