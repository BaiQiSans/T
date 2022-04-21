package po;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EnvelopeScrip {
    private int envelopeId;
    private int scripId;

    public int getEnvelopeId() {
        return envelopeId;
    }

    public void setEnvelopeId(int envelopeId) {
        this.envelopeId = envelopeId;
    }

    public int getScripId() {
        return scripId;
    }

    public void setScripId(int scripId) {
        this.scripId = scripId;
    }

    @Override
    public String toString() {
        return "envelopeScrip{" +
                "envelopeId=" + envelopeId +
                ", scripId=" + scripId +
                '}';
    }

    public static EnvelopeScrip initialize(ResultSet resultSet)
    {
        try {
            EnvelopeScrip envelopescrip = new EnvelopeScrip();
            envelopescrip.envelopeId = resultSet.getInt("envelope_id");
            envelopescrip.scripId = resultSet.getInt("scrip_id");
            return envelopescrip;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
