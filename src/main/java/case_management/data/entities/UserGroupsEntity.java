package case_management.data.entities;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Data
@Table(name = "user_groups", schema = "inc_db", catalog = "postgres")
public class UserGroupsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "rec_time")
    private Timestamp recTime;

    @Basic
    @Column(name = "title")
    private String title;
}
