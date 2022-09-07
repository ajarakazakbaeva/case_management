package case_management.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users", schema = "inc_db", catalog = "postgres")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Basic
    @Column(name = "rec_time")
    @CreationTimestamp
    private Timestamp recTime;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;


    @Basic
    @Column(name = "group_id")
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


    public long getId() {
        return id;
    }


    public int getGroupId() {
        return groupId;
    }


}
