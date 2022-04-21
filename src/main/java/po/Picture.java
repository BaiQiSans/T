package po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Picture {
    private int id;
    private String picturePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }

    public static Picture initialize(ResultSet resultSet)
    {
        try {
            Picture picture = new Picture();
            picture.id = resultSet.getInt("pk_id");
            picture.picturePath = resultSet.getString("picture_path");
            return picture;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
