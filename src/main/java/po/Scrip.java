package po;

import ann.DBName;
import ann.IDS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Scrip {
    @DBName("pk_id")
    private int id;
    @DBName("user_id")
    private int userId;
    @DBName("quote_scrip_id")
    private int quoteScripId;
    @DBName("is_private")
    private boolean isPrivate;
    private String content;
    @IDS
    @DBName("picture_ids")
    private List<UUID> pictureIds;
    private String title;
    private int readership;
    @DBName("is_audit_status")
    private boolean isAuditStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuoteScripId() {
        return quoteScripId;
    }

    public void setQuoteScripId(int quoteScripId) {
        this.quoteScripId = quoteScripId;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<UUID> getPictureIds() {
        return pictureIds;
    }

    public void setPictureIds(List<UUID> pictureIds) {
        this.pictureIds = pictureIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadership() {
        return readership;
    }

    public void setReadership(int readership) {
        this.readership = readership;
    }

    public boolean isAuditStatus() {
        return isAuditStatus;
    }

    public void setAuditStatus(boolean auditStatus) {
        this.isAuditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return "Scrip{" +
                "id=" + id +
                ", userId=" + userId +
                ", quoteScripId=" + quoteScripId +
                ", isPrivate=" + isPrivate +
                ", content='" + content + '\'' +
                ", pictureIds=" + pictureIds +
                ", title='" + title + '\'' +
                ", readership=" + readership +
                ", isAuditStatus=" + isAuditStatus +
                '}';
    }

    public static Scrip initialize(ResultSet resultSet)
    {
        try {
            Scrip scrip = new Scrip();
            scrip.id = resultSet.getInt("pk_id");
            scrip.userId = resultSet.getInt("user_id");
            scrip.quoteScripId = resultSet.getInt("quote_scrip_id");
            scrip.isPrivate = resultSet.getBoolean("is_private");
            scrip.content = resultSet.getString("content");
//            scrip.pictureIds= resultSet.getString("picture_ids");
            scrip.pictureIds = new ArrayList<>();
            for (String pictureId : resultSet.getString("picture_ids").split(", |,")) {
                scrip.pictureIds.add(UUID.fromString(pictureId));
            }
            scrip.title = resultSet.getString("title");
            scrip.readership = resultSet.getInt("readership");
            scrip.isAuditStatus = resultSet.getBoolean("is_audit_status");
            return scrip;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
