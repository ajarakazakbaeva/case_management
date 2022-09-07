package case_management.data.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "incidents_change_logs", schema = "inc_db", catalog = "postgres")
public class IncidentsChangeLogsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "rec_time")
    private Timestamp recTime;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "log")
    private String log;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRecTime() {
        return recTime;
    }

    public void setRecTime(Timestamp recTime) {
        this.recTime = recTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncidentsChangeLogsEntity that = (IncidentsChangeLogsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (recTime != null ? !recTime.equals(that.recTime) : that.recTime != null) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (recTime != null ? recTime.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (log != null ? log.hashCode() : 0);
        return result;
    }
}
